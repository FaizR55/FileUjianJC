import React, { Component } from 'react';
import { View, StyleSheet, Text,  TouchableOpacity, TextInput, Alert } from 'react-native';
import axios from 'axios'
import { Picker } from '@react-native-picker/picker';
import * as Location from "expo-location";
import UploadImage from '../libs/UploadImage';

export default class Laporan extends Component {
  constructor(props) {
    super(props);
    this.state = {
        nama:"",
        kejadian:"",
        alamat:"",
        keterangan:"",
        foto:"",
        longitude:0.0,
        latitude:0.0,
        waktu: this.waktu
    };
  }
  
  jam = new Date().getHours();
  menit = new Date().getMinutes();

  waktu = `${this.jam}:${this.menit}`

componentDidMount(){
    console.log('waktu' , this.waktu)
    this.getLocation();
    //console.log('lat', this.state.latitude);
    //console.log('lon' ,this.state.longitude);
}

componentDidUpdate() {
  //this.handleInputData();
  //this.getLocation();
}

  handleAdd(){
    axios.post('http://192.168.0.110:8080/laporan/addLaporan/',this.state)
    .then( (response) => {
      alert(response.data)
      this.props.navigation.replace("MainMenu")
    })
    .catch(function (error) {
     console.log(error);
    })
  }

  getLocation = async () => {
    console.log("Test Lokasi");
    let { status } = await Location.getForegroundPermissionsAsync();
    if (status !== "granted") {
      alert("Permission to access location was denied");
      return;
    } 

    let location = await Location.getCurrentPositionAsync({});
    console.log("Lokasi anda :" + JSON.stringify(location));

    this.setState({latitude:location.coords.latitude, longitude:location.coords.longitude})
  };

  render() {
    return (
        <View>

            <Text style={styles.judul}>LAPORAN</Text>
            <Text>{this.state.latitude} </Text>
            <Text>{this.state.longitude} </Text>
            
            <Text style={styles.title}> Nama </Text>
            <TextInput style={styles.input} placeholder="Input Nama" onChangeText={(data)=>{this.setState({nama:data})}}/>

            <Text style={styles.title}> Kejadian </Text>
            <Picker
            style={styles.item}
            selectedValue={this.state.kejadian}
            onValueChange={(itemValue, itemIndex) =>
            this.setState({kejadian:itemValue})
            }>
              <Picker.Item label="Pemerkosaan" value="pemerkosaan" />
              <Picker.Item label="Perampokan" value="perampokan" />
              <Picker.Item label="Bencana" value="bencana" />
              <Picker.Item label="Pembunuhan" value="pembunuhan" />
            </Picker>

            <Text style={styles.title}> Alamat </Text>
            <TextInput style={styles.input} placeholder="Input Alamat" onChangeText={(data)=>{this.setState({alamat:data})}}/>

            <Text style={styles.title}> Keterangan </Text>
            <TextInput style={styles.input} placeholder="Input Keterangan" onChangeText={(data)=>{this.setState({keterangan:data})}}/>

            <Text style={styles.title}> Foto </Text>
            <UploadImage
/>

            <TouchableOpacity style={styles.button} onPress={this.handleAdd.bind(this)}><Text style={styles.title}>LAPORKAN</Text></TouchableOpacity>
          
        </View>
    );
  }
}

const styles = StyleSheet.create({
  item: {
    backgroundColor: '#f9c2ff',
    padding: 20,
    marginVertical: 8,
    marginHorizontal: 16,
  },
  title: {
    fontSize: 18,
  },
  button: {
    alignItems: "center",
    backgroundColor: "#DDDDDD",
    padding: 10,
  },
  input: {
    padding: 10,
  },
  judul: {
    fontSize: 40,
    padding: 10,
    textAlign: 'center',
  },
});