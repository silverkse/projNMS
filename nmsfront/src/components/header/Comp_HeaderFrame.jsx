import { useLocation } from "react-router-dom";
import JoinBtn from "../button/Comp_JoinBtn";
import LoginBtn from "../button/Comp_LoginBtn";
import LogoutBtn from "../button/Comp_LogoutBtn";
import Logo from "../logo/Comp_Logo";

function LoggedInElement() {
  return (
    <div id="mainPageBtnArea">
      <LogoutBtn/>
    </div>
  )
}

function GuestElement() {
  return (
    <div id="mainPageBtnArea">
      <LoginBtn />
      <JoinBtn />
    </div>
  );
}

function HeaderFrame() {
  const location = useLocation();
  const isLoggined = false;
  console.log("경로: ", location.pathname);

  return (
    <div id="headerFrame">
      <div id="logoPosition">
        <Logo></Logo>
        <p>&nbsp; News Mailing Service</p>
      {
        location.pathname === '/main' && (isLoggined ? <LoggedInElement/> : <GuestElement/>)
      }
      </div>
      {/* <button type="button">Go to News</button> */}
    </div>
  );
}

export default HeaderFrame;
