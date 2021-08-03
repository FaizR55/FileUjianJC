import React, { Component } from 'react'
import { Text, View, SafeAreaView, StyleSheet, Image, Button, TextInput, ScrollView, FlatList, TouchableOpacity, Dimensions } from 'react-native';
import MapView from 'react-native-maps';
import { Marker } from 'react-native-maps';
import * as Linking from 'expo-linking';

export class DetailCalon extends Component {
    constructor(props) {
        super(props);
        this.state = {
            data: this.props,
            image: this.props.route.params.image,
            nama: this.props.route.params.name,
            phone: this.props.route.params.phone,
            markers: [],
            latitude: parseFloat(this.props.route.params.latitude),
            longitude: parseFloat(this.props.route.params.longitude)
        }
    }
    componentDidMount() {
        console.log('ini data did mount', this.state.data)
    }

    pressCall=()=>{
        const url=`tel:${this.state.phone}`
        Linking.openURL(url)
    }
    render() {
        return (
            <SafeAreaView style={styles.container}>
                <ScrollView>
                    <Text style={{ fontSize: 24, fontWeight: 'bold', alignSelf: 'center', marginTop: 20 }}>Detail Calon</Text>
                    <Image source={{ uri: `http://192.168.43.90:8080/user/image/${item.image}` }} style={styles.image, { height: 400 }} />
                    <View style={{ flex:1}}>
                        <View>
                            <Text>Nama            : {this.state.data.route.params.name}</Text>
                            <Text>Umur            : {this.state.data.route.params.umur}</Text>
                            <Text>Username        : {this.state.data.route.params.username}</Text>
                            <Text>Nomor Handphone : {this.state.phone}</Text>
                        </View>
                        <View>
                            <TouchableOpacity onPress={() => {this.pressCall()}}>
                                <Image source={{uri : 'https://png.pngtree.com/png-vector/20201028/ourmid/pngtree-phone-icon-in-solid-circle-png-image_2380227.jpg'}} style={{width :50,height:50, alignSelf:'flex-end'}}/>
                            </TouchableOpacity>
                        </View>
                    </View>
                    <MapView
                        style={styles.map}
                        showsUserLocation={true}
                        zoomControlEnabled={true}
                        zoomEnabled={true}
                        zoomTapEnabled={true}
                        showsScale={true}
                        showsBuildings={true}
                        showsUserLocation={true}
                        showsCompass={true}
                        region={{
                            latitude: this.state.latitude,
                            longitude: this.state.longitude,
                            latitudeDelta: 0.001,
                            longitudeDelta: 0.001
                        }}
                    >
                        <Marker
                            coordinate={{
                                latitude: this.state.latitude,
                                longitude: this.state.longitude,
                            }}
                            title={this.state.nama}
                            draggable
                            pinColor="green"
                        >
                        </Marker>
                    </MapView>
                </ScrollView>
            </SafeAreaView>
        )
    }
}

const styles = StyleSheet.create({
    map: {
        width: Dimensions.get('window').width,
        height: 400
    },
    container: {
        flex: 1,
    },
    item: {
        flex: 1,
        flexDirection: "row",
        backgroundColor: '#f9c2ff',
        padding: 20,
        marginVertical: 8,
        marginHorizontal: 16,
    },
    title: {
        fontSize: 32,
    },
    image: {
        flex: 1,
        height: 50
    }
});

export default DetailCalon