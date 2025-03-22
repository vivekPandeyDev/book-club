import { Button } from "@/components/ui/button";
import { ScrollArea, ScrollBar } from "@/components/ui/scroll-area";
import { ChevronLeft, ChevronRight } from "lucide-react";
import { useRef } from "react";
import BookCard from "./book-card";

const BookCarousel = ({ books }) => {
  const scrollRef = useRef(null);

  const scrollLeft = () => {
    if (scrollRef.current) {
      console.log("left");
      scrollRef.current.scrollBy({ left: -200, behavior: "smooth" });
    }
  };

  const scrollRight = () => {
    if (scrollRef.current) {
      console.log("right");
      scrollRef.current.scrollBy({ left: 200, behavior: "smooth" });
    }
  };

  return (
    <div className="relative mt-4 w-full">
      {/* Left Scroll Button */}
      <Button
        variant="ghost"
        className="absolute left-2 top-1/2 -translate-y-1/2 z-20 bg-black/50 text-white rounded-full p-2 shadow-lg"
        onClick={scrollLeft}
      >
        <ChevronLeft size={24} />
      </Button>

      {/* Scrollable Area */}
      <ScrollArea className="w-full overflow-hidden rounded-md border">
        <div className="relative">
          <div
            ref={scrollRef}
            className="flex space-x-8 overflow-x-auto p-4 scrollbar-hide"
            style={{ scrollBehavior: "smooth" }} // Ensures smooth scrolling
          >
            {books.map((book, index) => (
              <div key={index} className="shrink-0 w-48">
                <BookCard {...book} />
              </div>
            ))}
          </div>
          <ScrollBar orientation="horizontal" />
        </div>
      </ScrollArea>
      {/* Right Scroll Button */}
      <Button
        variant="ghost"
        className="absolute right-2 top-1/2 -translate-y-1/2 z-20 bg-black/50 text-white rounded-full p-2 shadow-lg"
        onClick={scrollRight}
      >
        <ChevronRight size={24} />
      </Button>
    </div>
  );
};

export default BookCarousel;
