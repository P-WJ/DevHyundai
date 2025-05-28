import { useState } from "react";

const Say = () => {
  // 값을 읽는 변수, 값을 변경하는 함수(렌더링 발생)
  const [message, setMessage] = useState(""); // 상태관리,
  const onClickEnter = () => setMessage("안녕하세요");
  const onClickLeave = () => setMessage("안녕히가세요");
  const [color, setColor] = useState("black");

  return (
    <>
      {/* 실행아니라 등록이라 onClickEnter에 ()가없음 */}
      <button onClick={onClickEnter}>입장</button>
      <button onClick={onClickLeave}>퇴장</button>
      <h1 style={{ color }}>{message}</h1>
      <button style={{ color: "red" }} onClick={() => setColor("red")}>
        빨간색
      </button>
      <button style={{ color: "green" }} onClick={() => setColor("green")}>
        초록색
      </button>
      <button style={{ color: "blue" }} onClick={() => setColor("blue")}>
        파란색
      </button>
    </>
  );
};
export default Say;
