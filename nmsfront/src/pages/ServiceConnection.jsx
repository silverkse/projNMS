import react from "react";
import { useNavigate } from "react-router-dom";
import HeaderFrame from "../components/header/Comp_HeaderFrame";
import LoginForm from "../components/login/Comp_LoginForm";

function ServiceConnection() {
  const navigate = useNavigate();

  function handleClick(url) {
    navigate(url);
  }

  return (
    <div id="serviceConnection">
      <LoginForm />
      <hr />
      <div id="join">
        <h1>Join</h1>
        <button type="button" id="joinBtn" onClick={() => handleClick("/join")}>
          Go to join
        </button>
      </div>
      <hr />
      <div id="guestArea">
        <h1>Guest</h1>
        <input
          type="text"
          name=""
          id=""
          placeholder="If you have a code, enter it"
        />
        <button type="button" onClick={() => handleClick("/main")}>
          View as a guest
        </button>
      </div>
    </div>
  );
}

export default ServiceConnection;
