import { useNavigate } from "react-router-dom";


function LoginBtn() {
  const navigate = useNavigate();

  function handleClick() {
    navigate("/serviceConnection");
  }
  return (
    <button type="button" id="mainPageLoginBtn" onClick={handleClick}>
      Login
    </button>
  );
}

export default LoginBtn;
