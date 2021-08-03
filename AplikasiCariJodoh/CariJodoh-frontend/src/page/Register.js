import React, { Component } from 'react'
import { View, Text, TouchableOpacity, StyleSheet, Platform, Button, Image } from 'react-native'
import { TextInput } from 'react-native-gesture-handler';
import { connect } from 'react-redux'
import * as ImagePicker from 'expo-image-picker';
import * as Location from 'expo-location';
import { Picker } from '@react-native-picker/picker';
import axios from 'axios';

export class Register extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username:"",
            name:"",
            jeniskelamin:"",
            phone:"",
            umur:"",
            image:"https://png.pngtree.com/png-vector/20191009/ourmid/pngtree-user-icon-png-image_1796659.jpg",
            latitude:"",
            longitude:"",
        }
    }

    componentDidMount(){
        this.getPermission()
        this.getLocation()
    }

    async getPermission(){
        if (Platform.OS !== 'web') {
            const { status } = await ImagePicker.requestMediaLibraryPermissionsAsync();
            if (status !== 'granted') {
              alert('Sorry, we need camera roll permissions to make this work!');
            }
        }
    }

    async pickImage(){
        let result = await ImagePicker.launchImageLibraryAsync({
            mediaTypes: ImagePicker.MediaTypeOptions.All,
            allowsEditing: true,
            aspect: [4, 3],
            quality: 1,
          });
      
          console.log(result);
          
          if (!result.cancelled) {
              console.log(result.uri)
              this.setState({image:result.uri})
          }
    }
    
    async getLocation(){
        let { status } = await Location.requestForegroundPermissionsAsync();
        if (status !== "granted") {
          return;
        }
    
        let location = await Location.getCurrentPositionAsync({});
        console.log("Lokasinya anda :" + JSON.stringify(location));

        this.setState({
            latitude: location.coords.latitude,
            longitude:location.coords.longitude
        })
    };

    simpanData(){
        
        let formData = new FormData();
        let filename = this.state.image;
        console.log("nama gambar "+ filename.split('/').pop())
        formData.append('data',JSON.stringify(this.state))
        formData.append('file',{
            uri: this.state.image, //Your Image File Path
            type: 'image/jpeg', 
            name: filename.split('/').pop(),
         })
         
        axios.post('http://192.168.43.90:8080/user/',formData,{
            headers:{
                'Content-Type': 'multipart/form-data'
            }
        })
        .then((response)=>{
            alert(response.data)
            this.props.navigation.navigate("Home")
        })
        .catch((error)=>{
            console.log(error)
        })
    }

    render() {
        return (
            <View style={styles.viewStyle}>
                <Text> Username </Text>
                <TextInput placeholder="username anda" onChangeText={(value)=>{this.setState({username:value})}}/>

                <Text> Name </Text>
                <TextInput placeholder="masukan nama" onChangeText={(value)=>{this.setState({name:value})}}/>

                <Text> Jenis Kelamin </Text>
                <Picker
                    selectedValue={this.state.jeniskelamin}
                    style={{ height: 50, width: 300 }}
                    onValueChange={(itemValue) => this.setState({ jeniskelamin : itemValue })}>
                    <Picker.Item label="Masukan Pilihan"/>
                    <Picker.Item label="Laki laki" value="laki" />
                    <Picker.Item label="Perempuan" value="perempuan" />
                </Picker>

                <Text> Phone </Text>
                <TextInput placeholder="nomor handphone anda" onChangeText={(value)=>{this.setState({phone:value})}}/>

                <Text> Umur </Text>
                <TextInput placeholder="umur anda" onChangeText={(value)=>{this.setState({umur:value})}}/>

                <Button title="Pick an image from camera roll" onPress={()=>{this.pickImage()}} />
                <Image source={{ uri: this.state.image }} style={{ width: 200, height: 200,alignSelf:'center' }} />

                <TouchableOpacity style={styles.buttonStyle} onPress={()=>{this.simpanData()}}><Text style={styles.textStyle}>Submit</Text></TouchableOpacity>
            </View>
        )
    }
}

export default Register

const styles = StyleSheet.create({
    viewStyle:{
        margin:20,
    },

    buttonStyle:{
        borderWidth:10,
        borderColor:"red",
        margin:20
    },

    textStyle:{
        textAlign:'center',
    }


})