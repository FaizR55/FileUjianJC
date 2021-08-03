import React, { Component } from 'react'
import { StyleSheet, TouchableOpacity, View, Image, Text } from 'react-native';

export default class MainMenu extends Component {
  
  render() {
    return (
      <View style={styles.container}>

                <Text style={styles.title}> Main Menu </Text>
                <View style={styles.view}>
                    <TouchableOpacity style={styles.item} onPress={()=>{this.props.navigation.navigate('Laporan')}}><Text style={styles.title1}>Laporan</Text></TouchableOpacity>
                    <TouchableOpacity style={styles.item} onPress={()=>{this.props.navigation.navigate('HistoryLaporan')}}><Text style={styles.title1}>History Laporan</Text></TouchableOpacity>
                </View>
                <View style={styles.view}>
                    <TouchableOpacity style={styles.item} onPress={()=>{this.props.navigation.navigate('Map')}}><Text style={styles.title1}>Map Kejadian</Text></TouchableOpacity>
                    <TouchableOpacity style={styles.item} onPress={()=>{this.props.navigation.navigate('Home')}}><Text style={styles.title1}>Sign Out</Text></TouchableOpacity>
                </View>

      </View>
    )
  }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        //   marginTop: StatusBar.currentHeight || 0,
    },
    item: {
        backgroundColor: 'red',
        padding: 20,
        flex: 1,

        // marginVertical: 8,
        marginHorizontal: 16,

    },
    title: {
        fontSize: 25,
        textAlign: 'center',
        marginTop: 70,
    },
    title1: {
        fontSize: 15,
        textAlign: 'center',
        // marginTop: 70,
    },
    view: {
        marginTop:70,
        height: 60,
        flexDirection: "row",
        flexWrap: "wrap",
        alignItems: 'center',
        justifyContent: 'center'
    }
});