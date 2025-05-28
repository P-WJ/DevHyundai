import { useRef, useEffect, useState } from "react";

const RefCnt = () => {
  const cntRef = useRef(0);
  let cntTest = 0;
  const [flag, setFlag] = useState(false);

  const incrementCnt = () => {
    cntRef.current += 1;
    cntTest += 1;
    setFlag(!flag);
  };
  console.log("Ref Cnt : ", cntRef.current);
  console.log("let Cnt : ", cntTest);
  useEffect(() => {
    const interval = setInterval(incrementCnt, 1000);
    return () => clearInterval(interval);
  });
  return (
    <>
      <h3>Counter 연습</h3>
      <p>콘솔에서 값 확인</p>
      <button onClick={incrementCnt}>카운터 증가</button>
    </>
  );
};

export default RefCnt;
