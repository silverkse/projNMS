import react from "react";
import { useNavigate } from "react-router-dom";
import HeaderFrame from "../components/header/Comp_HeaderFrame";

function Landing() {
  const navigate = useNavigate();

  function handleClick() {
    navigate("/serviceConnection");
  }

  return (
    <>
      <HeaderFrame></HeaderFrame>
      <div id="landing">
        <h1 id="landingCatch">"Get news just for you!"</h1>
        <div id="landingArticle">
          <p>
            NMS’s mail service summarizes and organizes news to suit your
            tastes.{" "}
          </p>
          <p>
            The NMS web page provides a collection of news from each newspaper.
          </p>
          <p>
            You can use the webpage without registering as a member.
            <br /> As long as you remember the guest code issued to you, you can
            receive recommended news that suits your tastes on the web.
          </p>
          <button type="button" onClick={handleClick}>
            Go to service!!
          </button>
        </div>
      </div>
    </>
  );
}

export default Landing;
