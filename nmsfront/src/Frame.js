import {BrowserRouter, Route, Routes} from "react-router-dom";

// pages
import Landing from "./pages/Landing";
import ServiceConnection from "./pages/ServiceConnection";
import Main from "./pages/Main";

// components


//styles
import "./styles/Logo.css";
import "./styles/HeaderFrame.css";
import "./styles/Landing.css";
import "./styles/ServiceConnection.css";

function Frame() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" Component={Landing} />
        <Route path="/serviceConnection" Component={ServiceConnection} />
        <Route path="/main" Component={Main} />
      </Routes>
    </BrowserRouter>
  );
}

export default Frame;
