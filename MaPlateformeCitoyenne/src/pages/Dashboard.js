import React from 'react';
import './Dashboard.css';

// Composant de tableau de bord simple
const Dashboard = () => {
  return (
    <div className='container'>
      <h1>Tableau de bord</h1>
      <div className='statsContainer'>
        <div className = "statBox">
          <h2>Nombre de signalements</h2>
          <p>42</p> {/* données dynamiques */}
        </div>
        <div className = "statBox">
          <h2>Signalements résolus</h2>
          <p>38</p> {/* données dynamiques */}
        </div>
        <div className = "statBox">
          <h2>Signalements en cours</h2>
          <p>4</p> {/* données dynamiques */}
        </div>
      </div>
    </div>
  );
};


export default Dashboard;
