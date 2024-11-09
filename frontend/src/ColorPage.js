import React from "react";



function ColorPage() {
    return (
        <Router>
            <div>
                <div className="page-top">
                    <Link to="/">
                        <img src="https://cdn.pixabay.com/photo/2012/04/02/16/03/back-24838_1280.png" alt="Back button" />
                    </Link>
                    <h2>Color Page</h2>
                </div>
                <div>
                    <ul>
                        <li><Link to="/color/Red">Red</Link></li>
                        <li><Link to="/color/Green">Green</Link></li>
                        <li><Link to="/color/Blue">Blue</Link></li>
                        <li><Link to="/color/Yellow">Yellow</Link></li>
                        <li><Link to="/color/Purple">Purple</Link></li>
                        <li><Link to="/color/Orange">Orange</Link></li>
                        <li><Link to="/color/Pink">Pink</Link></li>
                        <li><Link to="/color/Gray">Gray</Link></li>
                        <li><Link to="/color/Black">Black</Link></li>
                        <li><Link to="/color/White">White</Link></li>
                    </ul>
                </div>
                <Routes>
                    <Route path="/color/:colorName" element={<ColorDisplay />} />
                </Routes>
            </div>
        </Router>
    );
}

function ColorDisplay() {
    const { colorName } = useParams();
    return (
        <div style={{ textAlign: "center", backgroundColor: colorName, minHeight: "100vh" }}>
            <h3>{colorName}</h3>
        </div>
    );
}

export default ColorPage;