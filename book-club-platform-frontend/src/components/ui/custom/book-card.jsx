import { Card } from "../card";

const BookCard = ({ title, imageUrl, time }) => (

  <div>
    <Card className="w-52 rounded-lg shadow-lg overflow-hidden">
  <img
    src={imageUrl}
    alt={title}
    className="w-full h-64 object-cover"
  />
</Card>
<div className="mt-2">
  <h3 className="text-sm font-bold truncate">{title}</h3>
  <p className="text-xs text-gray-400">{time}</p>
</div>
  </div>
);

export default BookCard;
