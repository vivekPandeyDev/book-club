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
    image: whiteNight,
    clubName: "Fantasy Lovers",
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
    clubName: "Adventure Seekers",
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
    clubName: "Dystopian Thinkers",
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
    clubName: "Classic Readers",
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
    clubName: "Romance Enthusiasts",
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
    clubName: "Young Rebels",
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
    clubName: "Literary Classics",
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
    clubName: "Philosophy Seekers",
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
    content:
      "I didn't enjoy this book. The protagonist's actions were frustrating.",
  },
];

export const bookPages = [
  {
    bookId: 1,
    pages: [
      {
        title: "Land of Diversity",
        pageNo: 1,
        content: `# India

India, officially known as the **Republic of India**, is a country located in South Asia. It is the seventh-largest country by land area and the second-most populous country in the world, with over 1.4 billion people. 

## Geography

- **Location:** Bounded by the Indian Ocean to the south, the Arabian Sea to the southwest, and the Bay of Bengal to the southeast. 
- **Borders:** Shares its borders with Pakistan to the northwest, China and Nepal to the north, Bhutan to the northeast, and Bangladesh and Myanmar to the east. 

## Cultural Diversity

India is renowned for its rich cultural heritage and diversity. The country has:
- **Languages:** Over 1,600 spoken languages, with Hindi and English as official languages.
- **Religions:** Major religions include Hinduism, Islam, Christianity, Sikhism, Buddhism, and Jainism, each contributing to the country’s cultural tapestry.
- **Festivals:** Celebrates a myriad of festivals, such as Diwali, Holi, Eid, and Christmas, which reflect cultural unity and diversity.

## History

India has a long and complex history, featuring:
- **Ancient Civilizations:** The Indus Valley Civilization is one of the world’s oldest urban cultures.
- **Empires:** The Maurya and Gupta Empires have significantly influenced Indian culture and governance.
- **Colonial Period:** The British Raj began in the 18th century, leading to India’s struggle for independence, which was achieved in 1947, primarily through non-violent civil disobedience led by figures like Mahatma Gandhi.

## Economy

India's economy is one of the largest in the world, and it's characterized by:
- **Sectors:** Major sectors include agriculture, manufacturing, and services. The IT and software service industry plays a crucial role in the economy’s growth.
- **Trade:** India engages in international trade with numerous countries and is a member of various global organizations.

## Landmarks

India is home to numerous historical and architectural landmarks, including:
- **Taj Mahal:** An iconic symbol of love and a UNESCO World Heritage Site.
- **Red Fort:** A historical fortification in Delhi, reflecting Mughal architecture.
- **Hampi and Jaipur:** Known for their rich history and stunning architectures.

## Conclusion

India’s diverse culture, rich history, and burgeoning economy make it a focal point in the global landscape, showcasing a unique blend of tradition and modernity.`,
      },
      {
        title: "Union and State",
        pageNo: 2,
        content: `# India

India, officially known as the <span style="color:blue;">**Republic of India**</span>, is a country located in South Asia. It is the seventh-largest country by land area and the second-most populous country in the world, with over 1.4 billion people. 

## Geography

- **Location:** Bounded by the Indian Ocean to the south, the Arabian Sea to the southwest, and the Bay of Bengal to the southeast. 
- **Borders:** Shares its borders with Pakistan to the northwest, China and Nepal to the north, Bhutan to the northeast, and Bangladesh and Myanmar to the east. 

## Cultural Diversity

India is renowned for its rich cultural heritage and diversity. The country has:
- **Languages:** Over 1,600 spoken languages, with <span style="color:green;">Hindi</span> and <span style="color:green;">English</span> as official languages.
- **Religions:** Major religions include <span style="color:orange;">Hinduism</span>, <span style="color:orange;">Islam</span>, <span style="color:orange;">Christianity</span>, <span style="color:orange;">Sikhism</span>, <span style="color:orange;">Buddhism</span>, and <span style="color:orange;">Jainism</span>, each contributing to the country’s cultural tapestry.
- **Festivals:** Celebrates a myriad of festivals, such as <span style="color:red;">Diwali</span>, <span style="color:red;">Holi</span>, <span style="color:red;">Eid</span>, and <span style="color:red;">Christmas</span>, which reflect cultural unity and diversity.

## History

India has a long and complex history, featuring:
- **Ancient Civilizations:** The <span style="color:purple;">Indus Valley Civilization</span> is one of the world’s oldest urban cultures.
- **Empires:** The <span style="color:purple;">Maurya</span> and <span style="color:purple;">Gupta Empires</span> have significantly influenced Indian culture and governance.
- **Colonial Period:** The <span style="color:purple;">British Raj</span> began in the 18th century, leading to India’s struggle for independence, which was achieved in 1947, primarily through non-violent civil disobedience led`,
      },
      {
        title: "birthplace of several major religions",
        pageNo: 3,
        content: ` This is normal paragarph
# React Markdown Example - **Some bold text** - *Some italicized text* - ~~Strikethrough text~~ - [GitHub Flavored Markdown](https://github.com/remarkjs/react-markdown)
- ✅ Task lists supported
- 🚀 GFM adds new features!

## Table Example

| Name  | Age | Country |
|-------|-----|---------|
| Alice | 25  | USA     |
| Bob   | 30  | Canada  |
| Eve   | 22  | Germany |

## Subtitle

### Additional Info
This is a [link](https://github.com/remarkjs/react-markdown)
    `,
      },
      {
        title: "Union and State",
        pageNo: 4,
        content: `# India

India, officially known as the <span style="color:blue;">**Republic of India**</span>, is a country located in South Asia. It is the seventh-largest country by land area and the second-most populous country in the world, with over 1.4 billion people. 

![Taj Mahal](https://placehold.co/600x400) <!-- Replace with a valid image URL -->

---

## Geography

- **Location:** Bounded by the Indian Ocean to the south, the Arabian Sea to the southwest, and the Bay of Bengal to the southeast. 
- **Borders:** Shares its borders with Pakistan to the northwest, China and Nepal to the north, Bhutan to the northeast, and Bangladesh and Myanmar to the east. 

---

## Cultural Diversity

India is renowned for its rich cultural heritage and diversity. The country has:
- **Languages:** Over 1,600 spoken languages, with <span style="color:green;">Hindi</span> and <span style="color:green;">English</span> as official languages.
- **Religions:** Major religions include <span style="color:orange;">Hinduism</span>, <span style="color:orange;">Islam</span>, <span style="color:orange;">Christianity</span>, <span style="color:orange;">Sikhism</span>, <span style="color:orange;">Buddhism</span>, and <span style="color:orange;">Jainism</span>, each contributing to the country’s cultural tapestry.
- **Festivals:** Celebrates a myriad of festivals, such as <span style="color:red;">Diwali</span>, <span style="color:red;">Holi</span>, <span style="color:red;">Eid</span>, and <span style="color:red;">Christmas</span>, which reflect cultural unity and diversity.

---

## History

India has a long and complex history, featuring:
- **Ancient Civilizations:** The <span style="color:purple;">Indus Valley Civilization</span> is one of the world’s oldest urban cultures.
- **Empires:** The <span style="color:purple;">Maurya</span> and <span style="color:purple;">Gupta Empires</span> have significantly influenced Indian culture and governance.
- **Colonial Period:** The <span style="color:purple;">British Raj</span> began in the 18th century, leading to India’s struggle for independence, which was achieved in 1947, primarily through non-violent civil disobedience led by figures like <span style="color:brown;">Mahatma Gandhi</span>.

> "Be the change that you wish to see in the world." — **Mahatma Gandhi**

---

## Economy

India's economy is one of the largest in the world, characterized by:

| Sector          | Description                       |
|------------------|-----------------------------------|
| Agriculture      | Major source of livelihood        |
| Manufacturing    | Diverse products and services     |
| Services         | Fast-growing IT and software sector|

India engages in international trade with numerous countries and is a member of various global organizations.

---

## Landmarks

India is home to numerous historical and architectural landmarks, including:
- **Taj Mahal:** An iconic symbol of love and a <span style="color:teal;">UNESCO World Heritage Site</span>.
- **Red Fort:** A historical fortification in Delhi, reflecting Mughal architecture.
- **Hampi and Jaipur:** Known for their rich history and stunning architectures.

For more information on India, visit the [India Tourism Website](https://www.incredibleindia.org).

---

## Conclusion

India’s diverse culture, rich history, and burgeoning economy make it a focal point in the global landscape, showcasing a unique blend of tradition and modernity.`,
      },
      {
        title: "birthplace of several major religions",
        pageNo: 5,
        content:
          "India’s geographical diversity is equally fascinating. From the snow-capped peaks of the Himalayas to the vast Thar Desert, the lush Western Ghats, and the scenic backwaters of Kerala, the country offers an unparalleled variety of natural landscapes. The Sundarbans, home to the majestic Bengal tiger, and the Great Rann of Kutch, with its surreal white salt desert, are just a few examples of India’s breathtaking biodiversity. The country is also known for its rich wildlife, protected by national parks and sanctuaries that conserve species like the Asiatic lion, Indian elephant, and one-horned rhinoceros.",
      },
      {
        title: "Land of Diversity",
        pageNo: 6,
        content:
          "Tourism in India is a major industry, attracting millions of visitors from around the world. Iconic landmarks such as the Taj Mahal, Jaipur’s palaces, the ancient temples of Khajuraho, and the serene beaches of Goa make India a top travel destination. Each city has a unique blend of history and modernity, offering a glimpse into the country’s glorious past while embracing the advancements of the present. Whether it is the bustling streets of Mumbai, the historical charm of Delhi, or the tranquil beauty of Kerala, every part of India has a story to tell.",
      },
      {
        title: "Land of Diversity",
        pageNo: 7,
        content:
          "In conclusion, India is a land of contrasts and harmony, where ancient traditions blend seamlessly with modern aspirations. It is a nation that continues to evolve, embracing technological advancements while preserving its cultural roots. From its incredible history and diverse heritage to its economic growth and scientific achievements, India remains a fascinating and dynamic country that captivates the world with its spirit, resilience, and beauty.",
      },
    ],
  },
  {
    bookId: 2,
    pages: [
      { pageNo: 1, content: "In a hole in the ground there lived a hobbit..." },
      {
        pageNo: 2,
        content:
          "Not a nasty, dirty, wet hole, filled with the ends of worms...",
      },
      {
        pageNo: 3,
        content:
          "This hobbit was a very well-to-do hobbit, and his name was Baggins...",
      },
    ],
  },
  {
    bookId: 3,
    pages: [
      {
        pageNo: 1,
        content:
          "It was a bright cold day in April, and the clocks were striking thirteen...",
      },
      {
        pageNo: 2,
        content:
          "Winston Smith, his chin nuzzled into his breast, slipped quickly through the glass doors...",
      },
      {
        pageNo: 3,
        content: "The hallway smelt of boiled cabbage and old rag mats...",
      },
    ],
  },
];
