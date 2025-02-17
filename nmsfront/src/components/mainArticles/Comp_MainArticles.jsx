import react from "react";
import { useNavigate } from "react-router-dom";
import { RSS_URL_BBC } from "../../constants/rss_url";
import Hook_Rss from "../../hooks/Hook_Rss";

function MainArticle({selectedMenu}) {
  const articles = Hook_Rss(RSS_URL_BBC[selectedMenu]) || []; // undefined 방지;
  return (
    <div id="main" className="dflex">
      <div id="mainArticle">
        <div id="contents">
          {articles.length > 0 ? (
            articles.map((article, index) => (
            <div
              key={index}
              onClick={() => {
                window.location.href = article.link;
              }}
            >
              <img src={article.thumbnail} alt="" />
              <p>{article.title}</p>
            </div>
          ))
          ) : (
            <p>Loading articles...</p>
          )}
        </div>
      </div>
    </div>
  );
}

export default MainArticle;