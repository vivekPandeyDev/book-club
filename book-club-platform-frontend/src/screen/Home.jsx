import bannerMobile from "@/assets/banner-mobile.webp";
import bannerDesktop from "@/assets/banner.webp";
import { Card } from "@/components/ui/card";
import AnnouncementBar from "@/components/ui/custom/announcement-bar";
import Banner from "@/components/ui/custom/Banner";
import BookCarousel from "@/components/ui/custom/book-carousel";
import logo from "@/assets/logo/logo.png"
import {dreamWalker,killingComplex,personalGrowth,whiteNight} from "@/assets/books/book-export"

const Home = () => {
  const books = [
    { title: "Super God", imageUrl: dreamWalker, time: "32 minutes ago" },
    { title: "Fairy Tail", imageUrl: killingComplex, time: "1 hour ago" },
    { title: "Honkai Impact", imageUrl: personalGrowth, time: "2 hours ago" },
    { title: "Super God", imageUrl: whiteNight, time: "32 minutes ago" },
    { title: "Fairy Tail", imageUrl: killingComplex, time: "1 hour ago" },
    { title: "Honkai Impact", imageUrl: personalGrowth, time: "2 hours ago" },
  ];
  return (
    <div>
      <div>
        <Card className="w-full shadow-none border-none">
        <Banner  bannerDesktop={bannerDesktop} bannerMobile={bannerMobile}/>
        </Card>
      </div>
      <AnnouncementBar message="Our site is in beta. If you're an author or translator, contact us." />

      <div className="p-6">
        <h2 className="text-xl font-bold">RECENTLY ADDED</h2>
        <BookCarousel books={books} />
      </div>
    </div>
  );
};

export default Home;
