import React, { Component } from 'react'
import { View, Text, TouchableOpacity,StyleSheet, Image } from 'react-native'
import PropTypes from 'prop-types'
import { connect } from 'react-redux'
import { LoginAction } from '../Redux/Action'

class MainMenu extends Component {
    constructor(props) {
        super(props);
        this.state={
            counter:1,
        }
    }

    componentDidMount(){
        if(!this.props.dataRedux.isLogin){
            this.props.navigation.navigate('Home')
        }
    }

    handleSignOut(){
        alert("Anda berhasil sign out")
        this.props.LoginAction(false,"isLogin")
        this.props.navigation.navigate("Home")
    }

    render() {
        return (
            <View style={styles.viewStyle}>

                <Text style={styles.title}> Main Menu </Text>

                <TouchableOpacity style={styles.item} onPress={()=>{this.props.navigation.navigate('DataCalon')}}>
                    <Text style={styles.title1}>Data Calon</Text>
                </TouchableOpacity>
                <TouchableOpacity style={styles.item} onPress={()=>{this.props.navigation.navigate('PilihCalon')}}>
                    <Text style={styles.title1}>Pilih Calon</Text>
                </TouchableOpacity>
                <TouchableOpacity style={styles.item} onPress={()=>{this.handleSignOut()}}>
                    <Text style={styles.title1}>Sign Out</Text>
                </TouchableOpacity>

            </View>
        )
    }
}

const mapStateToProps = (state) => ({
    dataRedux:state.LoginReducer
})

const mapDispatchToProps = {
    LoginAction,
}

export default connect(mapStateToProps, mapDispatchToProps)(MainMenu)

const styles = StyleSheet.create({
    item: {
        margin:10,
        alignItems: "center",
        backgroundColor: "green",
        padding: 10,
    },
    title: {
        fontSize: 55,
        textAlign: 'center',
        marginTop: 50,
        marginBottom: 70,
        fontWeight: 'bold'
    },
    title1: {
        fontSize: 25,
        textAlign: 'center',
    },
    viewStyle:{
        margin:20,
    },
})