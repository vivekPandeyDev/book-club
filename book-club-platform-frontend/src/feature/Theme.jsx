import React from "react";
import { Moon, Sun } from "lucide-react";
import useTheme from "@/hook/useTheme";
import { Button } from "@/components/ui/button";
const Theme = () => {
  const { setLightTheme, setDarkTheme, isLightTheme, getCurrentTheme } =
    useTheme();
  return (
    <div className="fixed bottom-5 right-5">
      <Button
        variant="ghost"
        size="icon"
        onClick={() => (isLightTheme() ? setDarkTheme() : setLightTheme())}
        className="w-10 h-10 bg-gray-300 hover:bg-gray-600"
      >
        {isLightTheme() ? (
          <Moon className="w-10 h-10" />
        ) : (
          <Sun className="w-8 h-8" />
        )}
      </Button>
    </div>
  );
};

export default Theme;
