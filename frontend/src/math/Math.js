import React from "react";
import { BrowserRouter as Routes, Route, Link } from "react-router-dom";
import easyMathImage from '../images/math-easy.png';
import mediumMathImage from '../images/math-medium.png';
import hardMathImage from "../images/math-hard.png";


function Math() {
    return (
        <div>
            <div className="page-top">
                <Link to="/"><img src="https://cdn.pixabay.com/photo/2012/04/02/16/03/back-24838_1280.png" alt="Back button"/></Link>
                <h2>Math Zone</h2>
            </div>

            <div>
            <ul className="subject-selection">
                <li>
                    <h2>Preschool</h2>
                    <Link to="/math/EasyMath"><img src={easyMathImage} alt="Link for easy Math."/></Link>
                    <p>Can you count to 10? Do you know what numbers add up to 10? Let's see!</p>
                </li>
                <li>
                    <h2>Elementary School</h2>
                    <Link to="/math/MediumMath"><img src={mediumMathImage} alt="Link for Colors section."/></Link>
                    <p>How about Addition? Can you divide? Let's do some math problems!</p>
                </li>
                <li>
                    <h2>Middle School</h2>
                    <Link to="/math/HardMath"><img src={hardMathImage} alt="Link for Animals section."/></Link>
                    <p>How about something a little harder? How about double digit math?</p>
                </li>
            </ul>
        </div>
        </div>
    );
}

export default Math;