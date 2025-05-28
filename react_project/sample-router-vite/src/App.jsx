import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import NewsPage from "./pages/NewsPage";
import UserStore from "./store/UserStore";
import SignUp from "./pages/SignUp";
import Login from "./pages/Login";
import Home from "./pages/ExHome";
const App = () => {
  return (
    <UserStore>
      <Router>
        <Routes>
          {/* <Route path="/" element={<NewsPage />} />
          <Route path="/:category" element={<NewsPage />} /> */}
          <Route path="/" element={<Login />} />
          <Route path="/SignUp" element={<SignUp />} />
          <Route path="/Home" element={<Home />}></Route>
        </Routes>
      </Router>
    </UserStore>
  );
};
export default App;
