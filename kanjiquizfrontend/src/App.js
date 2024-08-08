import logo from './logo.svg';
import './App.css';

import KanjiDisplay from '../src/components/KanjiDisplay';
import NavigationBar from "./components/NavigationBar";
import Login from './pages/Login';
import Signup from './pages/Signup';


function App() {
    let component;
    switch (window.location.pathname) {
        case "/":
            component = <KanjiDisplay />
            break
        case "/login":
            component = <Login />
            break
        case "/signup":
            component = <Signup />
            break;
    }


  return (
      <div>
          <NavigationBar />
          {component}
      </div>
  );
}

export default App;
