import { Button } from "@/components/ui/button";
import { getVisiblePages } from "@/lib/page";
import { ChevronLeft, ChevronRight } from "lucide-react";
const Pagination = ({ table }) => {
  const currentPage = table.getState().pagination.pageIndex + 1;
  const totalPages = table.getPageCount();

  return (
<div className="flex items-center justify-center gap-2 mt-4 p-2 shadow-sm">
  {/* Previous Button */}
  <Button
    variant="ghost"
    disabled={!table.getCanPreviousPage()}
    onClick={() => table.previousPage()}
    className="px-3 dark:text-white"
  >
    <ChevronLeft size={16} />
  </Button>

  {/* Page Numbers */}
  {getVisiblePages(currentPage, totalPages).map(({ key, value }) =>
    value === "..." ? (
      <span key={key} className="px-2 text-gray-500">...</span>
    ) : (
      <Button
        key={key}
        variant={currentPage === value ? "default" : "outline"}
        onClick={() => table.setPageIndex(value - 1)}
        className={`w-10  ${currentPage == value  ? "dark:bg-amber-300" : "dark:bg-amber-500"}`}
      >
        {value}
      </Button>
    )
  )}

  {/* Next Button */}
  <Button
    variant="ghost"
    disabled={!table.getCanNextPage()}
    onClick={() => table.nextPage()}
    className="px-3 dark:text-white"
  >
    <ChevronRight size={16} />
  </Button>
</div>

  );
};

export default Pagination;
