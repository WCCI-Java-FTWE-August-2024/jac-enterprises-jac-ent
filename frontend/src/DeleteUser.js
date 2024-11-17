import React from "react";
import { useNavigate } from "react-router-dom";

// Helper function to retrieve a cookie by name
const getCookie = (name) => {
    const match = document.cookie.match(new RegExp('(^| )' + name + '=([^;]+)'));
    return match ? match[2] : null;
};

const DeleteUser = () => {
    const navigate = useNavigate();
    const username = getCookie("username"); // Retrieve username from cookies

    const handleDelete = async () => {
        // Confirm if the user wants to delete their account
        const confirmDelete = window.confirm(
            "Are you sure you want to delete your account? This action cannot be undone."
        );
        if (!confirmDelete) return;

        try {
            // Replace this with the actual ID of the user you want to delete
            const userId = getCookie("userId"); // Assuming userId is stored in cookies

            const response = await fetch(`http://localhost:8080/api/v1/users/${userId}`, {
                method: "DELETE",
            });

            if (response.ok) {
                alert("Account deleted successfully.");
                // Clear relevant cookies
                document.cookie = "authToken=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
                document.cookie = "username=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
                // Redirect the user to the homepage or sign-up page
                navigate("/");
            } else {
                alert("Failed to delete the account. Please try again.");
            }
        } catch (error) {
            console.error("Error deleting user:", error);
            alert("An error occurred while deleting the account. Please try again.");
        }
    };

    return (
        <div>
            <h2>Welcome, {username}</h2>
            <p>
                If you wish to delete your account, please click the button below. This
                action cannot be undone.
            </p>
            <button onClick={handleDelete} style={{ backgroundColor: "red", color: "white" }}>
                Delete My Account
            </button>
        </div>
    );
};

export default DeleteUser;
