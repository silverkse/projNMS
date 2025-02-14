import { BrowserRouter, Route, Routes } from "react-router-dom";

// pages
import Landing from "./pages/Landing";
import ServiceConnection from "./pages/ServiceConnection";
import Main from "./pages/Main";
import Join from "./pages/Join";

// components
import HeaderFrame from "./components/header/Comp_HeaderFrame";

//styles
import "./styles/Logo.css";
import "./styles/HeaderFrame.css";
import "./styles/Landing.css";
import "./styles/ServiceConnection.css";
import "./styles/Main.css";
import "./styles/GnbMenu.css";
import "./styles/Join.css";

function Frame() {
  return (
    <BrowserRouter>
      <HeaderFrame />
      <Routes>
        <Route path="/" element={<Landing />} />
        <Route path="/serviceConnection" element={<ServiceConnection />} />
        <Route path="/main" element={<Main />} />
        <Route path="/join" element={<Join />} />
      </Routes>
    </BrowserRouter>
  );
}

export default Frame;
