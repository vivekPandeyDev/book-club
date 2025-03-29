import { getBookLink } from '@/lib/book'
import React from 'react'
import { NavLink } from 'react-router'

const BookGrid = ({books}) => {
  return (
    <div className="mt-4 grid grid-cols-2 md:grid-cols-3 2xl:grid-cols-5 lg:gap-6 overflow-x-none justify-center align-middle">
    {books.map((book,index) => (
      <NavLink
        key={book.id}
        className="w-36 sm:w-52 shrink-0 place-items-center 2xl:place-items-stretch mt-2"
        to={getBookLink(book.name,book.clubName)}
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
              {book.status}
            </span>
          )}
          <span className="absolute top-2 right-3 bg-yellow-400 text-black font-bold px-2 py-1 text-sm rounded-full">
            {book.rating}
          </span>
        </div>

        {/* Book Details */}
        <div className="w-full lg:ml-0 md:ml-10 ml-4">
        <h3 className="mt-2 text-blue-400 font-bold">#{index+1}</h3>
        <p className="text-md lg:text-lg truncate capitalize">
          {book.name}
        </p>
        </div>
      </NavLink>
    ))}
  </div>
  )
}

export default BookGrid