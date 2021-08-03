import React, { Component } from 'react'
import { Text, TouchableOpacity, View, StyleSheet, Image } from 'react-native'

import { connect } from 'react-redux'

export class Home extends Component {
    handlerLogin(){
        if(this.props.isLogin){
            this.props.navigation.navigate('MainMenu')
        }else{
            this.props.navigation.navigate('Login')
        }
    }
    render() {
        return (
            <View style={styles.viewStyle}>
            <Image style={styles.logo} source={{uri: 'https://lh3.googleusercontent.com/6KglodBeEFO004tp40YYSnZF19aJtpJ-xDCiAvKEuJzU4UIFUsAGdti-8KPMMHbMaw'}} />
                <TouchableOpacity style={styles.button} onPress={()=>{this.handlerLogin()}}>
                    <Text style={styles.textStyle}>Login</Text>
                </TouchableOpacity>

                <TouchableOpacity style={styles.button} onPress={()=>{this.props.navigation.navigate('Register')}}>
                    <Text style={styles.textStyle}>Registrasi</Text>
                </TouchableOpacity>
            </View>
        )
    }
}

const mapStateToProps = (state) => ({
    isLogin:state.LoginReducer.isLogin    
})

const mapDispatchToProps = {
    
}

export default connect(mapStateToProps, mapDispatchToProps)(Home)


const styles=StyleSheet.create({
      button: {
        marginTop:30,
        backgroundColor: "#DDDDDD",
        padding: 10,
      },
      textStyle: {
        fontSize: 25,
      },
      logo: {
        marginTop:30,
        width: 250,
        height: 250,
      },
      viewStyle:{
        margin:20,
        alignItems: "center",
      },

})
