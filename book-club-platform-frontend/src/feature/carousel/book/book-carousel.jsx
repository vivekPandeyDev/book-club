import { Button } from "@/components/ui/button";
import { useState } from "react";
import { Link, NavLink } from "react-router";
import "swiper/css";
import "swiper/css/navigation";
import "swiper/css/pagination";
import { Autoplay, Navigation, Pagination } from "swiper/modules";
import { Swiper, SwiperSlide } from "swiper/react";
import BookCard from "./book-card";
import { getBookLink } from "@/lib/book";

const BookCarousel = ({ books, link,heading }) => {
  const [activeIndex, setActiveIndex] = useState(0);
  return (
    <div className="w-full px-4 py-8">
      <div className="flex justify-between border-b border-gray-700">
        <h2 className="text-lg font-semibold  mb-4">{heading}</h2>
        <Button className="underline" variant="link">
          <Link to={link} className="text-violet-700">More</Link>
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
        autoplay={{ delay: 2000 }}
        loop={true}
        className="mt-2"
        onSlideChange={(swiper) => setActiveIndex(swiper.realIndex)}
      >
        {books.map((book, index) => (
          <SwiperSlide key={index}>
            <NavLink to={getBookLink(book.name,book.clubName)}>
            <BookCard book={book} isActive={index === activeIndex} />
            </NavLink>
          </SwiperSlide>
        ))}
      </Swiper>
    </div>
  );
};

export default BookCarousel;
