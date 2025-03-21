import React, { useState } from 'react'

const useTheme = () => {
    const [theme, setTheme] = useState(() => localStorage.getItem("theme") || "light");
    function setLightTheme(){
        localStorage.setItem("theme","light")
        document.documentElement.classList.remove('dark');
        setTheme("light")
    }
    function setDarkTheme(){
        localStorage.setItem("theme","dark")
        document.documentElement.classList.add('dark');
        setTheme("dark")
    }
    function isLightTheme(){
        return theme == "light"
    }
    function getCurrentTheme(){
        return theme;
    }
    return {
        setLightTheme,
        setDarkTheme,
        isLightTheme,
        getCurrentTheme
    }
}

export default useTheme