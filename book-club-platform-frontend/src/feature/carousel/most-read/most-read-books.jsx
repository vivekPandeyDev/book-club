import React, { useState } from "react";
import { Button } from "@/components/ui/button";
import {
  dreamWalker,
  killingComplex,
  personalGrowth,
  whiteNight,
} from "@/assets/books/book-export";
const books = [
  {
    id: 1,
    rank: "#1",
    title: "Severance",
    author: "Ling Ma",
    image: dreamWalker,
    description:
      "A psychological thriller about employees at Lumon Industries...",
    rating: "0",
    genres: ["Psychological", "Science Fiction", "Thriller"],
    publishedYear: 2018,
    totalReads: 120000,
    completed: true,
    favoriteCount: 4500,
  },
  {
    id: 2,
    rank: "#2",
    title: "Dream Walker",
    author: "Victoria Williamson",
    image: killingComplex,
    description: "A fantasy adventure with magic and mystery.",
    rating: "7.9",
    genres: ["Fantasy", "Adventure", "Mystery"],
    publishedYear: 2020,
    totalReads: 98000,
    completed: false,
    favoriteCount: 3800,
  },
  {
    id: 3,
    rank: "#3",
    title: "The Killing Complex",
    author: "Lee Child",
    image: personalGrowth,
    description: "A gripping crime thriller with shocking twists.",
    rating: "8.5",
    genres: ["Crime", "Thriller"],
    publishedYear: 2015,
    totalReads: 85000,
    completed: true,
    favoriteCount: 5000,
  },
  {
    id: 4,
    rank: "#4",
    title: "White Nights",
    author: "Fyodor Dostoevsky",
    image: whiteNight,
    description: "A romantic drama set in a cold winter landscape.",
    rating: "7.5",
    genres: ["Romance", "Drama"],
    publishedYear: 1848,
    totalReads: 76000,
    completed: true,
    favoriteCount: 3200,
  },
  {
    id: 5,
    rank: "#5",
    title: "Echoes of the Abyss",
    author: "Brandon Sanderson",
    image: personalGrowth,
    description: "A dark fantasy novel about an immortal warrior.",
    rating: "8.9",
    genres: ["Fantasy", "Dark Fantasy", "Adventure"],
    publishedYear: 2022,
    totalReads: 91000,
    completed: false,
    favoriteCount: 4200,
  },
  {
    id: 6,
    rank: "#6",
    title: "Severance",
    author: "Ling Ma",
    image: dreamWalker,
    description:
      "A psychological thriller about employees at Lumon Industries...",
    rating: "0",
    genres: ["Psychological", "Science Fiction", "Thriller"],
    publishedYear: 2018,
    totalReads: 120000,
    completed: true,
    favoriteCount: 4500,
  },
  {
    id: 7,
    rank: "#7",
    title: "Dream Walker",
    author: "Victoria Williamson",
    image: killingComplex,
    description: "A fantasy adventure with magic and mystery.",
    rating: "7.9",
    genres: ["Fantasy", "Adventure", "Mystery"],
    publishedYear: 2020,
    totalReads: 98000,
    completed: false,
    favoriteCount: 3800,
  },
  {
    id: 8,
    rank: "#8",
    title: "The Killing Complex",
    author: "Lee Child",
    image: personalGrowth,
    description: "A gripping crime thriller with shocking twists.",
    rating: "8.5",
    genres: ["Crime", "Thriller"],
    publishedYear: 2015,
    totalReads: 85000,
    completed: true,
    favoriteCount: 5000,
  },
];

const filters = ["Daily", "Weekly", "Monthly", "All Time"];

export default function MostReadBooks() {
  const [activeFilter, setActiveFilter] = useState("Daily");

  return (
    <div className="p-6 rounded-lg">
      {/* Header */}
      <div className="flex justify-between items-center gap-1 border-b border-gray-700 p-2">
        <h2 className="text-lg font-semibold shrink-0">Most Read Books</h2>
        <div className="flex gap-2 overflow-x-auto">
          {filters.map((filter) => (
            <Button
              key={filter}
              variant={activeFilter === filter ? "default" : "outline"}
              className={`px-4 py-2 text-sm ${
                activeFilter === filter
                  ? "bg-yellow-500 text-black"
                  : "text-gray-400"
              }`}
              onClick={() => setActiveFilter(filter)}
            >
              {filter}
            </Button>
          ))}
        </div>
      </div>


      {/* Book List */}
      <div className="mt-4 grid grid-cols-2 md:grid-cols-3 2xl:grid-cols-5 lg:gap-6 overflow-x-none justify-center align-middle">
        {books.map((book) => (
          <div
            key={book.id}
            className="w-36 sm:w-52 shrink-0 place-items-center 2xl:place-items-stretch mt-2"
          >
            {/* Book Image */}
            <div className="relative">
              <img
                src={book.image}
                alt={book.title}
                className="w-full h-48 lg:h-60 rounded-lg"
                draggable="false"
              />
              {book.completed && (
                <span className="absolute top-2 left-2 bg-red-500 text-xs text-white px-2 py-1 rounded">
                  Entire
                </span>
              )}
              <span className="absolute top-2 right-3 bg-yellow-400 text-black font-bold px-2 py-1 text-sm rounded-full">
                {book.rating}
              </span>
            </div>

            {/* Book Details */}
            <div className="w-full lg:ml-0 md:ml-10 ml-4">
            <h3 className="mt-2 text-blue-400 font-bold">{book.rank}</h3>
            <p className="text-md lg:text-lg truncate capitalize">
              {book.title}
            </p>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}
