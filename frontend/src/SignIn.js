import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";

// Helper function to retrieve a cookie by name
const getCookie = (name) => {
    const match = document.cookie.match(new RegExp('(^| )' + name + '=([^;]+)'));
    return match ? match[2] : null;
};

const SignIn = () => {
    const [username, setUsername] = useState(""); // State for username input
    const [password, setPassword] = useState(""); // State for password input
    const [error, setError] = useState(""); // State for error messages
    const [isLoggedIn, setIsLoggedIn] = useState(false); // State to track login status

    useEffect(() => {
        const token = getCookie("authToken");
        if (token) {
            setIsLoggedIn(true);
        }
    }, []);

    const handleSignIn = async () => {
        setError("");
        try {
            const response = await fetch("http://localhost:8080/api/v1/users/login", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ username, password }),
            });

            if (!response.ok) {
                throw new Error("Invalid credentials. Please try again.");
            }

            const token = await response.text();
            document.cookie = `authToken=${token}; path=/; Secure; SameSite=Strict`;
            document.cookie = `username=${username}; path=/; Secure; SameSite=Strict`;
            setIsLoggedIn(true);
            window.location.reload();
        } catch (err) {
            setError("Failed to sign in. Please check your credentials.");
        }
    };

    const handleLogout = () => {
        document.cookie = "authToken=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
        setIsLoggedIn(false);
        window.location.reload();
    };
    // document.getElementById('deleteAccountBtn').addEventListener('click', function () {
    //     // Show confirmation dialog
    //     const userConfirmed = window.confirm("Are you sure you want to delete your account?");

    //     if (userConfirmed) {
    //         const userId = 123; // Replace with the actual user ID dynamically if needed
    //         const url = `http://localhost:8080/api/v1/users/${id}`;

    //         // Make DELETE request to the API
    //         fetch(url, {
    //             method: 'DELETE',
    //         })
    //             .then(response => {
    //                 if (response.ok) {
    //                     alert('Account successfully deleted!');
    //                     // Optionally, you can redirect or update the UI here
    //                 } else {
    //                     alert('Error deleting account. Please try again.');
    //                     console.error('Error:', response);
    //                 }
    //             })
    //             .catch(error => {
    //                 alert('An error occurred. Please try again later.');
    //                 console.error('Error:', error);
    //             });
    //     }
    // });


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
                {isLoggedIn ? (
                    <div>
                        <p>You are logged in</p>
                        <button onClick={handleLogout}>Log Out</button>

                        {/* <button id="deleteAccountBtn">Delete Account</button> */}
                    </div>
                ) : (
                    <div>
                        <input
                            type="text"
                            value={username}
                            onChange={(e) => setUsername(e.target.value)}
                            placeholder="Enter your username"
                        />
                        <input
                            type="password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            placeholder="Enter your password"
                        />
                        <button onClick={handleSignIn}>Sign In</button>
                    </div>
                )}
                {error && <p className="error-message">{error}</p>}
            </div>
        </div>
    );
};

export default SignIn;
