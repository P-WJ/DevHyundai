const Members = ({ name = "없음", age, addr, isAdult = true }) => {
  // 구조분해 또는 비구조화 할당
  // const { name, age, addr, isAdult } = props;
  return (
    <>
      <h3>이름 : {name}</h3>
      <p>나이 : {age}</p>
      <p>주소 : {addr}</p>
      <p>성인여부 : {isAdult ? "성인" : "미성년자"}</p>
    </>
  );
};

export default Members;
