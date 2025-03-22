import { Route, Routes } from "react-router";
import {BaseScreen,Home,BookDetail} from "@/screen/screen";

function App() {
  return (
    <>
      <Routes>
        <Route  element={<BaseScreen />}>
          <Route index element={<Home />} />
          <Route path="/detail" element={<BookDetail/>}/>
        </Route>
      </Routes>
    </>
  );
}

export default App;
