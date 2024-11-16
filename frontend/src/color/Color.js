import React from "react";
import { BrowserRouter as Routes, Route, Link } from "react-router-dom";
import easyColorsImage from '../images/colors-easy.png';
import mediumColorsImage from '../images/colors-medium.png';
import hardColorsImage from "../images/colors-hard.png";

function Color() {
    return (
        <div>
            <div className="page-top">
                <Link to="/"><img src="https://cdn.pixabay.com/photo/2012/04/02/16/03/back-24838_1280.png" alt="Back button"/></Link>
                <h2>Color Zone</h2>
            </div>
        
        <div>
            <ul className="subject-selection">
                <li>
                    <h2>Preschool</h2>
                    <Link to="/color/EasyColors"><img src={easyColorsImage} alt="Link for easy Colors."/></Link>
                    <p>🌈 What colors do you see? Red, blue, or yellow? Let's explore the rainbow together! 🎨</p>
                </li>
                <li>
                    <h2>Elementary School</h2>
                    <Link to="/color/MediumColors"><img src={mediumColorsImage} alt="Link for medium Colors."/></Link>
                    <p>🎨 What happens when you mix blue and yellow? 🟡🔵 Let's find out with some colorful experiments! ✨</p>
                </li>
                <li>
                    <h2>Middle School</h2>
                    <Link to="/color/HardColors"><img src={hardColorsImage} alt="Link for hard Colors."/></Link>
                    <p>🔍 Can you spot the primary, secondary, and tertiary colors? Dive into the science of colors! 🌟</p>
                </li>
            </ul>
        </div>
        </div>
    );
}

export default Color;
