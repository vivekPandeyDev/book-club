import { Button } from "@/components/ui/button";

import logo from "@/assets/logo/logo.png";

const Navbar = () => {
  return (
    <div>
      <div className="container mx-auto px-4 max-w-7xl flex items-center justify-between py-4">
        {/* Logo */}
        <div className="flex">
          <img src={logo} loading="lazy" width={58} height={58}></img>
          <div>
            <h1 className="text-2xl font-bold">BOOKCLUB</h1>
            <span className="text-sm">An Open Online Platform for Book</span>
          </div>
        </div>
        {/* Sign In Button */}
        <Button variant="default">Sign In</Button>
      </div>
      <nav className="border-b border-t border-2 py-4 text-center">hello</nav>
    </div>
  );
};

export default Navbar;
