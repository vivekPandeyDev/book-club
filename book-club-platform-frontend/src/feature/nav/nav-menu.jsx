import { NavigationMenu, NavigationMenuItem, NavigationMenuLink, NavigationMenuList } from "@/components/ui/navigation-menu";
import { BookOpen, LayoutGrid } from "lucide-react";
import { Link } from "react-router";
const NavMenu = () => {
  return (
    <nav className="border-b border-primary bg-background py-3 dark:bg-transparent">
      <NavigationMenu>
        <NavigationMenuList className="flex justify-center gap-6">
          <NavigationMenuItem>
            <NavigationMenuLink asChild>
              <Link
                to="/"
                className="flex items-center gap-2 px-4 py-2 text-lg font-medium hover:bg-accent rounded-md transition"
              >
                <LayoutGrid className="w-8 h-8 text-chart-5" />
                <span>Home</span>
              </Link>
            </NavigationMenuLink>
          </NavigationMenuItem>
          <NavigationMenuItem>
            <NavigationMenuLink asChild>
              <Link
                to="/library"
                className="flex items-center gap-2 px-4 py-2 text-lg font-medium hover:bg-accent rounded-md transition"
              >
                <BookOpen className="w-5 h-5 text-chart-2" />
                <span>Library</span>
              </Link>
            </NavigationMenuLink>
          </NavigationMenuItem>
        </NavigationMenuList>
      </NavigationMenu>
    </nav>
  );
};

export default NavMenu;
