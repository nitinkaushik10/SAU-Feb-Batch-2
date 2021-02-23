
import 'react-native-gesture-handler'
import * as React from 'react';
import {  StyleSheet,Text, View } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import Upcoming from './components/Upcoming';
import TopRated from './components/TopRated';
import Popular from './components/Popular';



const Tab = createBottomTabNavigator(); 

class App extends React.Component {
  render() {
  return (
    <NavigationContainer>
      <Tab.Navigator
         tabBarOptions={{
          backgroundColor: "#37474F", color: "red",
          labelPosition: "beside-icon",
          activeTintColor: "white",
          style: {
          backgroundColor: "black",
        },
        labelStyle: {
          fontSize: 20,
        },
        tabStyle: {
          fontSize: 10,
        },
      }}
      >
        <Tab.Screen name="Upcoming" component={Upcoming} />
        <Tab.Screen name="Top Rated" component={TopRated} />
        <Tab.Screen name="Popular" component={Popular} />
      </Tab.Navigator>
    </NavigationContainer>
  );
  }
}

const styles = StyleSheet.create({
  
  container: {
      backgroundColor: "black"
  },
  cardTitle:{
    fontSize: 20,
      color:"white",
      fontWeight: "bold"
  }

  });

export default App;
