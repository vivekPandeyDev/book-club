import bannerMobile from "@/assets/banner/bookhive-banner-mobile.webp";
import bannerDesktop from "@/assets/banner/bookhive-banner.webp";
import { Card } from "@/components/ui/card";
import AnnouncementBar from "@/feature/announcement-bar/announcement-bar";
import Banner from "@/feature/banner/banner";
import BookCarousel from "@/feature/carousel/book/book-carousel";
import MostReadBooks from "@/feature/carousel/most-read/most-read-books";
import RecentReviews from "@/feature/carousel/recent-review/recent-review";
import { books, reviews } from "@/lib/db";

const Home = () => {
  return (
    <>
      {/* Header Component already render by base-screen */}
      <Card className="w-full shadow-none border-none">
        <Banner bannerDesktop={bannerDesktop} bannerMobile={bannerMobile} />
      </Card>
      <AnnouncementBar message="Our site is in beta. If you're an author or translator, contact us." />
      <BookCarousel books={books} heading="Recently Added" link={"/more"} />
      <MostReadBooks books={books} />
      <RecentReviews reviews={reviews}/>
      <BookCarousel books={books} heading="Recently Completed" link={"/more"} />
    </>
  );
};

export default Home;
