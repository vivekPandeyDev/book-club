import { Button } from "@/components/ui/button";
import { useState } from "react";
import { Link } from "react-router";
import "swiper/css";
import "swiper/css/navigation";
import "swiper/css/pagination";
import { Autoplay, Navigation, Pagination } from "swiper/modules";
import { Swiper, SwiperSlide } from "swiper/react";
import BookCard from "./book-card";

const BookCarousel = ({ books, link,heading }) => {
  const [activeIndex, setActiveIndex] = useState(0);
  return (
    <div className="w-full mx-auto px-4 py-8">
      <div className="flex justify-between border-b border-gray-700">
        <h2 className="text-lg font-semibold  mb-4">{heading}</h2>
        <Button className="underline" variant="link">
          <Link to={link}>More</Link>
        </Button>
      </div>
      <Swiper
        modules={[Navigation, Pagination, Autoplay]}
        spaceBetween={10}
        slidesPerView={1}
        breakpoints={{
          320: { slidesPerView: 1.5 },
          768: { slidesPerView: 3.5 },
          1024: { slidesPerView: 4.5 },
          1280: { slidesPerView: 5.5 },
        }}
        pagination={{ clickable: true }}
        autoplay={{ delay: 4000 }}
        loop={true}
        className="pb-8 mt-2"
        onSlideChange={(swiper) => setActiveIndex(swiper.realIndex)}
      >
        {books.map((book, index) => (
          <SwiperSlide key={index}>
            <BookCard book={book} isActive={index === activeIndex} />
          </SwiperSlide>
        ))}
      </Swiper>
    </div>
  );
};

export default BookCarousel;
