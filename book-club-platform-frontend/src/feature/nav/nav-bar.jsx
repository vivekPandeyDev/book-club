import NavHeader from "./nav-header";
import NavMenu from "./nav-menu";

const Navbar = () => {
  return (
    <header className="pt-4">
      <div className="container mx-auto px-4 max-w-7xl flex items-center justify-between py-4">
        <NavHeader />
      </div>
      <div className="flex justify-center items-center">
        <NavMenu />
      </div>
    </header>
  );
};

export default Navbar;
