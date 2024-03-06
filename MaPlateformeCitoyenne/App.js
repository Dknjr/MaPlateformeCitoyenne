import React from 'react';
import { BrowserRouter as Router, Routes, Route, useLocation } from 'react-router-dom';
import SignIn from './src/components/SignIn';
import SignUp from './src/components/SignUp';
import Sidebar from './src/components/Sidebar';
import HomeScreen from './src/pages/HomeScreen';
import ReportScreen from './src/pages/ReportScreen';
import Dashboard from './src/pages/Dashboard';
import Messages from './src/pages/Messages';
import Settings from './src/pages/Settings';
import './App.css';

const AppContent = () => {
  let location = useLocation();

  return (
    <>
      {location.pathname !== '/' && <Sidebar />}
        <div className="page-content">
        <Routes>
          <Route path="/home" element={<HomeScreen />} />
          <Route path="/messages" element={<Messages />} />
          <Route path="/report" element={<ReportScreen />} />
          <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/settings" element={<Settings />} />
        </Routes>
      </div>
    </>
  );
};

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<SignIn />} />
        <Route path="/signup" element={<SignUp />} />
        <Route path="*" element={<AppContent />} />
      </Routes>
    </Router>
  );
}

export default App;
