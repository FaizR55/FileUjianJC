import React, { Component } from 'react'
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import App from './App';
import AddData from './AddData';
import UpdateData from './UpdateData';

const Stack = createStackNavigator();

export class Home extends Component {
    render() {
        return (
                <NavigationContainer>
                    <Stack.Navigator> 
                        <Stack.Screen 
                        name="App" 
                        component={App}/>
                        <Stack.Screen 
                        name="AddData" 
                        component={AddData}/>
                        <Stack.Screen 
                        name="UpdateData" 
                        component={UpdateData}/>
                    </Stack.Navigator>
                </NavigationContainer>
        )
    }
}

export default Home

//Stack navigate install
//npm install react-native-reanimated react-native-gesture-handler react-native-screens react-native-safe-area-context @react-native-community/masked-view 
