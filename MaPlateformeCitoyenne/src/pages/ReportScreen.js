import React, { useState } from 'react';
import { View, Text, TextInput, Button, StyleSheet, Alert, ScrollView, Image, Picker, FlatList } from 'react-native';
import * as ImagePicker from 'expo-image-picker';
import * as Location from 'expo-location';

function ReportScreen() {
  const [description, setDescription] = useState('');
  const [images, setImages] = useState([]);
  const [location, setLocation] = useState(null);
  const [reportType, setReportType] = useState('');
  const [urgencyLevel, setUrgencyLevel] = useState('');

  const pickImage = async () => {
    try {
      let result = await ImagePicker.launchImageLibraryAsync({
        mediaTypes: ImagePicker.MediaTypeOptions.Images,
        allowsEditing: true,
        aspect: [4, 3],
        quality: 1,
      });
  
      if (!result.cancelled) {
        setImages([...images, result.uri]);
      }
    } catch (error) {
      console.log('Erreur lors du chargement de l\'image : ', error);
    }
  };
  

  const getLocation = async () => {
    let { status } = await Location.requestForegroundPermissionsAsync();
    if (status !== 'granted') {
      Alert.alert('Permission to access location was denied');
      return;
    }

    let location = await Location.getCurrentPositionAsync({});
    setLocation(location);
  };

  const handleReportTypeChange = (value) => {
    setReportType(value);
  };

  const handleUrgencyLevelChange = (value) => {
    setUrgencyLevel(value);
  };

  return (
    <ScrollView style={styles.container}>
      <Text style={styles.label}>Description du signalement</Text>
      <TextInput
        style={styles.input}
        placeholder="Décrivez l'incident..."
        multiline
        rows={4}
        value={description}
        onChangeText={setDescription}
      />
      <Text style={styles.label}>Type de signalement</Text>
      <Picker
        selectedValue={reportType}
        onValueChange={handleReportTypeChange}
        style={styles.input}
      >
        <Picker.Item label="Sélectionnez le type de signalement" value="" />
        <Picker.Item label="Panne d'éclairage public" value="panne_eclairage" />
        <Picker.Item label="Nid-de-poule" value="nid_poule" />
        <Picker.Item label="Déchets abandonnés" value="dechets_abandonnes" />
        {/* Ajoutez d'autres types de signalement au besoin */}
      </Picker>
      <Text style={styles.label}>Niveau d'urgence</Text>
      <Picker
        selectedValue={urgencyLevel}
        onValueChange={handleUrgencyLevelChange}
        style={styles.input}
      >
        <Picker.Item label="Sélectionnez le niveau d'urgence" value="" />
        <Picker.Item label="Faible" value="faible" />
        <Picker.Item label="Moyen" value="moyen" />
        <Picker.Item label="Élevé" value="eleve" />
      </Picker>
      <View style={styles.buttonContainer}>
        <Button title="Ajouter une photo" onPress={pickImage} />
      </View>
      <ScrollView horizontal={true} style={styles.imagePreviewContainer}>
        {images.length > 0 ? (
          images.map((image, index) => (
            <View key={index} style={styles.imageContainer}>
              <Image source={{ uri: image }} style={styles.imagePreview} />
              <Text style={styles.imageUploadText}>Image {index + 1} chargée</Text>
            </View>
          ))
        ) : (
          <Text>Aucune image ajoutée.</Text>
        )}
      </ScrollView>
  
      <View style={styles.buttonContainer}>
        <Button title="Ajouter la localisation" onPress={getLocation} />
      </View>
      {location && (
        <Text>Localisation: {location.coords.latitude}, {location.coords.longitude}</Text>
      )}
      <View style={styles.buttonContainer}>
        <Button title="Envoyer le signalement" onPress={() => Alert.alert('Signalement envoyé')} />
      </View>
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 20,
    backgroundColor: '#fff',
  },
  label: {
    marginBottom: 10,
    fontSize: 18,
    fontWeight: 'bold',
  },
  input: {
    borderColor: 'gray',
    borderWidth: 1,
    padding: 10,
    marginBottom: 20,
    borderRadius: 5,
  },
  buttonContainer: {
    marginBottom: 20,
  },
  imageContainer: {
    marginRight: 10,
  },
  imagePreview: {
    width: 100,
    height: 100,
    borderRadius: 5,
  },
  imageUploadText: {
    textAlign: 'center',
    marginTop: 5,
  },
});

export default ReportScreen;
