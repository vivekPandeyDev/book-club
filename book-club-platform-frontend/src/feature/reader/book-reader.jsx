import { Button } from "@/components/ui/button";
import { convertToUnderscore } from "@/lib/book";
import { bookPages, books } from "@/lib/db";
import { Maximize, Minus, Plus } from "lucide-react";
import { useEffect, useRef, useState } from "react";
import Markdown from "react-markdown";
import { useNavigate, useParams } from "react-router";
import rehypeRaw from "rehype-raw";
import remarkGfm from "remark-gfm";

const fontFamilies = [
  "serif",
  "sans-serif",
  "monospace",
  "Georgia",
  "Times New Roman",
];

export default function BookReader() {
  const { clubName, bookName } = useParams();
  const navigate = useNavigate();
  const [page, setPage] = useState(0);
  const [fontSize, setFontSize] = useState(18);
  const [fontFamily, setFontFamily] = useState("serif");
  const readerRef = useRef(null);
  const [currentPages, setCurrentPages] = useState([]);
  useEffect(() => {
    const book = books.find(
      (book) =>
        convertToUnderscore(book.name) === bookName &&
        convertToUnderscore(book.clubName) === clubName
    );
    console.log("book", book);
    if (book !== undefined) {
      const currentBookPages = bookPages.find((bp) => bp.bookId === book.id);
      if (currentBookPages !== undefined)
        setCurrentPages(currentBookPages.pages);
    } else {
      navigate("/");
    }
  }, []);

  const toggleFullScreen = () => {
    if (!document.fullscreenElement) {
      readerRef.current.requestFullscreen();
    } else {
      document.exitFullscreen();
    }
  };

  const nextPage = () =>
    setPage((p) => Math.min(p + 1, currentPages.length - 1));
  const prevPage = () => setPage((p) => Math.max(p - 1, 0));

  if (currentPages.length == 0) {
    return;
  }
  return (
    <div
      ref={readerRef}
      className="flex flex-col transition-all lg:max-w-7xl mx-auto"
    >
      <h1 className="text-2xl font-bold text-center p-2">
        Chapter: {currentPages[page].title}
      </h1>
      {/* Settings Bar */}
      <div className="flex justify-center gap-2 p-1 mb-2">
        <div className="flex items-center space-x-2">
          <Minus
            className="w-5 h-5 cursor-pointer"
            onClick={() => setFontSize((size) => Math.max(size - 2, 12))}
          />
          <span className="text-sm">Font Size: {fontSize}px</span>
          <Plus
            className="w-5 h-5 cursor-pointer"
            onClick={() => setFontSize((size) => Math.min(size + 2, 30))}
          />
        </div>

        <select
          value={fontFamily}
          onChange={(e) => setFontFamily(e.target.value)}
          className="px-2 py-1 border rounded text-sm"
        >
          {fontFamilies.map((font) => (
            <option key={font} value={font}>
              {font}
            </option>
          ))}
        </select>

        <Button onClick={toggleFullScreen} variant="ghost">
          <Maximize className="w-5 h-5" />
        </Button>
      </div>

      <div className="w-full p-6 overflow-x-hidden">
        <div
          className="overflow-y-auto h-[450px] dark:text-gray-200"
          style={{
            fontSize: `${fontSize}px`,
            fontFamily,
            lineHeight: "1.6",
          }}
        >
          <Markdown
            remarkPlugins={[remarkGfm]}
            rehypePlugins={[rehypeRaw]}
            components={{
              h1: ({ children }) => (
                <h1 className="text-2xl font-bold my-2">{children}</h1>
              ),
              h2: ({ children }) => (
                <h2 className="text-xl font-semibold my-2">{children}</h2>
              ),
              h3: ({ children }) => (
                <h3 className="text-lg font-medium my-2">{children}</h3>
              ),
              p: ({ children }) => <p className="text-base my-2">{children}</p>,
              ul: ({ children }) => (
                <ul className="list-disc list-inside my-2">{children}</ul>
              ),
              ol: ({ children }) => (
                <ol className="list-decimal list-inside my-2">{children}</ol>
              ),
              li: ({ children }) => <li className="ml-4">{children}</li>,
              a: ({ children, href }) => (
                <a
                  href={href}
                  className="text-blue-500 hover:underline"
                  target="_blank"
                  rel="noopener noreferrer"
                >
                  {children}
                </a>
              ),
              table: ({ children }) => (
                <table className="table-auto border-collapse border border-gray-300 w-full my-4">
                  {children}
                </table>
              ),
              thead: ({ children }) => (
                <thead className="bg-gray-100">{children}</thead>
              ),
              tbody: ({ children }) => <tbody>{children}</tbody>,
              tr: ({ children }) => <tr className="border-b">{children}</tr>,
              th: ({ children }) => (
                <th className="border px-4 py-2 font-semibold">{children}</th>
              ),
              td: ({ children }) => (
                <td className="border px-4 py-2">{children}</td>
              ),
            }}
          >
            {currentPages[page].content}
          </Markdown>
        </div>
        {/* Navigation */}
        <div className="flex justify-between mt-6">
          <Button onClick={prevPage} disabled={page === 0}>
            ← Previous
          </Button>
          <span className="text-lg">
            {page + 1} / {currentPages.length}
          </span>
          <Button
            onClick={nextPage}
            disabled={page === currentPages.length - 1}
          >
            Next →
          </Button>
        </div>
      </div>
    </div>
  );
}
