import bannerMobile from "@/assets/banner/bookhive-banner-mobile.webp";
import bannerDesktop from "@/assets/banner/bookhive-banner.webp";
import {
  dreamWalker,
  killingComplex,
  personalGrowth,
  whiteNight,
} from "@/assets/books/book-export";
import { Card } from "@/components/ui/card";
import AnnouncementBar from "@/feature/announcement-bar/announcement-bar";
import Banner from "@/feature/banner/banner";
import BookCarousel from "@/feature/carousel/book/book-carousel";
import MostReadBooks from "@/feature/carousel/most-read/most-read-books";

const Home = () => {
  const books = [
    {
      title: "Severance",
      image: dreamWalker,
      description:
        "A psychological thriller about employees at Lumon Industries...",
      rating: "8.7",
      genres: [
        "Psychological",
        "Science",
        "Psychological Thriller",
        "Science Fiction",
      ],
    },
    {
      title: "Dream Walker",
      image: killingComplex,
      description: "A fantasy adventure with magic and mystery.",
      rating: "7.9",
      genres: [
        "Psychological Thriller",
        "Science Fiction",
        "Psychological Thriller",
        "Science Fiction",
      ],
    },
    {
      title: "The Killing Complex",
      image: personalGrowth,
      description: "A gripping crime thriller with shocking twists.",
      rating: "8.5",
      genres: ["Crime", "Thriller"],
    },
    {
      title: "White Nights",
      image: whiteNight,
      description: "A romantic drama set in a cold winter landscape.",
      rating: "7.5",
      genres: ["Romance", "Drama"],
    },
    {
      title: "The Killing Complex",
      image: personalGrowth,
      description: "A gripping crime thriller with shocking twists.",
      rating: "8.5",
      genres: ["Crime", "Thriller"],
    },
    {
      title: "White Nights",
      image: whiteNight,
      description: "A romantic drama set in a cold winter landscape.",
      rating: "7.5",
      genres: ["Romance", "Drama"],
    },
  ];
  return (
    <>
      <div>
        <Card className="w-full shadow-none border-none">
          <Banner bannerDesktop={bannerDesktop} bannerMobile={bannerMobile} />
        </Card>
      </div>
      <AnnouncementBar message="Our site is in beta. If you're an author or translator, contact us." />

      <BookCarousel books={books} heading="Recently Added" link={"/more"} />
      <MostReadBooks />
    </>
  );
};

export default Home;
