import {BrowserRouter, Route, Routes} from "react-router-dom";

// pages
import Landing from "./pages/Landing";
import Main from "./pages/Main";

// components


//styles
import "./styles/Logo.css";
import "./styles/HeaderFrame.css";
import "./styles/Landing.css";

function Frame() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" Component={Landing} />
        <Route path="/main" Component={Main} />
      </Routes>
    </BrowserRouter>
  );
}

export default Frame;
