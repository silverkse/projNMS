import react from "react";
import { useNavigate } from "react-router-dom";
import HeaderFrame from "../components/header/HeaderFrame";

function ServiceConnection() {
  const navigate = useNavigate();

  function handleClick() {
    navigate("/main");
  }

  return (
    <>
      <HeaderFrame></HeaderFrame>
      <div id="serviceConnection">
        <div id="login">
          <h1>Login</h1>
          <div id="loginArea">
            <input type="text" name="email" id="" placeholder="Email"/>
            <input type="password" name="pwd" id="" placeholder="Password"/>
            <button type="button" id="loginBtn">Login</button>
          </div>
        </div>
        <hr />
        <div id="join">
            <h1>Join</h1>
            <button type="button" id="joinBtn">Go to join</button>
        </div>
        <hr />
        <div id="guestArea">
            <h1>Guest</h1>
          <input type="text" name="" id="" placeholder="If you have a code, enter it"/>
          <button type="button" onClick={handleClick}>View as a guest</button>
        </div>

      </div>
    </>
  );
}

export default ServiceConnection;