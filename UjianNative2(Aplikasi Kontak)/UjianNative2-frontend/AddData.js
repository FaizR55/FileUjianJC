import React, { Component } from 'react'
import { View,StyleSheet, Text,  TouchableOpacity, TextInput } from 'react-native';
import axios from 'axios'

export class AddData extends Component {
    constructor(props) {
        super(props);
        this.state = {
            nama:"",
            email:"",
            phone:"",
            address:""
        }
    }

    handleAdd(){
        // console.log(this.state)
        axios.post('http://192.168.0.109:8080/service/addService',this.state)
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
                <TextInput style={styles.input} placeholder="Nama" onChangeText={(data)=>{this.setState({nama:data})}}/>
                <Text style={styles.title}> Input Email </Text>
                <TextInput style={styles.input} placeholder="Email" onChangeText={(data)=>{this.setState({email:data})}}/>
                <Text style={styles.title}> Input Phone Number </Text>
                <TextInput style={styles.input} placeholder="Phone Number" onChangeText={(data)=>{this.setState({phone:data})}}/>
                <Text style={styles.title}> Input Address </Text>
                <TextInput style={styles.input} placeholder="Address" onChangeText={(data)=>{this.setState({address:data})}}/>
                <TouchableOpacity style={styles.button} onPress={this.handleAdd.bind(this)}><Text style={styles.title}>SUBMIT</Text></TouchableOpacity>

              <TouchableOpacity onPress={()=>{this.props.navigation.navigate("App")}} style={styles.button}><Text style={styles.title}>LIST</Text></TouchableOpacity>
              
            </View>
        )
    }
}

export default AddData

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