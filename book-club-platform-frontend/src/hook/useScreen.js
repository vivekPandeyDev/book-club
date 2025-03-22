import { useMediaQuery } from "react-responsive";


const useScreen = () => {
    const isMobile = useMediaQuery({ maxWidth: 768 });
    const isTablet = useMediaQuery({ minWidth: 769, maxWidth: 1024 }); 
    const isDesktop = useMediaQuery({ minWidth: 1025 }); 
    return {isMobile,isDesktop,isTablet}

}

export default useScreen