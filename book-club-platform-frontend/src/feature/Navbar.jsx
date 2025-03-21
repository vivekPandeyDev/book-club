import { Button } from "@/components/ui/button";
import logo from "@/assets/logo/logo.png";
import { Link } from "react-router";
import { House } from "lucide-react";


const Navbar = () => {


  return (
    <div>
      <div className="container mx-auto px-4 max-w-7xl flex items-center justify-between py-4">
        {/* Logo */}
        <div className="flex gap-3">
          <img
            src={logo}
            loading="lazy"
            width={58}
            height={58}
            draggable={false}
          ></img>
          <div>
            <h1 className="text-2xl font-bold">BOOKCLUB</h1>
            <span className="text-sm">An Open Online Platform for Book</span>
          </div>
        </div>
        {/* Sign In Button */}
        <Button variant="default">
          <span>Sign In</span>
        </Button>
      </div>
      <nav className="border-b border-t border-2 py-4">
        <ul className="flex justify-center gap-2">
          <li className="border-r">
            <Link to={"/"} className="text-xl">
              <House className="inline mr-1" />
              Home
            </Link>
          </li>
          <li className="border-r">
            <Link to={"/"} className="text-xl">
              <House className="inline mr-1" />
              Home
            </Link>
          </li>
        </ul>
      </nav>
    </div>
  );
};

export default Navbar;
