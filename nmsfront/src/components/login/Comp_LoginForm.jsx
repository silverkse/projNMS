import react from "react";
import { useNavigate } from "react-router-dom";

function LoginForm() {
  const navigate = useNavigate();

  function handleClick(url) {
    navigate(url);
  }

  return (
    <div id="login">
      <h1>Login</h1>
      <div id="loginArea">
        <input type="text" name="email" id="" placeholder="Email" />
        <input type="password" name="pwd" id="" placeholder="Password" />
        <button type="button" id="loginBtn" onClick={() => handleClick("/main")}>
          Login
        </button>
      </div>
    </div>
  );
}

export default LoginForm;
