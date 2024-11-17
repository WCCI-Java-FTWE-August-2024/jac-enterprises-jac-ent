import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";

const SignIn = () => {
    const [username, setUsername] = useState(""); // State for username input
    const [password, setPassword] = useState(""); // State for password input
    const [error, setError] = useState(""); // State for error messages
    const [isLoggedIn, setIsLoggedIn] = useState(false); // State to track login status

    useEffect(() => {
        // Check for the auth token in cookies
        const token = document.cookie.split('; ').find(row => row.startsWith('authToken='));
        if (token) {
            setIsLoggedIn(true); // User is logged in
        }
    }, []);

    const handleSignIn = async () => {
        setError(""); // Clear previous errors
        try {
            const response = await fetch("http://localhost:8080/api/v1/users/login", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({ username, password }), // Send username and password
            });

            if (!response.ok) {
                throw new Error("Invalid credentials. Please try again.");
            }

            const token = await response.text(); // Retrieve token
            alert(`Token received: ${token}`); // Display token in an alert
            document.cookie = `authToken=${token}; path=/; Secure; SameSite=Strict`;
            setIsLoggedIn(true); // Update login status to true
        } catch (err) {
            setError("Failed to sign in. Please check your credentials."); // Display error message
        }
    };

    const handleLogout = () => {
        document.cookie = "authToken=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;"; // Clear the token
        setIsLoggedIn(false); // Update login status to false
        
    };

    return (
        <div className="sign-in-container">
            <div className="page-top">
                <Link to="/">
                    <img
                        src="https://cdn.pixabay.com/photo/2012/04/02/16/03/back-24838_1280.png"
                        alt="Back button"
                    />
                </Link>
                <h2>Sign In</h2>
            </div>

            <div className="sign-container">
                {isLoggedIn ? ( // Conditional rendering based on login status
                    <div>
                        <p>You are logged in</p> {/* Message displayed when logged in */}
                        <button onClick={handleLogout}>Log Out</button> {/* Logout button */}
                    </div>
                ) : (
                    <div>
                        <input
                            type="text"
                            value={username}
                            onChange={(e) => setUsername(e.target.value)} // Update username state
                            placeholder="Enter your username"
                        />
                        <input
                            type="password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)} // Update password state
                            placeholder="Enter your password"
                        />
                        <button onClick={handleSignIn}>Sign In</button>
                    </div>
                )}
                {error && <p className="error-message">{error}</p>} {/* Display errors */}
            </div>
        </div>
    );
};

export default SignIn;
