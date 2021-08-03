import React, { Component } from 'react'
import { View, Text, FlatList, Image, StyleSheet, TouchableOpacity } from 'react-native'
import PropTypes from 'prop-types'
import { connect } from 'react-redux'
import axios from 'axios';

export class DataCalon extends Component {
    constructor(props) {
        super(props);
        this.state = {
            dataFlatList:{}
        }
    }

    componentDidMount() {
        this.getData()
    }

    getData(){
        axios.get('http://192.168.43.90:8080/user/')
        .then((response)=>{
            let data =response.data
            console.log(data)
            this.setState({dataFlatList:data})
        })
        .catch((error)=>{
            console.log(error)
        })
    }

    render() {
        return (
            <View style={styles.viewStyle}>

            <Text style={styles.title}> Data Calon </Text>
           
                <FlatList
                    data={this.state.dataFlatList}
                    keyExtractor={item=>parseInt(item.id)}
                    renderItem={({item})=>(
                <TouchableOpacity onPress={() => { this.props.navigation.navigate('DetailCalon'), item }}>
                        <View style={{borderWidth:10,borderColor:"green",flexDirection:"row",margin:5}}>
                            <Image style={{width:120,height:120}}
                                source={{uri:`http://192.168.43.90:8080/user/image/${item.image}`}}
                            />
                            <View style={{flexDirection:"column",alignSelf:"center",margin:15}}>
                                <Text style={styles.flattext}>Nama : {item.name}</Text>
                                <Text style={styles.flattext}>Umur : {item.umur}</Text>
                                <Text style={styles.flattext}>Username : {item.username}</Text>
                            </View>
                        </View>
                </TouchableOpacity>
                    )}
                />
                
            </View>
        )
    }
}

const mapStateToProps = (state) => ({
    isLogin: state.LoginReducer.isLogin
})

const mapDispatchToProps = {
    
}

export default connect(mapStateToProps, mapDispatchToProps)(DataCalon)

const styles = StyleSheet.create({
    viewStyle:{
        margin:20,
    },
    title: {
        fontSize: 55,
        textAlign: 'center',
        marginTop: 40,
        marginBottom: 40,
        fontWeight: 'bold'
    },
    flattext: {
        fontSize: 15,
    },
})