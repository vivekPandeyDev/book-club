import { whiteNight } from "@/assets/books/book-export";
import { Button } from "@/components/ui/button";
import SpanTag from "@/components/ui/custom/span-tag";
import TableContent from "@/feature/table-content/table-content";
import TabNavigation from "@/feature/tabs/tab";
import { GetStarRating } from "@/feature/util/start-util";
import { useParams } from "react-router";

function GetTagList({ tags }) {
  return (
    <>
      {tags.map((tag) => (
        <SpanTag text={tag} key={tag} />
      ))}
    </>
  );
}
const BookDetail = () => {
  const { name } = useParams();
  console.log("name", name);
  const book = {
    name: "Harry Potter and the Sorcerer’s Stone",
    author: "J.K. Rowling",
    rating: 4.9,
    bookmarked: 1050000,
    lastUpdated: "about 2 days ago",
    genres: ["Fantasy", "Adventure"],
    tags: ["Magic", "Wizards", "Coming-of-Age"],
    status: "Completed",
    wordCount: "77K",
    image: whiteNight, // Update with actual image reference
  };

  return (
    <div className="mt-6 mb-6">
      <div className="grid lg:grid-cols-2 grid-cols-1 gap-6 max-w-5xl mx-auto">
        {/* Book Image */}
        <div className="flex justify-center lg:justify-start">
          <img
            src={book.image}
            alt="Global Job Change: Necromancer! I Am a Catastrophe"
            className="w-full lg:w-80 rounded-lg"
          />
        </div>

        {/* Book Info */}
        <div className="text-center lg:text-left">
          <h1 className="text-xl lg:text-2xl font-bold">{book.name}</h1>
          <div className="flex justify-center lg:justify-start gap-2 text-yellow-400 my-2">
            <GetStarRating rating={book.rating} color={"text-red-500"} />
            <span>{book.rating}</span>
          </div>
          <div className="flex justify-center lg:justify-start gap-2 text-gray-700 dark:text-gray-50 text-sm">
            <span>🔖 {book.bookmarked} Bookmarked</span>
            <span>Last Updated: {book.lastUpdated}</span>
          </div>

          <div className="mt-3">
            <p className="font-semibold">Genre(s):</p>
            <div className="flex justify-center lg:justify-start gap-2 mt-1">
              <GetTagList tags={book.genres} />
            </div>
          </div>

          <div className="mt-3">
            <p className="font-semibold">Tag(s):</p>
            <div className="flex justify-center lg:justify-start gap-2 mt-1">
              <GetTagList tags={book.tags} />
            </div>
          </div>

          <div className="mt-3 grid grid-cols-2 gap-2 text-gray-700 dark:text-gray-50 text-sm">
            <span>
              <strong>Author/Uploader:</strong> {book.author}
            </span>
            <span>
              <strong>Status:</strong> {book.status}
            </span>
            <span>
              <strong>Word Count:</strong> {book.wordCount}M
            </span>
          </div>

          <div className="mt-5 flex justify-center lg:justify-start gap-3">
            <Button className="bg-yellow-500 px-5 py-2 rounded-lg text-black dark:text-white dark:bg-amber-600">
              📖 Read Now
            </Button>
            <Button className="border bg-yellow-500  px-5 py-2 rounded-lg text-black dark:text-white dark:bg-amber-600">
              🔖 Bookmark
            </Button>
          </div>
        </div>
      </div>
      <TabNavigation/>
      <TableContent/>
    </div>
  );
};

export default BookDetail;
