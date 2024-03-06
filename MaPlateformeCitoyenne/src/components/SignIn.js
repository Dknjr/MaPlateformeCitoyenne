import './Login.css';
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
    
const SignIn = () => {
    let navigate = useNavigate();
    const [login, setLogin] = useState({ 
        email: '', 
        password: '', 
    });
 
    const handleChange = (e) => { 
        const { name, value } = e.target; 
        setLogin({...login, [name]: value}); 
    };
 
    const handleSubmit = (e) => { 
        e.preventDefault();
        // Logique de vérification des identifiants
        console.log(login);
        // Si la vérification est réussie, rediriger vers la page d'accueil
        navigate('/home');
    };
 
    // Fonction pour naviguer vers le composant de création de compte
    const handleSignUp = () => {
        navigate('/signup');
    };
 
    return ( 
        <div className="auth-form"> 
            <h2>Se connecter</h2> 
            <form onSubmit={handleSubmit}> 
                <input type="email" name="email" placeholder="Email" value={login.email} onChange={handleChange} required /> 
                <input type="password" name="password" placeholder="Mot de passe" value={login.password} onChange={handleChange} required /> 
                <button type="submit">Connexion</button> 
            </form>
            <button onClick={handleSignUp}>Créer un compte</button> {/* Bouton pour naviguer vers SignUp */}
        </div> 
    ); 
};
 
export default SignIn;
