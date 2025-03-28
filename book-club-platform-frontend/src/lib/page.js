export const getVisiblePages = (currentPage,totalPages) => {
    if (totalPages <= 4) {
      // If total pages are 4 or less, show all pages
      return Array.from({ length: totalPages }, (_, i) => ({
        key: i + 1,
        value: i + 1,
      }));
    }
  
    if (currentPage <= 2) {
      return [
        { key: 1, value: 1 },
        { key: 2, value: 2 },
        { key: 3, value: 3 },
        { key: 4, value: 4 },
        { key: "dots-1", value: "..." },
        { key: totalPages, value: totalPages },
      ];
    }
  
    if (currentPage >= totalPages - 1) {
      return [
        { key: 1, value: 1 },
        { key: "dots-2", value: "..." },
        { key: totalPages - 3, value: totalPages - 3 },
        { key: totalPages - 2, value: totalPages - 2 },
        { key: totalPages - 1, value: totalPages - 1 },
        { key: totalPages, value: totalPages },
      ];
    }
  
    return [
      { key: 1, value: 1 },
      { key: "dots-3", value: "..." },
      { key: currentPage - 1, value: currentPage - 1 },
      { key: currentPage, value: currentPage },
      { key: currentPage + 1, value: currentPage + 1 },
      { key: "dots-4", value: "..." },
      { key: totalPages, value: totalPages },
    ];
  };