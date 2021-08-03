import React, { Component } from 'react'
import { SafeAreaView, View, FlatList, StyleSheet, Text, StatusBar, Image, TouchableOpacity, TextInput, Alert } from 'react-native';
import axios from 'axios'

export default class App extends Component {

    constructor(props) {
        super(props);
        this.state = { 
            data: [],
            namaService:""
        };

    }

    componentDidMount(){
      this.getData();
    }
    componentDidUpdate(){
      this.getData();
    }

    getData =()=>{
        //Make a request for a user with a given ID
        axios.get(`http://192.168.0.109:8080/service/${this.state.namaService}`)
        .then( (response) => {
          // console.log(response.data")
          let data=response.data;   
          this.setState({data:data}); 
        })
        .catch(function (error) {
        // handle error
         console.log(error);
        })
    }

    deleteData(id){
      console.log(id);
      axios.delete(`http://192.168.0.109:8080/service/deleteService/${id}`)
      .then( (response) => {
        // console.log(response.data")
          alert(response.data)
      })
      .catch(function (error) {
      // handle error
       console.log(error);
      })
    }

    renderItem = ({ item }) => (
        <View style={styles.item}>
            <Text style={styles.title}>Nama : {item.nama}</Text>
            <Text style={styles.title}>Email : {item.email}</Text>
            <Text style={styles.title}>Phone : {item.phone}</Text>
            <Text style={styles.title}>Address : {item.address}</Text>
            
            <TouchableOpacity onPress={()=>{this.props.navigation.navigate("UpdateData",item)}} style={styles.button}><Text style={styles.title}>Update</Text></TouchableOpacity>
            
            <TouchableOpacity  onPress={()=>{Alert.alert('Anda yakin menghapus data ini?',
              '...',[
                {text: 'TIDAK', onPress: () => console.warn('NO Pressed'), style: 'cancel'},
                {text: 'YA', onPress: () => this.deleteData(item.id)},
              ])}} 
              style={styles.button}>
                <Text style={styles.title}>Delete</Text>
            </TouchableOpacity>
              
        </View>
    )

    

    render() {
        return (
            <SafeAreaView style={styles.container}>
              <TextInput TextInput placeholder="Keyword" onChangeText={(data)=>{this.setState({namaService:data})}}/>
              <TouchableOpacity onPress={this.getData.bind(this)} style={styles.button}><Text style={styles.title}>Search</Text></TouchableOpacity>
              
              <FlatList 
                data={this.state.data}
                renderItem={this.renderItem}
                keyExtractor={item => item.id}
              />
              
              <TouchableOpacity onPress={()=>{this.props.navigation.navigate("AddData")}} style={styles.button}><Text style={styles.title}>REGISTER</Text></TouchableOpacity>
              <TouchableOpacity onPress={()=>{this.props.navigation.navigate("App")}} style={styles.button}><Text style={styles.title}>LIST</Text></TouchableOpacity>
            </SafeAreaView>
          );
    }
}

const styles = StyleSheet.create({

    container: {
      flex: 1,
      marginTop: StatusBar.currentHeight || 0,
    },
    item: {
      backgroundColor: '#2403fc',
      padding: 5,
      marginVertical: 8,
      marginHorizontal: 16,
      borderWidth: 5, 
      borderColor: "red",
    },
    title: {
      fontSize: 20,
    },
    button: {
      margin:10,
      alignItems: "center",
      backgroundColor: "#DDDDDD",
      padding: 5,
    },

  });