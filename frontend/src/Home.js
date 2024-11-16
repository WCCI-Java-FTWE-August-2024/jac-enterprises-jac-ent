// Importing React to create and manage components
import React from "react";
// Importing the Link component from react-router-dom for navigation
import { Link } from "react-router-dom";
// Importing images to use in the Home component
import mathImage from "./images/math-medium.png";
import colorImage from "./images/color-zone.png";
import animalImage from "./images/animalZone.png";

// Defining the Home component
function Home() {
    return (
        // Main container for the Home page
        <div className="home-container">
            {/* Header section with the title and subtitle */}
            <div className="page-top">
                <h1 className="home-title">Welcome to the Fun Zone!</h1>
                <p className="home-subtitle">Choose a zone to start your adventure!</p>
            </div>
            {/* List of subject zones */}
            <ul className="subject-selection">
                {/* Math Zone */}
                <li className="subject-item">
                    <h2 className="subject-title">Math Zone</h2>
                    {/* Link to navigate to the Math section */}
                    <Link to="/math/Math" className="subject-link">
                        {/* Math zone image */}
                        <img src={mathImage} alt="Link for Math section." className="subject-image" />
                    </Link>
                    {/* Description for the Math Zone */}
                    <p className="subject-description">
                        Can you count to 10? 🔢🤩 Which numbers add up to 10? Let’s play and find out! 🎉🙌
                    </p>
                </li>

                {/* Color Zone */}
                <li className="subject-item">
                    <h2 className="subject-title">Color Zone</h2>
                    {/* Link to navigate to the Color section */}
                    <Link to="/color/Color" className="subject-link">
                        {/* Color zone image */}
                        <img src={colorImage} alt="Link for Colors section." className="subject-image" />
                    </Link>
                    {/* Description for the Color Zone */}
                    <p className="subject-description">
                        Can you guess the color of a fire truck? 🚒 It's bright and bold! Let’s see if you know – shout out your answer! 🔥👀
                    </p>
                </li>

                {/* Animal Zone */}
                <li className="subject-item">
                    <h2 className="subject-title">Animal Zone</h2>
                    {/* Link to navigate to the Animal section */}
                    <Link to="/animal/Animal" className="subject-link">
                        {/* Animal zone image */}
                        <img src={animalImage} alt="Link for Animals section." className="subject-image" />
                    </Link>
                    {/* Description for the Animal Zone */}
                    <p className="subject-description">
                        Let’s jump into the wild world of animals! 🦁🐒🐘 Ready to discover fun facts? Let’s go! 🎉🌍
                    </p>
                </li>
            </ul>
        </div>
    );
}

// Exporting the Home component to be used in other parts of the app
export default Home;