import React, { Component } from 'react'
import { View,StyleSheet, Text,  TouchableOpacity, TextInput } from 'react-native';
import axios from 'axios'
import { parse } from '@babel/core';

export class UpdateData extends Component {
    
  constructor(props) {
        super(props);
        this.state = {
            id:this.props.route.params.id,
            nama:this.props.route.params.nama,
            email:this.props.route.params.email,
            phone:this.props.route.params.phone,
            address:this.props.route.params.address
        }
    }

    handleUpdate(){
        // console.log(this.state)
        axios.put(`http://192.168.0.109:8080/service/updateService/${this.state.id}`,this.state)
        .then( (response) => {
          // console.log(response)
          alert(response.data)
          this.props.navigation.navigate("App")
        })
        .catch(function (error) {
        // handle error
         console.log(error);
        })
    }
    
    render() {
      return (
          <View>
              <Text style={styles.title}> Input Nama </Text>
              <TextInput value={this.state.nama} style={styles.input}  placeholder="Nama" onChangeText={(data)=>{this.setState({nama:data})}}/>
              <Text style={styles.title}> Input Email </Text>
              <TextInput value={this.state.email} style={styles.input} placeholder="Email" onChangeText={(data)=>{this.setState({email:data})}}/>
              <Text style={styles.title}> Input Phone Number </Text>
              <TextInput value={this.state.phone} style={styles.input} placeholder="Phone Number" onChangeText={(data)=>{this.setState({phone:data})}}/>
              <Text style={styles.title}> Input Address </Text>
              <TextInput value={this.state.address} style={styles.input} placeholder="Address" onChangeText={(data)=>{this.setState({address:data})}}/>
              <TouchableOpacity style={styles.button} onPress={this.handleUpdate.bind(this)}><Text style={styles.title}>SUBMIT</Text></TouchableOpacity>

            <TouchableOpacity onPress={()=>{this.props.navigation.navigate("App")}} style={styles.button}><Text style={styles.title}>LIST</Text></TouchableOpacity>
            
          </View>
      )
  }
}

export default UpdateData

const styles = StyleSheet.create({
  title: {
    fontSize: 18,
  },
  input: {
    fontSize: 18,
    margin: 10,
  },
  button: {
    alignItems: "center",
    backgroundColor: "#DDDDDD",
    padding: 10,
    marginTop: 10,
  },
});