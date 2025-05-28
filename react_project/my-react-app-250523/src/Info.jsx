import { useState, useEffect } from "react";

const Info = () => {
  const [name, setName] = useState("");
  const [nickname, setNickname] = useState("");
  useEffect(() => {
    console.log("렌더링 완료");
    console.log(name, nickname);
  }, []); // 아무것도 없는 경우
  const onChangeName = (e) => {
    setName(e.target.value);
  };
  const onChangeNickname = (e) => {
    setNickname(e.target.value);
  };

  return (
    <>
      <input value={name} onChange={onChangeName} />
      <input value={nickname} onChange={onChangeNickname} />
      <p>이름 : {name}</p>
      <p>닉네임 : {nickname}</p>
    </>
  );
};

export default Info;
