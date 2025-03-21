import { Route, Routes } from "react-router";
import {BaseScreen,Home} from "@/screen/screen";

function App() {
  return (
    <>
      <Routes>
        <Route  element={<BaseScreen />}>
          <Route index element={<Home />} />
        </Route>
      </Routes>
    </>
  );
}

export default App;
