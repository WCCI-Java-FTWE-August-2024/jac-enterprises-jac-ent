import React from "react";
import { Link } from "react-router-dom";

function Home() {
    return (
        <div>
            <div className="page-top">
                <h2>Home</h2>
            </div>
            <ul className="subject-selection">
                <li>
                    <h2>Math Zone</h2>
                    <Link to="/math/Math"><img src="https://img.freepik.com/free-vector/cartoon-math-word-with-math-symbols_1308-97111.jpg?semt=ais_hybrid" alt="Link for Math section."/></Link>
                    <p>Can you count to 10? Do you know what numbers add up to 10? Let's see!</p>
                </li>
                <li>
                    <h2>Color Zone</h2>
                    <Link to="/color/Color"><img src="https://cdn.vectorstock.com/i/preview-1x/28/71/children-crayons-on-a-white-background-vector-44332871.jpg" alt="Link for Colors section."/></Link>
                    <p>Do you know what color a fire truck is? Let's see what you know!</p>
                </li>
                <li>
                    <h2>Animal Zone</h2>
                    <Link to="/animal/Animal"><img src="https://t4.ftcdn.net/jpg/01/21/54/05/360_F_121540502_XpeAA3nndIJAV5lR6EIAsAYMmNZgtgwH.jpg" alt="Link for Animals section."/></Link>
                    <p>How much do you know about Animals? Let's answer some questions about them!</p>
                </li>
            </ul>
        </div>
    );
}

export default Home;