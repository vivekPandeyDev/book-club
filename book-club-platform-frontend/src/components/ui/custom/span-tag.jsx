import React from "react";

const SpanTag = ({
  bgColor = "bg-yellow-500",
  bgDarkColor = "bg-gray-700",
  text = "",
}) => {
  return (
    <span className={`${bgColor} dark:${bgDarkColor} px-3 py-1 rounded-full`}>
      {text}
    </span>
  );
};

export default SpanTag;
