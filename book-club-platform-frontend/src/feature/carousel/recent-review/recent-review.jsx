import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar";
import { Button } from "@/components/ui/button";
import { GetStarRating } from "@/feature/util/start-util";
import { ChevronLeft, ChevronRight } from "lucide-react";
import "swiper/css";
import "swiper/css/navigation";
import { Navigation } from "swiper/modules";
import { Swiper, SwiperSlide } from "swiper/react";
import { dreamWalker } from "@/assets/books/book-export";
const reviews = [
  {
    username: "josephnzareno1",
    rating: 4.6,
    title:
      "Korean Drama: More Children More Happiness, Sister-in-law is Broken",
    review: "Good novel. More more more more more more more...",
  },
  {
    username: "ysghsgsh",
    rating: 5,
    title: "Demon Slayer: God-Level Support System",
    review:
      "Short and good story. He doesn't have his own breathing, but I enjoyed reading this...",
  },
  {
    username: "iworkshop",
    rating: 3,
    title:
      "Basic Attacks Permanently Increase HP, This Archer Is Tanky as Hell!",
    review:
      "Confusing. It started off well, but the further you go, the more nonsense...",
  },
  {
    username: "ysghsgsh",
    rating: 5,
    title: "Demon Slayer: God-Level Support System",
    review:
      "Short and good story. He doesn't have his own breathing, but I enjoyed reading this...",
  },
  {
    username: "iworkshop",
    rating: 3,
    title:
      "Basic Attacks Permanently Increase HP, This Archer Is Tanky as Hell!",
    review:
      "Confusing. It started off well, but the further you go, the more nonsense...",
  },
];

export default function RecentReviews() {
  return (
    <div className="p-6 rounded-lg">
      <div className="flex w-full border-b border-gray-700 p-2">
        <h2 className="text-sm font-semibold pt-5 flex-1">RECENT REVIEWS</h2>

        {/* Navigation Buttons */}
        <div className="flex justify-end mt-4 gap-2 flex-1">
          <Button variant="outline" className="prev-btn bg-amber-300">
            <ChevronLeft size={20} />
          </Button>
          <Button variant="outline" className="next-btn bg-amber-300">
            <ChevronRight size={20} />
          </Button>
        </div>
      </div>

      {/* Swiper Slider */}
      <Swiper
        modules={[Navigation]}
        spaceBetween={20}
        slidesPerView={1}
        navigation={{ nextEl: ".next-btn", prevEl: ".prev-btn" }}
        breakpoints={{
          640: { slidesPerView: 1 },
          1024: { slidesPerView: 2 },
          1280: { slidesPerView: 3 },
        }}
        className="mt-4"
      >
        {reviews.map((review, index) => (
          <SwiperSlide
            key={index}
            className="p-4 rounded-lg bg-gray-300 dark:bg-gray-800 min-h-48"
          >
            <div className="flex items-center gap-3">
              <Avatar className="w-12 h-12">
                <AvatarImage src={dreamWalker}/>
                <AvatarFallback>CN</AvatarFallback>
              </Avatar>

              <div className="flex justify-between w-full">
                <h3 className="text-md font-medium">{review.username}</h3>
                <GetStarRating rating={review.rating} color={"text-red-500"} />
              </div>
            </div>
            <h4 className="m-2 font-semibold">{review.title}</h4>
            <p className="text-sm text-gray-700 dark:text-gray-100 mt-4">
              {review.review}
            </p>
          </SwiperSlide>
        ))}
      </Swiper>
    </div>
  );
}
