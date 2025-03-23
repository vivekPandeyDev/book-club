const AnnouncementBar = ({ message }) => (
  <>
    <div className="absolute top-0 left-0 w-screen bg-yellow-200 text-gray-800 py-2 z-50 overflow-hidden">
      <div className="whitespace-nowrap animate-marquee">
        <span className="inline-block px-4">{message}</span>
        <span className="inline-block px-4">{message}</span>
        <span className="inline-block px-4">{message}</span>
      </div>
    </div>
  </>
);

export default AnnouncementBar;
