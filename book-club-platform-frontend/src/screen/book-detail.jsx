import { Button } from "@/components/ui/button";
import SpanTag from "@/components/ui/custom/span-tag";
import SimilarBook from "@/feature/carousel/book-grid/book-grid";
import BookDiscussion from "@/feature/discussion/book-discussion";
import BookReviews from "@/feature/review/book-review";
import TableContent from "@/feature/table-content/table-content";
import TabNavigation from "@/feature/tabs/tab";
import { GetStarRating } from "@/feature/util/start-util";
import { books, reviews } from "@/lib/db";
import { useState } from "react";
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

const TABLE_OF_CONTENT = "Table of Contents";
const BOOK_DISCUSSION = "Book Discussion";
const BOOK_REVIEW = "Book Reviews";
const SIMILAR_BOOK = "Similar Book";


const getRandomElement = (arr) => arr[Math.floor(Math.random() * arr.length)]
const BookDetail = () => {
  const { name } = useParams();
  const [activeTab, setActiveTab] = useState(TABLE_OF_CONTENT);
  const book = getRandomElement(books)

  return (
    <div className="mt-6 mb-6">
      <div className="grid lg:grid-cols-2 grid-cols-1 gap-6 max-w-5xl mx-auto">
        {/* Book Image */}
        <div className="flex justify-center lg:justify-start">
          <img
            src={book.image}
            alt={book.name}
            className="w-full lg:w-80 rounded-lg"
            draggable={false}
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
      <TabNavigation activeTab={activeTab} setActiveTab={setActiveTab} />
      {activeTab === TABLE_OF_CONTENT && <TableContent />}
      {activeTab === BOOK_DISCUSSION && <BookDiscussion />}
      {activeTab === BOOK_REVIEW && <BookReviews reviews={reviews}/>}
      {activeTab == SIMILAR_BOOK && <SimilarBook books={books}/>}
    </div>
  );
};

export default BookDetail;
