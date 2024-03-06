import React from 'react';
import { TouchableOpacity, Text, StyleSheet } from 'react-native';

// Props pourraient inclure: title (le texte du bouton), onPress (la fonction à exécuter au clic), style (styles supplémentaires pour le bouton)
const CustomButton = ({ title, onPress, style }) => {
  return (
    <TouchableOpacity onPress={onPress} style={[styles.button, style]}>
      <Text style={styles.text}>{title}</Text>
    </TouchableOpacity>
  );
};

const styles = StyleSheet.create({
  button: {
    backgroundColor: '#007bff', // Couleur bleue par défaut
    padding: 15,
    borderRadius: 5,
    alignItems: 'center',
    justifyContent: 'center',
    marginVertical: 5, // Ajoute un petit espace vertical entre les boutons
  },
  text: {
    color: '#ffffff', // Texte blanc
    fontSize: 16,
  },
});

export default CustomButton;
