import Navbar from "@/feature/nav/nav-bar";
import Theme from "@/feature/theme/theme";
import React from "react";
import { Outlet } from "react-router";

const BaseScreen = () => {
  return (
    <div className="bg-white text-black dark:bg-gray-900 dark:text-white">
      <Navbar />
      <div className="container mx-auto px-4">
        <Outlet />
      </div>
      <Theme/>
    </div>
  );
};

export default BaseScreen;
