import React from "react";
import { BrowserRouter as Routes, Route, Link } from "react-router-dom";
import easyAnimalsImage from '../images/animals-easy.png';
import mediumAnimalsImage from '../images/animals-medium.png';
import hardAnimalsImage from "../images/animals-hard.png";

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
                    <p>Can you name these animals? Let’s see and explore the wilds!</p>
                </li>
                <li>
                    <h2>Elementary School</h2>
                    <Link to="/animal/MediumAnimals"><img src={mediumAnimalsImage} alt="Link for medium Animals."/></Link>
                    <p>Do you know what these animals eat? Let’s find out!</p>
                </li>
                <li>
                    <h2>Middle School</h2>
                    <Link to= "/animal/HardAnimals"><img src={hardAnimalsImage} alt="Link for hard Animals."/></Link>
                    <p>How do these animals communicate? Any guesses?</p>
                </li>
            </ul>
        </div>
        </div>
        
    );
}

export default Animal;