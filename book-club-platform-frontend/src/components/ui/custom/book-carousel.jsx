import { ScrollArea, ScrollBar } from "@/components/ui/scroll-area";
import BookCard from "./book-card";

const BookCarousel = ({ books, heading }) => {
  return (
    <div>
      <h2 className="text-xl font-bold">{heading && heading.toUpperCase()}</h2>
      <hr className="border-t border-gray-300 my-2" />
      <div className="relative mt-4 w-full">
        <ScrollArea className="w-full overflow-hidden rounded-md border">
          <div className="relative">
            <div
              className="flex space-x-8 overflow-x-auto p-4 scrollbar-hide"
              style={{ scrollBehavior: "smooth" }}
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
      </div>
    </div>
  );
};

export default BookCarousel;
