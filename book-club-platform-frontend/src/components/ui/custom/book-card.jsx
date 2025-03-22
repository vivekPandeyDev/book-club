const BookCard = ({ title, imageUrl, time }) => (
<div className="w-52 rounded-lg shadow-lg overflow-hidden">
  <img
    src={imageUrl}
    alt={title}
    className="w-full h-72 object-contain"
    draggable={false}
    loading="lazy"
  />
  <div className="mt-2  px-2">
  <h3 className="text-sm font-bold line-clamp-2 min-h-[2.5rem]">{title}</h3>
    <p className="text-xs text-gray-400 mt-1">{time}</p>
  </div>
</div>
);

export default BookCard;
