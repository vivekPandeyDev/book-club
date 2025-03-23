import React from "react";
import { Moon, Sun } from "lucide-react";
import useTheme from "@/hook/useTheme";
import { Button } from "@/components/ui/button";

const Theme = () => {
  const { setLightTheme, setDarkTheme, isLightTheme } = useTheme();

  return (
    <div className="fixed bottom-5 right-5">
      <Button
        variant="ghost"
        size="icon"
        onClick={() => (isLightTheme() ? setDarkTheme() : setLightTheme())}
        className="p-2 transition-all duration-300 hover:scale-110"
      >
        {isLightTheme() ? (
          <Moon className="w-8 h-8 text-gray-800 dark:text-gray-200 transition-all duration-300" />
        ) : (
          <Sun className="w-8 h-8 text-yellow-500 transition-all duration-300" />
        )}
      </Button>
    </div>
  );
};

export default Theme;
