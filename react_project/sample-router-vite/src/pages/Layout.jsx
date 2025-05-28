import { Outlet } from "react-router-dom";

const Layout = () => {
  return (
    <>
      <header style={{ background: "lightgray", padding: 16, fontSize: 24 }}>
        Header
      </header>
      <main style={{ flex: 1 }}>
        <Outlet />
      </main>
      <footer style={{ background: "lightgray", padding: 16, fontSize: 24 }}>
        여기는 풋터 입니다.
      </footer>
    </>
  );
};
export default Layout;
