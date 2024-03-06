import './SignUp.css';
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const SignUp = () => {
  const [user, setUser] = useState({
    email: '',
    password: '',
    confirmPassword: ''
  });

  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setUser({ ...user, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // Ici, vous ajouterez la logique pour enregistrer l'utilisateur dans votre système
    console.log(user);
    // Après l'enregistrement, vous pouvez rediriger l'utilisateur où vous le souhaitez, par exemple vers la page de connexion
    navigate('/');
  };

  return (
    <div className="auth-form">
      <h2>Créer un compte</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="email"
          name="email"
          placeholder="Email"
          value={user.email}
          onChange={handleChange}
          required
        />
        <input
          type="password"
          name="password"
          placeholder="Mot de passe"
          value={user.password}
          onChange={handleChange}
          required
        />
        <input
          type="password"
          name="confirmPassword"
          placeholder="Confirmez le mot de passe"
          value={user.confirmPassword}
          onChange={handleChange}
          required
        />
        <button type="submit">S'inscrire</button>
      </form>
    </div>
  );
};

export default SignUp;
