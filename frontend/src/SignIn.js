import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";

// Helper function to retrieve a cookie by its name
const getCookie = (name) => {
    // Matches the cookie name with the provided regular expression and returns the value
    const match = document.cookie.match(new RegExp('(^| )' + name + '=([^;]+)'));
    return match ? match[2] : null; // Returns the cookie value if found, otherwise null
};

const SignIn = () => {
    // State declarations
    const [username, setUsername] = useState(""); // State for username input
    const [password, setPassword] = useState(""); // State for password input
    const [error, setError] = useState(""); // State for displaying error messages
    const [isLoggedIn, setIsLoggedIn] = useState(false); // State to track if the user is logged in

    // useEffect hook to check for the presence of an authentication token when the component mounts
    useEffect(() => {
        const token = getCookie("authToken"); // Get the authToken cookie
        if (token) {
            setIsLoggedIn(true); // If a token exists, mark user as logged in
        }
    }, []); // Empty dependency array ensures this effect only runs once on component mount

    /**
     * handleSignIn
     * Handles the sign-in process by sending a POST request with the username and password.
     * If successful, sets the authentication token in cookies and updates login status.
     */
    const handleSignIn = async () => {
        setError(""); // Clear any previous error messages
        try {
            // Send POST request to authenticate the user
            const response = await fetch("http://localhost:8080/api/v1/users/login", {
                method: "POST", // POST method for logging in
                headers: { "Content-Type": "application/json" }, // Set content type to JSON
                body: JSON.stringify({ username, password }), // Include username and password in the request body
            });

            if (!response.ok) {
                // If response is not OK, throw an error
                throw new Error("Invalid credentials. Please try again.");
            }

            const token = await response.text(); // Parse the token from the response text
            // Store the token and username in cookies for session management
            document.cookie = `authToken=${token}; path=/; Secure; SameSite=Strict`;
            document.cookie = `username=${username}; path=/; Secure; SameSite=Strict`;
            setIsLoggedIn(true); // Set user as logged in
            window.location.reload(); // Reload the page to reflect the updated state
        } catch (err) {
            setError("Failed to sign in. Please check your credentials."); // Display error if something goes wrong
        }
    };

    /**
     * handleLogout
     * Logs the user out by clearing the authentication token from cookies
     * and resetting the login state.
     */
    const handleLogout = () => {
        // Clear the authToken and username cookies
        document.cookie = "authToken=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
        document.cookie = "username=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
        setIsLoggedIn(false); // Set user as logged out
        window.location.reload(); // Reload the page to reflect the updated state
    };

    return (
        <div className="sign-in-container">
            <div className="page-top">
                {/* Link to go back to the home page */}
                <Link to="/">
                    <img
                        src="https://cdn.pixabay.com/photo/2012/04/02/16/03/back-24838_1280.png"
                        alt="Back button"
                    />
                </Link>
                <h2>Sign In</h2>
            </div>

            <div className="sign-container">
                {isLoggedIn ? (
                    // If user is logged in, show logged-in message and logout button
                    <div>
                        <p>You are logged in</p>
                        <button onClick={handleLogout}>Log Out</button>
                        {/* Uncomment this button if you want to add account deletion functionality */}
                        {/* <button id="deleteAccountBtn">Delete Account</button> */}
                    </div>
                ) : (
                    // If user is not logged in, show sign-in form
                    <div>
                        {/* Username input */}
                        <input
                            type="text"
                            value={username}
                            onChange={(e) => setUsername(e.target.value)} // Update username state on input change
                            placeholder="Enter your username"
                        />
                        {/* Password input */}
                        <input
                            type="password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)} // Update password state on input change
                            placeholder="Enter your password"
                        />
                        {/* Sign-in button */}
                        <button onClick={handleSignIn}>Sign In</button>
                    </div>
                )}
                {/* Display error message if any error occurs */}
                {error && <p className="error-message">{error}</p>}
            </div>
        </div>
    );
};

export default SignIn;
