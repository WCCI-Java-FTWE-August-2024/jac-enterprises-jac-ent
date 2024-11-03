import React from "react";
import { BrowserRouter as Routes, Route, Link } from "react-router-dom";


function Math() {
    return (
        <div>
            <div className="page-top">
                <Link to="/"><img src="https://cdn.pixabay.com/photo/2012/04/02/16/03/back-24838_1280.png" alt="Back button"/></Link>
                <h2>Math Zone</h2>
            </div>

            <div className="content-buttons">
                <ul>
                    <li>
                        <Link to="/math/EasyMath">Easy</Link>
                        
                    </li>
                    <li>
                        <Link to="/math/EasyMath">Medium</Link>
                    </li>
                    <li>
                        <Link to="/math/EasyMath">Hard</Link>
                    </li>
                </ul>
            </div>
        </div>
    );
}

export default Math;