import React from "react";
// Import necessary components from react-router-dom for routing
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
// Import main application styles
import './App.css';
// Import components for different pages
import Home from "./Home";
import About from "./About";
import SignIn from "./SignIn";
import SignUp from "./SignUp";
import Math from "./math/Math";
import Color from "./color/Color";
import Animal from "./animal/Animal";
import EasyMath from "./math/EasyMath";
// Import the app's logo
import logo from './images/jac-logo-text.png';
import MediumMath from "./math/MediumMath";
import HardMath from "./math/HardMath";
import EasyColors from "./color/EasyColors";
import MediumColors from "./color/MediumColors";
import HardColors from "./color/HardColors";
import EasyAnimals from "./animal/EasyAnimals";
import MediumAnimals from "./animal/MediumAnimals";
import HardAnimals from "./animal/HardAnimals";

// Main App function
function App() {
  return (
    // Wrap the app with the Router component to enable navigation
    <Router>
      <div className="app-body">
        {/* Navigation bar */}
        <nav className="nav">
          <ul className="nav-list">
            <li><Link to="/"><img src={logo} alt="Home button logo" /></Link></li>
            <li><Link to="/math/Math">Math Zone</Link></li><span>|</span> 
            <li><Link to="color/Color">Color Zone</Link></li><span>|</span> 
            <li><Link to="/animal/Animal">Animal Zone</Link></li><span>|</span> 
            <li><Link to="/About">About</Link></li><span>|</span> 
            <li><Link to="/SignIn">Sign In</Link></li>
          </ul>
        </nav>
        {/* Main content area where routes are rendered */}
        <div className="content">
          <Routes>
            {/* Main routes */}
            <Route path="/" element={<Home/>}/>
            <Route path="/About" element={<About/>}/>
            <Route path="/SignIn" element={<SignIn/>}/>
            <Route path="/SignUp" element={<SignUp/>}/>
            <Route path="/math/Math" element={<Math/>} />
            <Route path="/color/Color" element={<Color/>} />
            <Route path="/animal/Animal" element={<Animal/>} />
            {/* Math zone routes */}
            <Route path="/math/EasyMath" element={<EasyMath/>}/>
            <Route path="/math/MediumMath" element={<MediumMath/>}/>
            <Route path="/math/HardMath" element={<HardMath/>}/>
            {/* Color zone routes */}
            <Route path="/color/EasyColors" element={<EasyColors/>}/>
            <Route path="/color/MediumColors" element={<MediumColors/>}/>
            <Route path="/color/HardColors" element={<HardColors/>}/>
            {/* Animal zone routes */}
            <Route path="/animal/EasyAnimals" element={<EasyAnimals/>}/>
            <Route path="/animal/MediumAnimals" element={<MediumAnimals/>}/>
            <Route path="/animal/HardAnimals" element={<HardAnimals/>}/>
          </Routes>
        </div>
        {/* Footer */}
        <footer>
          <p>&copy; Jac Enterprises</p>
        </footer>
      </div>
    </Router>
  )
}

// Export the App component for use in other files
export default App;