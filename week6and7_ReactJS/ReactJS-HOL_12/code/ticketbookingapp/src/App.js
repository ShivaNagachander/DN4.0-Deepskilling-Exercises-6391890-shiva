import './App.css';
import { useState } from 'react';

function LoginButton(props) {
  return <button onClick={props.onClick}>Login</button>;
}

function LogoutButton(props) {
  return <button onClick={props.onClick}>Logout</button>;
}

function GuestGreeting(props) {
  return (
    <div>
      <h1>Please sign up.</h1>
      <LoginButton onClick={props.onLogin} />
    </div>
  );
}
function UserGreeting(props) {
  return (
    <div>
      <h1>Welcome Back</h1>
      <LogoutButton onClick={props.onLogout} />
    </div>
  );
}
function Greeting(props) {
  if (props.isLoggedIn) {
    return <UserGreeting onLogout={props.onLogout} />;
  }
  return <GuestGreeting onLogin={props.onLogin} />;
}
function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const handleLogin = () => setIsLoggedIn(true);
  const handleLogout = () => setIsLoggedIn(false);
  return (
    <div className="App">
      <Greeting
        isLoggedIn={isLoggedIn}
        onLogin={handleLogin}
        onLogout={handleLogout}
      />
    </div>
  );
}
export default App;