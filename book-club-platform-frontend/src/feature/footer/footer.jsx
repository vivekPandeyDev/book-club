import React from "react";

const Footer = () => {
  return (
    <footer class="bg-gray-800 text-white py-6">
      <div class="container mx-auto text-center space-y-4">
        <p class="text-gray-400">
          BookHive is an open online platform for book lovers where users can
          read and share book recommendations, reviews, and discussions.
        </p>

        <div class="flex justify-center items-center space-x-2">
          <img
            src="/logo.svg"
            loading="lazy"
            draggable={false}
            alt="BookHive Logo"
            class="h-10"
          />
          <h2 class="text-xl font-bold">BOOKHIVE</h2>
        </div>

        <div class="flex justify-center space-x-6 text-gray-300">
          <a href="#" class="hover:text-gray-100">
            Terms of Service
          </a>
          <span>|</span>
          <a href="#" class="hover:text-gray-100">
            Contact Us
          </a>
          <span>|</span>
          <a href="#" class="hover:text-gray-100">
            Privacy Policy
          </a>
        </div>

        <p class="text-teal-400">
          &copy; 2024 BOOKHIVE Inc. All rights reserved
        </p>
      </div>
    </footer>
  );
};

export default Footer;
