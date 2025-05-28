import { useNavigate } from "react-router-dom";
import { UserContext } from "../store/UserStore";
import { useContext } from "react";

const SignUp = () => {
  const context = useContext(UserContext);
  const { userId, setUserId, password, setPassword, name, setName } = context;
  const navigate = useNavigate();

  const Register = () => {
    console.log(`아이디 : ${userId}`);
    console.log(`이름 : ${name}`);
    console.log(`비밀번호 : ${password}`);
    localStorage.setItem("userId", userId);
    localStorage.setItem("name", name);
    localStorage.setItem("password", password);
    alert("회원가입 성공");
    navigate("/");
  };
  return (
    <>
      <h3>회원가입</h3>
      <input
        placeholder="아이디"
        value={userId}
        onChange={(e) => setUserId(e.target.value)}
      />
      <br />
      <input
        placeholder="이름"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />
      <br />
      <input
        type="password"
        placeholder="비밀번호"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />
      <br />
      <button onClick={Register}>가입</button>
    </>
  );
};
export default SignUp;
