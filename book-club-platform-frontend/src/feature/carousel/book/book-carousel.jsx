
import { Swiper, SwiperSlide } from "swiper/react";
import { Navigation, Pagination, Autoplay } from "swiper/modules";
import "swiper/css";
import "swiper/css/navigation";
import "swiper/css/pagination";
import BookCard from "./book-card";
import { useState } from "react";




const BookCarousel = ({books}) => {
  const [activeIndex, setActiveIndex] = useState(0);
  return (
    <div className="w-full mx-auto px-4 py-8">
      <h2 className="text-2xl font-bold  mb-4">Recently Added</h2>
      <Swiper
        modules={[Navigation, Pagination, Autoplay]}
        spaceBetween={10}
        slidesPerView={1}
        breakpoints={{
          320: { slidesPerView: 1.5},
          768: { slidesPerView: 2.5 },
          1024: { slidesPerView: 4.5 },
          1280: { slidesPerView: 5.5 },
        }}
        pagination={{ clickable: true }}
        autoplay={{ delay: 4000 }}
        loop={true}
        className="pb-8"
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
