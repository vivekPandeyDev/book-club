import { BaseScreen, BookDetail, Home } from "@/screen/screen";
import { Route, Routes } from "react-router";

function App() {
  return (
    <>
      <Routes>
        <Route  element={<BaseScreen />}>
          <Route index element={<Home />} />
          <Route path="/detail/:name" element={<BookDetail/>}/>
        </Route>
      </Routes>
    </>
  );
}

export default App;
