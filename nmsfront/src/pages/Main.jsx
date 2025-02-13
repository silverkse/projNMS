import react from "react";
import { useEffect, useState } from "react";
import HeaderFrame from "../components/header/Comp_HeaderFrame";
import GnbMenu from "../components/gnbMenu/Comp_GnbMenu";
import MainArticle from "../components/mainArticles/Comp_MainArticles";
import { RSS_HEADER } from "../constants/rss_header";

function Main() {
  const [selectedMenu, setSelectedMenu] = useState("world");

  return (
    <>
      <HeaderFrame></HeaderFrame>
      <GnbMenu
        selectedMenu={selectedMenu}
        setSelectedMenu={setSelectedMenu}
      ></GnbMenu>
      <h1 id="newsHeader">{RSS_HEADER[selectedMenu]} News Feed(rss2json API)</h1>
      <MainArticle selectedMenu={selectedMenu}></MainArticle>
    </>
  );
}

export default Main;
