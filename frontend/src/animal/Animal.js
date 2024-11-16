import React from "react";
import { BrowserRouter as Routes, Route, Link } from "react-router-dom";
import easyAnimalsImage from '../images/animals-easy.png';
import mediumAnimalsImage from '../images/animals-medium.png';
import hardAnimalsImage from "../images/animals-hard.png";
import './Animal.css';

function Animal() {
    return (
        <div>
            <div className="page-top">
                <Link to="/"><img src="https://cdn.pixabay.com/photo/2012/04/02/16/03/back-24838_1280.png" alt="Back button"/></Link>
                <h2>Animal Zone</h2>
            </div>

            <div>
            <ul className="subject-selection">
                <li>
                    <h2>Preschool</h2>
                    <Link to="/animal/EasyAnimals"><img src={easyAnimalsImage} alt="Link for easy Animals."/></Link>
                    <p>🦁 What animal makes a "roar"? Can you name the animals? Let's have a wild adventure! 🐘</p>
                </li>
                <li>
                    <h2>Elementary School</h2>
                    <Link to="/animal/MediumAnimals"><img src={mediumAnimalsImage} alt="Link for medium Animals."/></Link>
                    <p>🍎 What do lions eat? How about pandas? 🐼 Let's explore the world of animal diets! 🌿</p>
                </li>
                <li>
                    <h2>Middle School</h2>
                    <Link to="/animal/HardAnimals"><img src={hardAnimalsImage} alt="Link for hard Animals."/></Link>
                    <p>🔊 How do whales "talk"? Or bees "dance"? 🐳 Dive into the fascinating world of animal communication! 🐝</p>
                </li>
            </ul>
        </div>
        </div>
    );
}

export default Animal;