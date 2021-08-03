import React, { Component } from 'react';
import { View,StyleSheet, Text,  TouchableOpacity, TextInput } from 'react-native';
import axios from 'axios'

export default class Register extends Component {
  constructor(props) {
    super(props);
    this.state = {
        name:"",
        email:"",
        phone:"",
        address:"",
        password:""
    };
  }
  

  handleAdd(){
    axios.post('http://192.168.0.110:8080/user/register/',this.state)
    .then( (response) => {
      alert(response.data)
      this.props.navigation.replace("Home")
    })
    .catch(function (error) {
     console.log(error);
    })
  }

  render() {
    return (
        <View>

            <Text style={styles.judul}>REGISTRASI</Text>
            
            <Text style={styles.title}> Input Nama </Text>
            <TextInput style={styles.input} placeholder="Nama" onChangeText={(data)=>{this.setState({name:data})}}/>

            <Text style={styles.title}> Input Email </Text>
            <TextInput style={styles.input} placeholder="Email" onChangeText={(data)=>{this.setState({email:data})}}/>

            <Text style={styles.title}> Input Nomor Telepon </Text>
            <TextInput style={styles.input} placeholder="Nomor Telepon" onChangeText={(data)=>{this.setState({phone:data})}}/>

            <Text style={styles.title}> Input Alamat </Text>
            <TextInput style={styles.input} placeholder="Alamat" onChangeText={(data)=>{this.setState({address:data})}}/>

            <Text style={styles.title}> Input Password </Text>
            <TextInput style={styles.input} placeholder="Password" onChangeText={(data)=>{this.setState({password:data})}}/>

            <TouchableOpacity style={styles.button} onPress={this.handleAdd.bind(this)}><Text style={styles.title}>REGISTER</Text></TouchableOpacity>
          
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