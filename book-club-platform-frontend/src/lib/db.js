const randomTitles = [
  "The Beginning of an Era",
  "A Mysterious Encounter",
  "Rise of the Hero",
  "Secrets in the Shadows",
  "The Ultimate Showdown",
  "Path to Immortality",
  "A Twist of Fate",
  "Trials and Tribulations",
  "Awakening of Power",
  "The Dark Prophecy",
];

const randomTimes = [
  "just now",
  "5 minutes ago",
  "30 minutes ago",
  "2 hours ago",
  "6 hours ago",
  "yesterday",
  "2 days ago",
  "1 week ago",
  "1 month ago",
  "over 1 year ago",
];

export const chapters = Array.from({ length: 88 }, (_, i) => ({
  id: i + 1,
  title: `Chapter ${i + 1}: ${
    randomTitles[Math.floor(Math.random() * randomTitles.length)]
  }`,
  time: randomTimes[Math.floor(Math.random() * randomTimes.length)],
}));

import {
  dreamWalker,
  killingComplex,
  personalGrowth,
  whiteNight,
} from "@/assets/books/book-export";

export const books = [
  {
    id: 1,
    name: "Harry Potter and the Sorcerer’s Stone",
    author: "J.K. Rowling",
    rating: 4.9,
    bookmarked: 1500000,
    lastUpdated: "about 2 days ago",
    genres: ["Fantasy", "Adventure"],
    tags: ["Magic", "Wizards", "Coming-of-Age"],
    status: "Completed",
    wordCount: "77K",
    image: whiteNight, // Update with actual image reference
  },
  {
    id: 2,
    name: "The Hobbit",
    author: "J.R.R. Tolkien",
    rating: 4.8,
    bookmarked: 1200000,
    lastUpdated: "about a week ago",
    genres: ["Fantasy", "Adventure"],
    tags: ["Middle-Earth", "Quest", "Dragons"],
    status: "Completed",
    wordCount: "95K",
    image: dreamWalker,
  },
  {
    id: 3,
    name: "1984",
    author: "George Orwell",
    rating: 4.7,
    bookmarked: 1100000,
    lastUpdated: "about 3 days ago",
    genres: ["Dystopian", "Science Fiction"],
    tags: ["Totalitarianism", "Big Brother", "Surveillance"],
    status: "Completed",
    wordCount: "88K",
    image: killingComplex,
  },
  {
    id: 4,
    name: "To Kill a Mockingbird",
    author: "Harper Lee",
    rating: 4.9,
    bookmarked: 1000000,
    lastUpdated: "about 5 days ago",
    genres: ["Classic", "Drama"],
    tags: ["Racism", "Legal Drama", "Southern Gothic"],
    status: "Completed",
    wordCount: "100K",
    image: personalGrowth,
  },
  {
    id: 5,
    name: "Pride and Prejudice",
    author: "Jane Austen",
    rating: 4.8,
    bookmarked: 900000,
    lastUpdated: "about a month ago",
    genres: ["Romance", "Classic"],
    tags: ["Regency", "Marriage", "Society"],
    status: "Completed",
    wordCount: "120K",
    image: whiteNight,
  },
  {
    id: 6,
    name: "The Catcher in the Rye",
    author: "J.D. Salinger",
    rating: 4.5,
    bookmarked: 850000,
    lastUpdated: "about 10 days ago",
    genres: ["Fiction", "Coming-of-Age"],
    tags: ["Teen Angst", "Rebellion", "Identity"],
    status: "Completed",
    wordCount: "80K",
    image: whiteNight,
  },
  {
    id: 7,
    name: "The Great Gatsby",
    author: "F. Scott Fitzgerald",
    rating: 4.7,
    bookmarked: 950000,
    lastUpdated: "about 2 weeks ago",
    genres: ["Classic", "Tragedy"],
    tags: ["Jazz Age", "Wealth", "American Dream"],
    status: "Completed",
    wordCount: "50K",
    image: dreamWalker,
  },
  {
    id: 8,
    name: "The Alchemist",
    author: "Paulo Coelho",
    rating: 4.6,
    bookmarked: 780000,
    lastUpdated: "about 1 month ago",
    genres: ["Philosophical", "Fantasy"],
    tags: ["Personal Legend", "Adventure", "Self-Discovery"],
    status: "Completed",
    wordCount: "65K",
    image: killingComplex,
  },
];

export const reviews = [
  {
    id: 1,
    username: "aquave",
    rating: 4.7,
    time: "4 months ago",
    avatar: killingComplex, // Replace with actual image URL
    title: "A Satisfying Conclusion",
    content:
      "Not much to say. The good part is that it is completed without much delay, just ends when it needed to end...",
  },
  {
    id: 2,
    username: "supremestar",
    rating: 4,
    time: "4 months ago",
    avatar: dreamWalker, // Replace with actual image URL
    title: "Engaging but Predictable",
    content: "Good read. Just didn't like the origin of the system.",
  },
  {
    id: 3,
    username: "12taki23",
    rating: 5,
    time: "4 months ago",
    avatar: whiteNight, // Replace with actual image URL
    title: "Absolutely Perfect!",
    content:
      "I finished it, and it was great. This novel is perfect and illustrates exactly what is needed...",
  },
  {
    id: 4,
    username: "yudhaajha",
    rating: 1,
    time: "5 months ago",
    avatar: personalGrowth, // Replace with actual image URL
    title: "Disappointing Read",
    content: "I didn't enjoy this book. The protagonist's actions were frustrating.",
  },
];
