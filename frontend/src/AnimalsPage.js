import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

function AnimalsPage () {
    return (
        <div>
            <div className="page-top">
                <Link to="/">
                    <img src="https://cdn.pixabay.com/photo/2012/04/02/16/03/back-24838_1280.png" alt="Back button" />
                </Link>
                <h2>Animals</h2>
            </div>
            <div>
                <ul>
                <li><Link to="/animal/Cat">Cat</Link></li>
                    <li><Link to="/animal/Dog">Dog</Link></li>
                    <li><Link to="/animal/Elephant">Elephant</Link></li>
                    <li><Link to="/animal/Lion">Lion</Link></li>
                    <li><Link to="/animal/Tiger">Tiger</Link></li>
                    <li><Link to="/animal/Giraffe">Giraffe</Link></li>
                    <li><Link to="/animal/Monkey">Monkey</Link></li>
                    <li><Link to="/animal/Bear">Bear</Link></li>
                    <li><Link to="/animal/Zebra">Zebra</Link></li>
                    <li><Link to="/animal/Panda">Panda</Link></li>
                    <li><Link to="/animal/Kangaroo">Kangaroo</Link></li>
                    <li><Link to="/animal/Fox">Fox</Link></li>
                    <li><Link to="/animal/Wolf">Wolf</Link></li>
                    <li><Link to="/animal/Horse">Horse</Link></li>
                    <li><Link to="/animal/Cow">Cow</Link></li>
                </ul>
            </div>
        </div>
    );
}
function Animal({ name, imageUrl }) {
    return (
        <div style={{ textAlign: "center" }}>
            <h3>{name}</h3>
            <img src={imageUrl} alt={name} style={{ width: "150px", marginTop: "10px" }} />
        </div>
    );
}

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<Animals />} />
                <Route path="/animal/Cat" element={<Animal name="Cat" imageUrl="https://cdn.pixabay.com/photo/2016/04/01/09/23/cartoon-1300629_1280.png" />} />
                <Route path="/animal/Dog" element={<Animal name="Dog" imageUrl="https://cdn.pixabay.com/photo/2016/03/31/19/58/cartoon-1299631_1280.png" />} />
                <Route path="/animal/Elephant" element={<Animal name="Elephant" imageUrl="https://cdn.pixabay.com/photo/2017/01/31/13/05/elephant-2024588_1280.png" />} />
                <Route path="/animal/Lion" element={<Animal name="Lion" imageUrl="https://cdn.pixabay.com/photo/2017/01/31/16/30/lion-2025594_1280.png" />} />
                <Route path="/animal/Tiger" element={<Animal name="Tiger" imageUrl="https://cdn.pixabay.com/photo/2017/01/31/16/32/tiger-2025613_1280.png" />} />
                <Route path="/animal/Giraffe" element={<Animal name="Giraffe" imageUrl="https://cdn.pixabay.com/photo/2013/07/13/11/34/giraffe-158188_1280.png" />} />
                <Route path="/animal/Monkey" element={<Animal name="Monkey" imageUrl="https://cdn.pixabay.com/photo/2016/04/01/10/14/cartoon-1300644_1280.png" />} />
                <Route path="/animal/Bear" element={<Animal name="Bear" imageUrl="https://cdn.pixabay.com/photo/2016/04/01/10/21/cartoon-1300672_1280.png" />} />
                <Route path="/animal/Zebra" element={<Animal name="Zebra" imageUrl="https://cdn.pixabay.com/photo/2017/01/31/13/05/zebra-2024585_1280.png" />} />
                <Route path="/animal/Panda" element={<Animal name="Panda" imageUrl="https://cdn.pixabay.com/photo/2017/01/31/13/05/panda-2024587_1280.png" />} />
                <Route path="/animal/Kangaroo" element={<Animal name="Kangaroo" imageUrl="https://cdn.pixabay.com/photo/2017/01/31/13/05/kangaroo-2024589_1280.png" />} />
                <Route path="/animal/Fox" element={<Animal name="Fox" imageUrl="https://cdn.pixabay.com/photo/2016/04/01/10/22/cartoon-1300675_1280.png" />} />
                <Route path="/animal/Wolf" element={<Animal name="Wolf" imageUrl="https://cdn.pixabay.com/photo/2017/01/31/16/28/wolf-2025585_1280.png" />} />
                <Route path="/animal/Horse" element={<Animal name="Horse" imageUrl="https://cdn.pixabay.com/photo/2017/01/31/16/32/horse-2025614_1280.png" />} />
                <Route path="/animal/Cow" element={<Animal name="Cow" imageUrl="https://cdn.pixabay.com/photo/2012/04/10/23/27/cow-26871_1280.png" />} />
            </Routes>
        </Router>
    );
}


export default AnimalsPage;