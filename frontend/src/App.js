import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import './App.css';
import Home from "./Home";
import About from "./About";
import SignIn from "./SignIn";
import Math from "./math/Math";
import Color from "./color/Color";
import Animal from "./animal/Animal";
import EasyMath from "./math/EasyMath";
import logo from './images/jac-logo-text.png';
import MediumMath from "./math/MediumMath";
import HardMath from "./math/HardMath";

function App() {
  return (
    <Router>
      <div className="app-body">
        <nav className="nav">
          <ul className="nav-list">
            <li><Link to="/"><img src={logo} alt="Home button logo"/></Link></li>
            <li><Link to="/math/Math">Math Zone</Link></li><span>|</span>
            <li><Link to="color/Color">Color Zone</Link></li><span>|</span>
            <li><Link to="/animal/Animal">Animal Zone</Link></li><span>|</span>
            <li><Link to="/About">About</Link></li><span>|</span>
            <li><Link to="/SignIn">Sign In</Link></li>
          </ul>
        </nav>
        <div className="content">
          <Routes>
            <Route path="/" element={<Home/>}/>
            <Route path="/About" element={<About/>}/>
            <Route path="/SignIn" element={<SignIn/>}/>
            <Route path="/math/Math" element={<Math/>}/>
            <Route path="/color/Color" element={<Color/>} />
            <Route path="/animal/Animal" element={<Animal/>} />
            <Route path="/math/EasyMath" element={<EasyMath/>}/>
            <Route path="/math/MediumMath" element={<MediumMath/>}/>
            <Route path="/math/HardMath" element={<HardMath/>}/>
          </Routes>
        </div>
        <footer><p>&copy;Jac Enterprises</p></footer>
      </div>
    </Router>
  );
}

export default App;
