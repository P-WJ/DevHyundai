import { useState, useCallback } from "react";
import NewsList from "../components/NewsList";
import Categories from "../components/Categories";

const Home = () => {
  const [category, setCategory] = useState("all");
  //const onSelect = useCallback(category => setCategory(category), []);
  const onSelect = (category) => setCategory(category);

  return (
    <div>
      <Categories category={category} onSelect={onSelect} />
      <NewsList category={category} />
    </div>
  );
};
export default Home;
