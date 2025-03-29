import { BaseScreen, BookDetail, Home } from "@/screen/screen";
import { Route, Routes } from "react-router";
import BookReader from "./feature/reader/book-reader";

function App() {
  return (
    <>
      <Routes>
        <Route  element={<BaseScreen />}>
          <Route index element={<Home />} />
          <Route path="/detail/:name" element={<BookDetail/>}/>
          <Route path="/reader" element={<BookReader/>}/>
        </Route>
      </Routes>
    </>
  );
}

export default App;
