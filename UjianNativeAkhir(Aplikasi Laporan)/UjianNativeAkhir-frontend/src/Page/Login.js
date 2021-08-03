import React, { Component } from 'react';
import { View,StyleSheet, Text,  TouchableOpacity, TextInput } from 'react-native';
import axios from 'axios'

export default class Login extends Component {

  constructor(props) {
    super(props);
    this.state = {
        email:"",
        password:"",
        data:[]
    };
  }

componentDidMount() {
    this.handleGetData();
}

componentDidUpdate() {
    this.handleGetData();
    console.log('data state',this.state.email)
    console.log('data state',this.state.password)
}

  handleGetData(){
    axios.get(`http://192.168.0.110:8080/user/searchby/${this.state.email}/${this.state.password}`,this.state)
    .then((response)=>{
        console.log('ini getData' , response.data) 
        this.setState({data:response.data[0]})

    }).catch((err)=>{
        console.log(err)
    })
  }

  nextScreen(){
    if(!this.state.data){
        alert('Email Dan Password Salah')
        
    }else if(this.state.data.email == this.state.email && this.state.data.password == this.state.password){
        this.props.navigation.navigate('MainMenu')
    }
}

  render() {
    return (
        <View>

            <Text style={styles.judul}>LOGIN</Text>
            
            <Text style={styles.title}> Input Email </Text>
            <TextInput style={styles.input} placeholder="Nama" onChangeText={(data)=>{this.setState({email:data})}}/>

            <Text style={styles.title}> Input Password </Text>
            <TextInput style={styles.input} placeholder="Email" onChangeText={(data)=>{this.setState({password:data})}}/>

            <TouchableOpacity style={styles.button} onPress={()=>{this.nextScreen()}}><Text style={styles.title}>LOGIN</Text></TouchableOpacity>
          
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