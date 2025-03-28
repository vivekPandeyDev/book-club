import React, { useState } from "react";

const TabNavigation = () => {
  const tabs = [
    { name: "Table of Contents", count: 3740 },
    { name: "Novel Reviews", count: 366 },
    { name: "Novel Discussion", count: 82 },
    { name: "Similar Book", count: null },
  ];

  const [activeTab, setActiveTab] = useState("Novel Discussion");

  return (
    <div className="mt-5 overflow-auto">
      <div className="flex justify-between items-center text-sm py-2 px-4">
        {tabs.map((tab) => (
          <button
            key={tab.name}
            className={`px-4 pb-2 text-sm lg:text-lg font-semibold ${
              activeTab === tab.name
                ? "text-teal-400 border-b-2 border-teal-400"
                : "text-gray-700"
            }`}
            onClick={() => setActiveTab(tab.name)}
          >
            {tab.name} {tab.count !== null && `(${tab.count})`}
          </button>
        ))}
      </div>
      <div className="h-[2px] w-full bg-gray-600 mt-1">
        <div
          className="h-[2px] bg-teal-400 transition-all duration-300"
          style={{
            width: `${(tabs.findIndex((tab) => tab.name === activeTab) + 1) * 25}%`,
          }}
        ></div>
      </div>
    </div>
  );
};

export default TabNavigation;
