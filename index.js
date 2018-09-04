'use strict';

import React from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  NativeModules,
} from 'react-native';

import { DeviceEventEmitter } from 'react-native';

var RCTToastAndroid  = NativeModules.ToastCustomModule;

class HelloWorld extends React.Component {

  constructor(props) {
    super(props);
  }

  render() {
    return (
      <View>
            <Text> { this.props.message }</Text>
            <Text  style={styles.hello}> The instructions are a bit different depending on your development operating system, and whether you want to start developing for iOS or Android.
             If you want to develop for both iOS and
             Android,
             with, since the setup is a bit different. </Text>
      </View>
    )
  }

    componentDidMount()
    {
       RCTToastAndroid.showMessage('Awesome', (result) => {
      //  console.warn(result);
       });

       DeviceEventEmitter.addListener('qrCode', function(e: Event) {
      //   console.warn('qrCode : ',e);
        });
    }
}
var styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
  },
  hello: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
    color: '#656565',
  },
});

AppRegistry.registerComponent('HelloWorld', () => HelloWorld);
