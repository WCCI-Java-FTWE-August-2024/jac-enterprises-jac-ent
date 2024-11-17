// Import necessary React libraries and components
import React from "react";
import { Link } from "react-router-dom"; // For navigation within the app
import jacLogo from "./images/jac-logo-text.png"; // Import the logo image for the page

// Main About Component
function About() {
    return (
        // Main container for the About page
        <div className="about">
            {/* Header section */}
            <div className="page-top">
                <h2>About Us</h2> {/* Page title */}
            </div>

            {/* Main content section */}
            <div className="about-text">
                {/* Introductory section */}
                <h3>Welcome to Jac Enterprises!</h3>
                <p>
                    Learning should never feel like a chore. At Jac Enterprises, we’ve reimagined education as a thrilling adventure where every click, 
                    question, and discovery is packed with fun. Our platform is more than just educational—it’s a gateway to a world of creativity, exploration, and growth.
                </p>

                {/* Mission statement */}
                <h3>Our Mission</h3>
                <p>
                    We exist to spark curiosity, nurture creativity, and cultivate a lifelong love for learning. By blending technology with engaging content, 
                    we aim to empower learners of all ages and transform traditional education into an unforgettable experience.
                </p>

                {/* Feature description section */}
                <h3>What We Offer</h3>
                <p>
                    We bring a suite of interactive zones tailored to inspire learners at every level:
                </p>
                <ul>
                    <li>
                        <strong>Math Zone:</strong> From counting games to brain-busting puzzles, test your skills while having a blast with numbers.
                    </li>
                    <li>
                        <strong>Color Zone:</strong> Dive into the world of hues and shades, explore color theory, and become a color-mixing maestro.
                    </li>
                    <li>
                        <strong>Animal Zone:</strong> Embark on a wild adventure through the animal kingdom with quizzes, fun facts, and challenges.
                    </li>
                </ul>

                {/* Journey description */}
                <h3>Our Journey</h3>
                <p>
                    Jac Enterprises began with a shared dream among a group of passionate educators, designers, and developers. We saw the potential to 
                    reshape learning with technology—making it accessible, interactive, and above all, enjoyable. What started as an ambitious idea 
                    has grown into a beloved platform for learners across the globe.
                </p>

                {/* Unique selling points */}
                <h3>Why Choose Jac Enterprises?</h3>
                <p>
                    Choosing us means choosing a partner in your learning journey. Here's why we stand out:
                </p>
                <ul>
                    <li>Intuitive, kid-friendly design that’s also enjoyable for adults.</li>
                    <li>Carefully crafted content backed by educators and experts.</li>
                    <li>Gamified learning to keep you motivated and eager to explore.</li>
                    <li>Completely ad-free for a distraction-free experience.</li>
                    <li>Designed for accessibility, ensuring everyone can learn without barriers.</li>
                </ul>

                {/* Team introduction */}
                <h3>Meet Our Team</h3>
                <p>
                    Behind Jac Enterprises is a dynamic team of visionaries, educators, and tech wizards, all working towards one goal: to 
                    make learning irresistible. We’re constantly innovating, creating, and striving to deliver the best experiences possible.
                </p>

                {/* Contact and social section */}
                <h3>Stay Connected</h3>
                <p>
                    Have questions? Suggestions? Or just want to say hello? We’d love to hear from you! Drop us a line at{" "}
                    <a href="mailto:support@jacenterprises.com">support@jacenterprises.com</a>. Don’t forget to follow us on social media 
                    for the latest updates, features, and more exciting learning opportunities.
                </p>
            </div>

            {/* Horizontal line for visual separation */}
            <hr />

            {/* Logo and footer section */}
            <div className="about-logo-container">
                <img className="about-logo" src={jacLogo} alt="Jac Enterprises Logo" /> {/* Company logo */}
            </div>
            <div className="about-footer">
                <p>&copy; {new Date().getFullYear()} Jac Enterprises. All rights reserved.</p> {/* Dynamic year for copyright */}
                <p>
                    Built with <span role="img" aria-label="heart">❤️</span> by a team that cares deeply about making learning an adventure.
                </p>
            </div>
        </div>
    );
}

// Export the About component for use in other parts of the app
export default About;
