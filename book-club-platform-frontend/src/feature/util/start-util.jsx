import { Star } from "lucide-react";

const StarHalfFilled = ({ color = "text-yellow-400" }) => (
  <div className={`relative w-6 h-6  ${color}`}>
    <Star className="absolute text-gray-400" />
    <div className={`absolute overflow-hidden w-1/2 ${color}`}>
      <Star />
    </div>
  </div>
);

const GetStarRating = ({ rating, color }) => {
  const fullStars = Math.floor(rating);
  const hasHalfStar = rating - fullStars >= 0.5;
  return (
    <div className="flex">
      {[...Array(fullStars)].map((_, i) => (
        <Star key={i} className={color} fill="currentColor" />
      ))}
      {hasHalfStar && <StarHalfFilled color={color} />}
    </div>
  );
};
export { StarHalfFilled, GetStarRating };
