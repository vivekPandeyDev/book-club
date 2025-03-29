import React, { useState } from "react";
import { Button } from "@/components/ui/button";
import BookGrid from "../book-grid/book-grid";

const filters = ["Daily", "Weekly", "Monthly", "All Time"];

export default function MostReadBooks({books}) {
  const [activeFilter, setActiveFilter] = useState("Daily");

  return (
    <>
      {/* Header */}
      <div className="flex justify-between items-center gap-2 border-b border-gray-800 p-2">
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
      <BookGrid books={books} />
    </>
  );
}
