import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import './App.css';
import Home from "./Home";
import About from "./About";
import SignIn from "./SignIn";
import SignUp from "./SignUp";
import Math from "./math/Math";
import Color from "./color/Color";
import Animal from "./animal/Animal";
import EasyMath from "./math/EasyMath";
import logo from './images/jac-logo-text.png';
import MediumMath from "./math/MediumMath";
import HardMath from "./math/HardMath";
import EasyColors from "./color/EasyColors";
import MediumColors from "./color/MediumColors";
import HardColors from "./color/HardColors";
import EasyAnimals from "./animal/EasyAnimals";
import MediumAnimals from "./animal/MediumAnimals";
import HardAnimals from "./animal/HardAnimals";
import ErrorPage from "./ErrorPage";

// Helper function to retrieve a cookie by name
const getCookie = (name) => {
  const match = document.cookie.match(new RegExp('(^| )' + name + '=([^;]+)'));
  return match ? match[2] : null;
};

// Function to handle sign out
const handleSignOut = () => {
  document.cookie = "authToken=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
  window.location.reload(); // Reload the page to reflect changes
};

// Main App function
function App() {
  // Retrieve token from cookies
  const token = getCookie("authToken");
  
  return (
    <Router>
      <div className="app-body">
        <nav className="nav">
          <ul className="nav-list">
            <li><Link to="/"><img src={logo} alt="Home button logo" /></Link></li>
            <li><Link to="/math/Math">Math Zone</Link></li><span>|</span> 
            <li><Link to="/color/Color">Color Zone</Link></li><span>|</span> 
            <li><Link to="/animal/Animal">Animal Zone</Link></li><span>|</span> 
            <li><Link to="/About">About</Link></li><span>|</span>
            {/* Conditional rendering for Sign In/Sign Out */}
            {token ? (
              <li><Link to="/SignIn">Sign Out</Link></li>
            ) : (
              <li><Link to="/SignIn">Sign In</Link></li>
            )}
          </ul>
        </nav>
        <div className="content">
          <Routes>
            <Route path="/" element={<Home/>}/>
            <Route path="/About" element={<About/>}/>
            <Route path="/SignIn" element={<SignIn/>}/>
            <Route path="/SignUp" element={<SignUp/>}/>
            <Route path="/math/Math" element={<Math/>} />
            <Route path="/color/Color" element={<Color/>} />
            <Route path="/animal/Animal" element={<Animal/>} />
            <Route path="/math/EasyMath" element={<EasyMath/>}/>
            <Route path="/math/MediumMath" element={<MediumMath/>}/>
            <Route path="/math/HardMath" element={<HardMath/>}/>
            <Route path="/color/EasyColors" element={<EasyColors/>}/>
            <Route path="/color/MediumColors" element={<MediumColors/>}/>
            <Route path="/color/HardColors" element={<HardColors/>}/>
            <Route path="/animal/EasyAnimals" element={<EasyAnimals/>}/>
            <Route path="/animal/MediumAnimals" element={<MediumAnimals/>}/>
            <Route path="/animal/HardAnimals" element={<HardAnimals/>}/>
            <Route path="*" element={<ErrorPage />} />
          </Routes>
        </div>
        <footer>
          <p>&copy; Jac Enterprises</p>
        </footer>
      </div>
    </Router>
  );
}

// Export the App component for use in other files
export default App;
