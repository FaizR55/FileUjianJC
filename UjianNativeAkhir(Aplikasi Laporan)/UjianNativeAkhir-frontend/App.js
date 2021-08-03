import React, { Component } from 'react'
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import Home from './src/Page/Home';
import Register from './src/Page/Register';
import Login from './src/Page/Login';
import MainMenu from './src/Page/MainMenu';
import Laporan from './src/Page/Laporan';
import HistoryLaporan from './src/Page/HistoryLaporan';
import Map from './src/Page/Map';

const Stack = createStackNavigator();

export default class App extends Component {
    render() {
        return (
                <NavigationContainer>
                    <Stack.Navigator> 
                        <Stack.Screen 
                        name="Home" 
                        component={Home}/>
                        <Stack.Screen 
                        name="Register" 
                        component={Register}/>
                        <Stack.Screen 
                        name="Login" 
                        component={Login}/>
                        <Stack.Screen 
                        name="MainMenu" 
                        component={MainMenu}/>
                        <Stack.Screen 
                        name="Laporan" 
                        component={Laporan}/>
                        <Stack.Screen 
                        name="HistoryLaporan" 
                        component={HistoryLaporan}/>
                        <Stack.Screen 
                        name="Map" 
                        component={Map}/>
                    </Stack.Navigator>
                </NavigationContainer>
        )
    }
}
