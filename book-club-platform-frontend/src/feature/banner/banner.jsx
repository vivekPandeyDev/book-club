import useScreen from "@/hook/useScreen";
import { useState, useEffect } from "react";

const Banner = ({ bannerMobile, bannerDesktop }) => {
  const { isMobile } = useScreen();
  const [banner, setBanner] = useState(bannerDesktop);

  useEffect(() => {
    setBanner(isMobile ? bannerMobile : bannerDesktop);
  }, [isMobile, bannerMobile, bannerDesktop]);

  return (
    <img
      src={banner}
      alt="BookHive Banner"
      className="w-full object-fill h-[300px] md:h-80 lg:h-[350px] rounded-2xl"
    />
  );
};

export default Banner;
