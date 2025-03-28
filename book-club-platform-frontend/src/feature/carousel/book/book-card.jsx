import { motion } from "framer-motion";

const BookCard = ({ book, isActive }) => {
  return (
    <motion.div
      className="bg-gray-900 text-white shadow-lg  sm:max-w-[300px] rounded-2xl sm:rounded-tl-[40px] sm:rounded-br-[40px] sm:rounded-bl-2xl rounded-tr-xl overflow-hidden"
      animate={{
        scale: isActive ? 0.95 : 1,
        opacity: isActive ? 1 : 0.9,
      }}
      transition={{ duration: 0.4 }}
    >
      <div className="relative">
        {/* Large Image */}
        <img
          src={book.image}
          alt={book.title}
          draggable={false}
          className="w-full h-80 object-full rounded-xl sm:rounded-tl-[40px]"
        />

        {/* Bottom-to-Top Gradient Shadow */}
        <div className="absolute inset-0 bg-gradient-to-t from-black via-black/50 to-transparent"></div>
        {/* Rating */}
        <span className="absolute top-2 right-3 bg-yellow-400 text-black font-bold px-2 py-1 text-sm rounded-full">
          {book.rating}
        </span>

        {/* Book Info - Title, Rating, Genres (Always Visible) */}
        <div className="absolute bottom-0 left-0 right-0 p-5 text-white">
          {/* Title */}
          <motion.h3
            className="text-lg font-bold"
            initial={{ opacity: 0, y: 10 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{ duration: 1.2, delay: 0.3 }}
          >
            {book.title}
          </motion.h3>

          {/* Horizontal Yellow Line */}
          <div className="w-12 h-1 bg-yellow-400 my-2"></div>

          {/* Genres (Always Visible) */}
          <motion.div
            className="mt-2 flex flex-wrap gap-2 max-h-32"
            initial={{ opacity: 0, y: 10 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{ duration: 1.2, delay: 0.5 }}
          >
            {book.genres.map((genre, index) => (
              <span
                key={index}
                className="bg-gray-800 bg-opacity-60 text-gray-200 text-xs px-3 py-1 rounded-full"
              >
                {genre}
              </span>
            ))}
          </motion.div>

          {/* Description (Only Visible on Hover) */}
        </div>
      </div>
    </motion.div>
  );
};

export default BookCard;
