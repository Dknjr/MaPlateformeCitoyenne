import React from 'react';
import { useNavigate } from 'react-router-dom'; // Importer useNavigate
import { View, Text, Button, StyleSheet } from 'react-native';

function HomeScreen() {
  const navigate = useNavigate(); // Utiliser le hook useNavigate

  return (
    <View style={styles.container}>
      <Text>Bienvenue sur la Plateforme Citoyenne</Text>
      <Button
        title="Signaler un incident"
        onPress={() => navigate('/report')} // Utiliser navigate pour la navigation
      />
    </View>
  );
}

const styles = {
  container: {
    padding: '20px',
  },
}  

export default HomeScreen;
