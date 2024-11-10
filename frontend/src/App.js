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

import EasyColors from "./color/EasyColors";
import MediumColors from "./color/MediumColors";
import HardColors from "./color/HardColors";

import EasyAnimals from "./animal/EasyAnimals";
import MediumAnimals from "./animal/MediumAnimals";
import HardAnimals from "./animal/HardAnimals";

function App() {
  return (
    <Router>
      <div className="app-body">
        <nav className="nav">
          <ul className="nav-list">
            <li><Link to="/"><img src={logo} alt="Home button logo" /></Link></li>
            <li><Link to="/math/Math">Math Zone</Link></li> |
            <li><Link to="color/Color">Color Zone</Link></li> |
            <li><Link to="/animal/Animal">Animal Zone</Link></li> |
            <li><Link to="/About">About</Link></li> |
            <li><Link to="/SignIn">Sign In</Link></li>
          </ul>
        </nav>
        <div className="content">
          <Routes>
            <Route path="/" element={<Home/>}/>
            <Route path="/About" element={<About/>}/>
            <Route path="/SignIn" element={<SignIn/>}/>
            <Route path="/math/Math" element={<Math/>} />
            <Route path="/color/Color" element={<Color/>} />
            <Route path="/animal/Animal" element={<Animal/>} />

            <Route path="/math/EasyMath" element={<EasyMath/>}/>
            <Route path="/math/MediumMath" element={<MediumMath/>}/>
            <Route path="/math/HardMath" element={<HardMath/>}/>

            <Route path="/color/EasyColors" element={<EasyColors/>}/>
            <Route path="/color/MediumColors" element={<MediumColors/>}/>
            <Route path="/color/HardColors" element={<HardColors/>}/>

            <Route path="/animal/EasyAniamls" element={<EasyAnimals/>}/>
            <Route path="/animal/MediumAnimals" element={<MediumAnimals/>}/>
            <Route path="/animal/HardAnimals" element={<HardAnimals/>}/>
          </Routes>
        </div>
        <footer><p>&copy;Jac Enterprises</p></footer>
      </div>
    </Router>
  )
}

export default App;
