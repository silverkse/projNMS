import { useNavigate } from "react-router-dom";

function JoinBtn() {
  const navigate = useNavigate();

  function handleClick() {
    navigate("/join");
  }
  return(
    <button type="button" id="mainPageJoinBtn" onClick={handleClick}>
      Join
    </button>
  );
}

export default JoinBtn;
