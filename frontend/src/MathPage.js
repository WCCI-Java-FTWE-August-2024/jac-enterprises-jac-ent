import React from "react";
import { BrowserRouter as Routes, Route, Link } from "react-router-dom";
function Math() {
    return (
        <div>
            <div className="page-top">
                <Link to="/"><img src="https://cdn.pixabay.com/photo/2012/04/02/16/03/back-24838_1280.png" alt="Back button"/></Link>
                <h2>Math</h2>
            </div>
            <div>
                <ul>
                    <li>
                        <Link to="/math/EasyMath">Easy</Link>
                        <Link to="/math/EasyMath">Medium</Link>
                        <Link to="/math/EasyMath">Hard</Link>
                    </li>
                </ul>
            </div>
        </div>
    );
}