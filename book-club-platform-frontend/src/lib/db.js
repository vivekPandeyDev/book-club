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
