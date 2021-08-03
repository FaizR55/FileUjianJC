import React, { Component } from 'react'
import { StyleSheet, TouchableOpacity, View, Image, Text } from 'react-native';

export default class Home extends Component {
  
  render() {
    return (
      <View style={styles.container}>
      <Image style={styles.logo} source={{uri: 'https://www.nicepng.com/png/detail/141-1415218_incognito-logo-incognito-mode-icon.png'}} />

      <TouchableOpacity style={styles.button} onPress={()=>{this.props.navigation.navigate("Login")}}><Text>LOGIN</Text></TouchableOpacity>

      <TouchableOpacity style={styles.button} onPress={()=>{this.props.navigation.navigate("Register")}}><Text>REGISTER</Text></TouchableOpacity>

      </View>
    )
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
  button: {
    margin:10,
    alignItems: "center",
    backgroundColor: "#DDDDDD",
    padding: 10,
  },
  logo: {
    width: 150,
    height: 150,
  },
});
