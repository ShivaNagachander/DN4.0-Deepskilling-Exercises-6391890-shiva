import './App.css';
import Home from './Home';
import TrainersList from './TrainersList';
import { BrowserRouter,Route,Routes,Link } from 'react-router-dom';
import trainersMock from './TrainersMock';
import TrainerDetails from './TrainerDetail';
function App() {
  return (
    <div className="App">
      <h1>My Academy Trianers app</h1>
      <BrowserRouter>
      <nav>
        <ul>
          <li><Link to="/">Home</Link></li>
          <li><Link to="/trainers">show trainers</Link></li>
        </ul>
      </nav>
      <Routes>
        <Route path='/' element={<Home />}/>
        <Route path='/trainers' element={<TrainersList trainers={trainersMock} />}/>
        <Route path="/trainer/:trainerId" element={<TrainerDetails trainers={trainersMock} />} />
      </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
