import React from 'react';
import { NavLink } from 'react-router-dom';
import { FaHome, FaEnvelope, FaCog } from 'react-icons/fa';
import { MdDashboard } from "react-icons/md";
import './Sidebar.css'; // Assurez-vous d'avoir un fichier CSS pour les styles

const Sidebar = () => {
  return (
    <div className="sidebar">
      <NavLink to="/home" className={({ isActive }) => isActive ? "sidebar-item active" : "sidebar-item"}>
        <FaHome className="icon" />
        Accueil
      </NavLink>
      <NavLink to="/dashboard" className={({ isActive }) => isActive ? "sidebar-item active" : "sidebar-item"}>
        <MdDashboard className="icon" />
        Dashboard
      </NavLink>
      <NavLink to="/messages" className={({ isActive }) => isActive ? "sidebar-item active" : "sidebar-item"}>
        <FaEnvelope className="icon" />
        Messagerie
      </NavLink>
      <NavLink to="/settings" className={({ isActive }) => isActive ? "sidebar-item active" : "sidebar-item"}>
        <FaCog className="icon" />
        Paramètres
      </NavLink>
    </div>
  );
};

export default Sidebar;
