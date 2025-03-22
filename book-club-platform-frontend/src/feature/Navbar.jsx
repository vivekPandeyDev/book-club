import logo from "@/assets/logo/logo.png";
import { Button } from "@/components/ui/button";
import { BookA, HousePlus } from "lucide-react";
import { Link } from "react-router";

const Navbar = () => {
  return (
    <header>
      <div className="container mx-auto px-4 max-w-7xl flex items-center justify-between py-4">
        {/* Logo */}
        <div className="flex gap-3">
          <img
            src={logo}
            loading="lazy"
            draggable={false}
            className="w-14 h-14 sm:w-16 sm:h-16 sm:pt-0"
          ></img>
          <div>
            <h1 className="text-2xl font-bold">BOOKCLUB</h1>
            <span className="sm:text-sm text-xs">An Open Online Platform for Book</span>
          </div>
        </div>
        {/* Sign In Button */}
        <Button variant="default">
          <span>Sign In</span>
        </Button>
      </div>
      <nav className="border-b border-t border-2 py-4">
        <ul className="flex justify-center gap-2">
          <li className="pr-2 border-r border-primary hover:bg-accent">
            <Link to={"/"} className="text-sm">
              <HousePlus className="inline mr-1 text-chart-3" />
              <span className="text-xl  ">Home</span>
            </Link>
          </li>
          <li className="hover:bg-accent">
            <Link to={"/"} className="text-sm"> 
              <BookA className="inline mr-1 text-chart-2" />
              <span className="text-xl">Library</span>
            </Link>
          </li>
        </ul>
      </nav>
    </header>
  );

};

export default Navbar;
