import { Button } from "@/components/ui/button";
import { Card } from "@/components/ui/card";

const BookDetail = ({ title, imageUrl, author, status, wordCount, synopsis }) => {
  return (
    <Card className="p-4 bg-black text-white rounded-lg">
      {/* Container for Responsive Layout */}
      <div className="flex flex-col md:flex-row gap-6">
        {/* Book Cover */}
        <img
          src={imageUrl}
          alt={title}
          className="w-full md:w-64 h-auto md:h-80 object-contain rounded-lg"
          draggable={false}
          loading="lazy"
        />

        {/* Book Details */}
        <div className="flex flex-col w-full">
          <h1 className="text-lg md:text-xl font-bold">{title}</h1>
          <p className="text-sm text-gray-400">Author: {author}</p>
          <p className="text-sm text-gray-400">Status: {status}</p>
          <p className="text-sm text-gray-400">Word Count: {wordCount}</p>

          {/* Buttons */}
          <div className="flex gap-4 mt-4">
            <Button className="bg-yellow-500 text-black px-4 py-2">📖 Read Now</Button>
            <Button variant="outline" className="border-yellow-500 text-yellow-500">
              🔖 Bookmark
            </Button>
          </div>
        </div>
      </div>

      {/* Divider */}
      <div className="w-full h-px bg-gray-700 my-4"></div>

      {/* Synopsis */}
      <h2 className="text-lg font-semibold">Synopsis</h2>
      <p className="text-gray-300 text-sm leading-relaxed mt-2">{synopsis}</p>
    </Card>
  );
};

export default BookDetail;
