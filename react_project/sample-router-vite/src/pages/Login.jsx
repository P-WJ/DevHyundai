import { useContext } from "react";
import { UserContext } from "../store/UserStore";
import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
const Login = () => {
  const { userId, password } = useContext(UserContext);
  const [inputId, setInputId] = useState("");
  const [inputPw, setInputPw] = useState("");
  const navigate = useNavigate();

  const Submit = () => {
    console.log("아이디 : ", inputId);
    console.log("비밀번호 : ", inputPw);
    console.log("저장된 아이디 : ", userId);
    console.log("저장된 비밀번호 : ", password);
    if (userId === inputId && password === inputPw) {
      navigate("/home");
      alert("로그인 성공");
    } else alert("로그인 실패");
  };
  return (
    <>
      <h3>로그인</h3>
      <input
        placeholder="아이디"
        value={inputId}
        onChange={(e) => setInputId(e.target.value)}
      />
      <br />
      <input
        type="password"
        placeholder="비밀번호"
        value={inputPw}
        onChange={(e) => setInputPw(e.target.value)}
      />
      <br />
      <button onClick={Submit}>로그인</button>
      <Link to="/SignUp">회원가입</Link>
    </>
  );
};

export default Login;
