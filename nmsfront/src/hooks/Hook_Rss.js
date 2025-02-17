import { useState, useEffect } from "react";

function Hook_Rss(url) {
  const [articles, setArticles] = useState([]);

  useEffect(() => {
    const fetchArticles = async () => {
      try {
        const response = await fetch(
          `https://api.rss2json.com/v1/api.json?rss_url=${url}`
        );
        const data = await response.json();
        if (data.items) {
          setArticles(data.items);
        } else {
          setArticles([]);
        }
        console.log(data.items);
      } catch (error) {
        console.error("Error fetching RSS articles:", error);
        setArticles([]);
      }
    };
    if(url) {
      fetchArticles();
    }
  }, [url]);

  return articles;

}

export default Hook_Rss;