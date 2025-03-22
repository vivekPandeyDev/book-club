import bannerMobile from "@/assets/banner/bookhive-banner-mobile.webp";
import bannerDesktop from "@/assets/banner/bookhive-banner.webp";
import {
  dreamWalker,
  killingComplex,
  personalGrowth,
  whiteNight,
} from "@/assets/books/book-export";
import { Card } from "@/components/ui/card";
import AnnouncementBar from "@/components/ui/custom/announcement-bar";
import Banner from "@/components/ui/custom/Banner";
import BookCarousel from "@/components/ui/custom/book-carousel";

const Home = () => {
  const books = [
    {
      title:
        "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Vero placeat delectus sunt, aliquam nesciunt quo possimus alias sapiente voluptas eum.",
      imageUrl: dreamWalker,
      time: "32 minutes ago",
    },
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
          <Banner bannerDesktop={bannerDesktop} bannerMobile={bannerMobile} />
        </Card>
      </div>
      <AnnouncementBar message="Our site is in beta. If you're an author or translator, contact us." />

      <div className="p-12">
        <BookCarousel books={books} heading="Recently Added" />
      </div>
    </div>
  );
};

export default Home;
