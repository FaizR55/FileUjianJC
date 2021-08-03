import React, { Component } from 'react';
import { View,StyleSheet, Text,  FlatList, ScrollView, Alert, TouchableOpacity  } from 'react-native';
import axios from 'axios'

export default class HistoryLaporan extends Component {
  constructor(props) {
    super(props);
    this.state = {
        data: [],
    };
  }

    componentDidMount(){
        this.getData();
    }
  

    getData =()=>{
        axios.get(`http://192.168.0.110:8080/laporan/`)
        .then( (response) => {
          let data=response.data;   
          this.setState({data:data}); 
        })
        .catch(function (error) {
         console.log(error);
        })
    }

    deleteData(id){
      console.log(id);
      axios.delete(`http://192.168.0.110:8080/laporan/deleteLaporan/${id}`)
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

            <TouchableOpacity  onPress={()=>{Alert.alert('Anda yakin menghapus data ini?',
              '...',[
                {text: 'TIDAK', onPress: () => console.warn('NO Pressed'), style: 'cancel'},
                {text: 'YA', onPress: () => this.deleteData(item.idLaporan)},
              ])}}>
                <Text style={styles.title}>Status : {item.kejadian}</Text>
                <Text style={styles.title}>Jam : {item.waktu}</Text>
                <Text style={styles.title}>Alamat : {item.alamat}</Text>
            </TouchableOpacity>
            
        </View>
    )

  render() {
    return (
        <ScrollView>

            <Text style={styles.judul}>LAPORAN</Text>

            <FlatList
                data={this.state.data}
                renderItem={this.renderItem}
                keyExtractor={item => item.id}
              />
            
        </ScrollView>
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