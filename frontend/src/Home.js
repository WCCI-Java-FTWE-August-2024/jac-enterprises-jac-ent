import React from "react";
import { Link } from "react-router-dom";
import mathImage from "./images/math-medium.png";
import colorImage from "./images/color-zone.png";
import animalImage from "./images/animalZone.png";

function Home() {
    return (
        <div>
            <div className="page-top">
                <h2>Home</h2>
            </div>
            <ul className="subject-selection">
                <li>
                    <h2>Math Zone</h2>
                    <Link to="/math/Math"><img src={mathImage} alt="Link for Math section."/></Link>
                    <p>Can you count to 10? Do you know what numbers add up to 10? Let's see!</p>
                </li>
                <li>
                    <h2>Color Zone</h2>
                    <Link to="/color/Color"><img src={colorImage} alt="Link for Colors section."/></Link>
                    <p>Do you know what color a fire truck is? Let's see what you know!</p>
                </li>
                <li>
                    <h2>Animal Zone</h2>
                    <Link to="/animal/Animal"><img src={animalImage} alt="Link for Animals section."/></Link>
                    <p>How much do you know about Animals? Let's answer some questions about them!</p>
                </li>
            </ul>
        </div>
    );
}

export default Home;