import { useState, useMemo } from "react";

const getAverage = (numbers) => {
  console.log("평균 값 계산 중...");
  if (numbers.length === 0) return 0;
  const sum = numbers.reduce((a, b) => a + b);
  return sum / numbers.length;
};

const Average = () => {
  const [list, setList] = useState([]);
  const [number, setNumber] = useState("");
  const onChange = (e) => {
    setNumber(e.target.value);
  };

  const onInsert = () => {
    if (isNaN(parseInt(number))) return 0;
    const nextList = list.concat(parseInt(number)); // 불변의 원칙때문에 새로운 배열 생성
    setList(nextList);
    setNumber("");
  };

  const avg = useMemo(() => getAverage(list), [list]);

  return (
    <>
      <input value={number} onChange={onChange} />
      <button onClick={onInsert}>등록</button>
      <ul>
        {list.map((value, index) => (
          <li key={index}>{value}</li>
        ))}
      </ul>
      <p>평균 값 : {avg}</p>
    </>
  );
};

export default Average;
