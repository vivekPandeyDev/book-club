import IconButtonWithTooltip from "@/components/ui/custom/tooltip-button";
import useScreen from "@/hook/useScreen";
import { LogIn } from "lucide-react";
import React from "react";

const NavHeader = () => {
  const { isMobile } = useScreen();
  return (
    <>
      <div className="flex gap-3">
        <img
          src="/logo.svg"
          loading="lazy"
          draggable={false}
          className="w-16 h-18 sm:w-24 sm:h-24 sm:pt-0"
        ></img>
        <div className="flex flex-col justify-center">
          <h1 className="text-xl sm:text-2xl font-bold">BOOKCLUB</h1>
          <span className="sm:text-sm text-xs">
            An Open Online Platform for Book
          </span>
        </div>
      </div>
      <IconButtonWithTooltip
        tooltipText="sign-in"
        children={<LogIn size={isMobile ? 28 : 24} className="text-gray-700 dark:text-white" />}
      />
    </>
  );
};

export default NavHeader;
