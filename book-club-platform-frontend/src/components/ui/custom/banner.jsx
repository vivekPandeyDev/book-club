import { useState, useEffect } from "react";

const Banner = ({ bannerMobile, bannerDesktop }) => {
  const [banner, setBanner] = useState(bannerDesktop); // Default to desktop image

  useEffect(() => {
    const updateBanner = () => {
      if (window.innerWidth <= 600) {
        setBanner(bannerMobile);
      } else {
        setBanner(bannerDesktop);
      }
    };

    updateBanner(); // Run on mount
    window.addEventListener("resize", updateBanner); // Listen for resize events

    return () => {
      window.removeEventListener("resize", updateBanner); // Cleanup on unmount
    };
  }, [bannerMobile, bannerDesktop]);

  return (
    <img
      src={banner}
      alt="BookHive Banner"
      className="w-full object-cover h-[500px] md:h-80 lg:h-[500px]"
    />
  );
};

export default Banner;
