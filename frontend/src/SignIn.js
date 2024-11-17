// SignIn Component
// This React component handles user authentication functionality. It includes:
// 1. A login form for users to sign in using their username and password.
// 2. State management for form inputs, error messages, and login status.
// 3. Methods to handle sign-in and logout functionality, including token management.

import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";

// Main SignIn Component
const SignIn = () => {
    // State declarations
    const [username, setUsername] = useState(""); // State for username input
    const [password, setPassword] = useState(""); // State for password input
    const [error, setError] = useState(""); // State for error messages
    const [isLoggedIn, setIsLoggedIn] = useState(false); // State to track login status

    useEffect(() => {
        // Check for the auth token in cookies when the component loads
        // If a valid token is found, set the login status to true
        const token = document.cookie.split('; ').find(row => row.startsWith('authToken='));
        if (token) {
            setIsLoggedIn(true); // User is logged in
        }
    }, []);

    /**
     * handleSignIn
     * Handles the sign-in process by sending a POST request with username and password.
     * If successful, stores the authentication token in cookies and updates the login state.
     * If an error occurs, sets an error message for display.
     */
    const handleSignIn = async () => {
        setError(""); // Clear previous errors
        try {
            // Send login credentials to the backend API
            const response = await fetch("http://localhost:8080/api/v1/users/login", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({ username, password }), // Send username and password in request body
            });

            if (!response.ok) {
                // Handle invalid credentials
                throw new Error("Invalid credentials. Please try again.");
            }

            const token = await response.text(); // Retrieve token from the response
            alert(`Token received: ${token}`); // Display token (for debugging/demo purposes)
            // Save token and username in cookies with secure attributes
            document.cookie = `authToken=${token}; path=/; Secure; SameSite=Strict`;
            document.cookie = `username=${username}; path=/; Secure; SameSite=Strict`;
            setIsLoggedIn(true); // Update login status to true
            window.location.reload(); // Refresh the page to reflect changes
        } catch (err) {
            // Handle sign-in failure
            setError("Failed to sign in. Please check your credentials."); // Set error message for display
        }
    };

    /**
     * handleLogout
     * Logs the user out by clearing the authentication token and resetting the login state.
     */
    const handleLogout = () => {
        // Clear the auth token from cookies
        document.cookie = "authToken=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
        setIsLoggedIn(false); // Update login status to false
        window.location.reload(); // Refresh the page to reflect changes
    };

    // Render the sign-in UI
    return (
        <div className="sign-in-container">
            {/* Page header with a back link */}
            <div className="page-top">
                <Link to="/">
                    <img
                        src="https://cdn.pixabay.com/photo/2012/04/02/16/03/back-24838_1280.png"
                        alt="Back button"
                    />
                </Link>
                <h2>Sign In</h2>
            </div>

            {/* Main content: Sign-in form or logout message */}
            <div className="sign-container">
                {isLoggedIn ? ( // Conditional rendering: show logout message if logged in
                    <div>
                        <p>You are logged in</p> {/* Message displayed when logged in */}
                        <button onClick={handleLogout}>Log Out</button> {/* Logout button */}
                    </div>
                ) : (
                    // Sign-in form
                    <div>
                        <input
                            type="text"
                            value={username}
                            onChange={(e) => setUsername(e.target.value)} // Update username state on input change
                            placeholder="Enter your username"
                        />
                        <input
                            type="password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)} // Update password state on input change
                            placeholder="Enter your password"
                        />
                        <button onClick={handleSignIn}>Sign In</button> {/* Trigger sign-in */}
                    </div>
                )}
                {error && <p className="error-message">{error}</p>} {/* Display error messages */}
            </div>
        </div>
    );
};

export default SignIn;
