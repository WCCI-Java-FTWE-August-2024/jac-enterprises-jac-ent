import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";

const SignUp = () => {
    const [token, setToken] = useState(null); // State to store the Bearer token
    const [data, setData] = useState(null); // State to store API response data
    const [username, setUsername] = useState(''); // State for username input
    const [password, setPassword] = useState(''); // State for password input
    const [age, setAge] = useState(''); // State for password input

    // Fetch the Bearer token when the component mounts
    useEffect(() => {
        fetch('http://localhost:8080/api/v1/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ username: 'user', password: 'pass' }), // Placeholder credentials
        })
            .then((response) => response.json())
            .then((result) => {
                setToken(result.token); // Save the token in state
            })
            .catch((error) => {
                console.error('Error fetching token:', error);
            });
    }, []);

    // Fetch data using the Bearer token
    useEffect(() => {
        if (token) {
            fetch('http://localhost:8080/api/v1/users', {
                method: 'GET',
                headers: {
                    Authorization: `Bearer ${token}`, // Add the Bearer token to the header
                },
            })
                .then((response) => response.json())
                .then((data) => {
                    setData(data); // Save the data in state
                })
                .catch((error) => {
                    console.error('Error fetching data:', error);
                });
        }
    }, [token]);

    const submitUser = () => {
        console.log(`Username: ${username}, Password: ${password}`);
        // Add your form submission logic here
    };

    return (
        <div className="page-top">
            <Link to="/">
                <img
                    src="https://cdn.pixabay.com/photo/2012/04/02/16/03/back-24838_1280.png"
                    alt="Back button"
                />
            </Link>
            <h2>Create Account</h2>
            <div className="sign-container">
                {data ? <pre>{JSON.stringify(data, null, 2)}</pre> : <p>Loading...</p>}
                <input
                    type="text"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)} // Update username state
                    placeholder="Enter your username"
                />
                <input
                    type="password" // Password input
                    value={password}
                    onChange={(e) => setPassword(e.target.value)} // Update password state
                    placeholder="Enter your password"
                />
                            <input
                    type="number" // Password input
                    value={age}
                    onChange={(e) => setPassword(e.target.value)} // Update password state
                    placeholder="Enter your age"
                />
                <button onClick={submitUser}>Submit</button>
                <p>Already have an account? <Link to="/SignIn">Sign In!</Link></p>
            </div>
        </div>
    );
};

export default SignUp;
