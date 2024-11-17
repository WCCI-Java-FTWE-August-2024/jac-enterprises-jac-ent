import React, { useState } from "react";
import { Link } from "react-router-dom";

const SignUp = () => {
    // State declarations
    const [username, setUsername] = useState(""); // State for username input
    const [password, setPassword] = useState(""); // State for password input
    const [age, setAge] = useState(""); // State for age input
    const [error, setError] = useState(""); // State for error messages
    const [successMessage, setSuccessMessage] = useState(""); // State for success messages

    /**
     * handleSignUp
     * Handles the sign-up process by sending a POST request with username, password, and age.
     * If successful, displays a success message or redirects the user to the sign-in page.
     * If an error occurs, sets an error message for display.
     */
    const handleSignUp = async () => {
        setError(""); // Clear previous errors
        setSuccessMessage(""); // Clear previous success messages
        try {
            // Send user credentials to the backend API for sign-up
            const response = await fetch("http://localhost:8080/api/v1/users/", {
                method: "POST", // POST request to create a new user
                headers: {
                    "Content-Type": "application/json", // Set the content type to JSON
                },
                body: JSON.stringify({ username, password, age }), // Include username, password, and age as JSON body
            });

            if (!response.ok) {
                // Handle errors (e.g., username already taken)
                throw new Error("Failed to sign up. Please check your details and try again.");
            }

            const result = await response.json(); // Parse the response to get the result
            setSuccessMessage("Account created successfully! You can now sign in."); // Display success message
        } catch (err) {
            // Handle sign-up failure
            setError("Failed to sign up. Please check your details and try again."); // Set error message for display
        }
    };

    // Render the sign-up UI
    return (
        <div className="page-top">
            {/* Page header with a back link */}
            <Link to="/">
                <img
                    src="https://cdn.pixabay.com/photo/2012/04/02/16/03/back-24838_1280.png"
                    alt="Back button"
                />
            </Link>
            <h2>Create Account</h2>

            {/* Main content: Sign-up form */}
            <div className="sign-container">
                {/* Display success message if available */}
                {successMessage && <p className="success-message">{successMessage}</p>}
                {/* Display error message if available */}
                {error && <p className="error-message">{error}</p>}

                {/* Username input field */}
                <input
                    type="text"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)} // Update username state on input change
                    placeholder="Enter your username"
                />
                {/* Password input field */}
                <input
                    type="password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)} // Update password state on input change
                    placeholder="Enter your password"
                />
                {/* Age input field */}
                <input
                    type="number"
                    value={age}
                    onChange={(e) => setAge(e.target.value)} // Update age state on input change
                    placeholder="Enter your age"
                />
                {/* Submit button to trigger sign-up */}
                <button onClick={handleSignUp}>Sign Up</button>
                {/* Link to sign-in page if the user already has an account */}
                <p>
                    Already have an account? <Link to="/SignIn">Sign In!</Link>
                </p>
            </div>
        </div>
    );
};

export default SignUp;
