const Home = () => {
  return (
    <>
      <p>아이디 : {localStorage.getItem("userId")}</p>
      <p>이름 : {localStorage.getItem("name")}</p>
      <p>비밀번호 : {localStorage.getItem("password")}</p>
    </>
  );
};

export default Home;
