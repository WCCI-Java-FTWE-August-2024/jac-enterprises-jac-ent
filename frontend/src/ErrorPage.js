import React from "react";
import { Link } from "react-router-dom";

function ErrorPage() {
    return (
        <div style={{ textAlign: "center", padding: "50px" }}>
            {/* Back button */}
            <div className="page-top">
                <Link to="/">
                    <img
                        src="https://cdn.pixabay.com/photo/2012/04/02/16/03/back-24838_1280.png"
                        alt="Back button"
                        style={{ maxWidth: "50px", cursor: "pointer" }}
                    />
                </Link>
                <h2>Oops! Something went wrong.</h2>
            </div>

            {/* Error message */}
            <p style={{ margin: "20px", fontSize: "18px" }}>
                The page you’re looking for doesn’t exist or an error occurred.
            </p>
        </div>
    );
}

export default ErrorPage;