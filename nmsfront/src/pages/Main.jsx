import react from "react";
import { useEffect, useState } from "react";
import HeaderFrame from "../components/header/HeaderFrame";

function Main() {
  const [articles, setArticles] = useState([]);

  useEffect(() => {
    const fetchRSS = async () => {
      try {
        const response = await fetch (
          "https://api.rss2json.com/v1/api.json?rss_url=http://feeds.bbci.co.uk/news/world/rss.xml"
        );
        const data = await response.json();
        console.log(data.items);
        setArticles(data.items);
      } catch (error) {
        console.error("Error fetching RSS:", error);
      }
    };
    fetchRSS();
  }, []);
  return(
    <>
      <HeaderFrame></HeaderFrame>
      <div>
        <h1>RSS 뉴스 피드(rss2json API)</h1>
        <ul>
          {articles.map((article, index) => (
            <li key={index}>
              <img src={article.thumbnail} alt="" />
              <a href={article.link} target="_blank" rel="noopener noreferrer">
                {article.title}
              </a>
            </li>
          ))}
        </ul>
      </div>
    </>
  );
}

export default Main;