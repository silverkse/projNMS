import react from "react";
import { RSS_URL_BBC } from "../../constants/rss_url";
import React from "react";

function GnbMenu({setSelectedMenu, selectedMenu}) {
  const categories = [
    { key: "world", label: "World" },
    { key: "business", label: "Business" },
    { key: "culture", label: "Culture" },
    { key: "ent_art", label: "Entertainment & Arts" },
    { key: "health", label: "Health" },
    { key: "sci_env", label: "Science & Environment" },
    { key: "sports", label: "Sports" },
    { key: "tech", label: "Technology" },
  ];

  return (
    <div id="gnbFrame">
      <div id="gnbBar" className="dFlex">
        {categories.map((category, index) => (
          <React.Fragment key={category.key}>
            <div
              className={selectedMenu === category.key ? "selected" : ""}
              onClick={() => setSelectedMenu(category.key)}
            >
              {category.label}
            </div>
            {index < categories.length -1 && <div>|</div>}
          </React.Fragment>
        ))}
      </div>
    </div>
    // <div id="gnbFrame">
    //   <div id="gnbBar" className="dflex">
    //     <div>World</div>
    //     <div>|</div>
    //     <div>Business</div>
    //     <div>|</div>
    //     <div>Culture</div>
    //     <div>|</div>
    //     <div>Entertainment & Arts</div>
    //     <div>|</div>
    //     <div>Health</div>
    //     <div>|</div>
    //     <div>Science & Environment</div>
    //     <div>|</div>
    //     <div>Sports</div>
    //   </div>
    // </div>
  );
}

export default GnbMenu;