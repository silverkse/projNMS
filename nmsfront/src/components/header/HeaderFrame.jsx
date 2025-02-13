import Logo from "../logo/Logo";

function HeaderFrame() {
  return (
    <div id="headerFrame">
      <div id="logoPosition">
        <Logo></Logo>
        <p>&nbsp; News Mailing Service</p>
      </div>
      {/* <button type="button">Go to News</button> */}
    </div>
  );
}

export default HeaderFrame;
