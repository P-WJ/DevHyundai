import { useState } from "react";

const EventInput = () => {
  const [message, setMessage] = useState("안녕하세요");

  const ChangeMsg = (event) => {
    setMessage(event.target.value);
  };
  return (
    <>
      {/* onChange - 이벤트 감지 */}
      {/* onChange={(e) => ChangeMsg(e)} 이벤트에서 e 생략가능  */}
      <input placeholder="인사말 입력" value={message} onChange={ChangeMsg} />
      <h2>입력받은 메세지 : {message}</h2>
    </>
  );
};

export default EventInput;
