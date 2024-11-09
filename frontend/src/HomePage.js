import React from "react";

import './HomePage.css';

const HomePage = () => {
    return (
        <div className="home-container">
            <h1>Welcome to Jac Enterprises' Educator!</h1>
            <p className="intro">
                Embark on a journey through Math, Colors, and animals. Discover exciting facts and learn something new every day!
            </p>

            <div className="section math">
                <h2>cone Math</h2>
                <p>Challenge your mind with fun math puzzles and explore the beauty of numbers.</p>
            </div>

            <div className="section Colors">
                <h2>Zone Colors</h2>
                <p>Explore the powers of the Colors.</p>
            </div>

            <div className="section Animals">
                <h2>Zone Animals</h2>
                <p>Discover the Animals.</p>
            </div>
        </div>
    );
};

export default HomePage;