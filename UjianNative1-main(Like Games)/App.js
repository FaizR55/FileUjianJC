import React, { Component } from 'react'
import { Text, View, Button, Image, StyleSheet, TouchableOpacity } from 'react-native'

export class Games1 extends Component {
    constructor(props) {
        super(props);
        this.state = {
            foto: require('./Images/Facebook_Login_Button.png')
        }
    }


    onButtonPress = () => {
        this.setState({
          foto: require('./Images/Google_Plus.png')
        });
      }

    render() {
        const test = [];



        for (let i = 0; i < 50; i++) {
            for (let j = 0; j < 1; j++) {
                test.push(<TouchableOpacity onPress={ this.onButtonPress}>
                    <Image source={this.state.foto} style={style.image}></Image>
                </TouchableOpacity>);
            }
        }


        return (
            <View>
                <Text>
                    {test}
                </Text>
                <Button title="Games 2" />
            </View>
        )
    }
}

export default Games1

const style = StyleSheet.create({
    image: {
        height: 50,
        width: 50,
    }
})