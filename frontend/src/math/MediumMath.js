import React from "react";
import { BrowserRouter as Routes, Route, Link } from "react-router-dom";


function MediumMath() {
    return (
        <div>
                <div className="page-top">
                <Link to="/math/Math"><img src="https://cdn.pixabay.com/photo/2012/04/02/16/03/back-24838_1280.png" alt="Back button"/></Link>
                <h2>Elementary Math</h2>
            </div>
        </div>
        
    );
}

export default MediumMath;