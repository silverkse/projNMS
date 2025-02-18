import react from "react";
import { useEffect, useState } from "react";
import HeaderFrame from "../components/header/Comp_HeaderFrame";
import GnbMenu from "../components/gnbMenu/Comp_GnbMenu";
import MainArticle from "../components/mainArticles/Comp_MainArticles";
import { RSS_HEADER } from "../constants/rss_header";
import interceptor from "../api/Api_Interceptor.js";
import { TEST_PATH } from "../constants/test_path.js";

function Main() {

  const [selectedMenu, setSelectedMenu] = useState("world");
  const [headerSentence, setHeaderSentence] = useState(null);

  useEffect(() => {
    const fetchHeader = async () => {
      try {
        const path = TEST_PATH[selectedMenu];
        if(!path) return;

        const response = await interceptor.get(path);
        setHeaderSentence(response.data);
      } catch (error) {
        console.error("Failed to fetch header sentence: ", error);
      }
    };
    fetchHeader();
  }, [selectedMenu]);

  return (
    <>
      <GnbMenu
        selectedMenu={selectedMenu}
        setSelectedMenu={setSelectedMenu}
      ></GnbMenu>
      <h1 id="newsHeader">
        {RSS_HEADER[selectedMenu]} News Feed(rss2json API)
      </h1>
      <h1>
        {headerSentence}
      </h1>
      <MainArticle selectedMenu={selectedMenu}></MainArticle>
    </>
  );
}

export default Main;
