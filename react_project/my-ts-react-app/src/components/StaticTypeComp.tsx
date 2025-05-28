import React from "react";

const StaticTypeComp: React.FC = () => {
  const name: string = "안유진";
  const age: number = 21;
  const isStudent: boolean = false;

  return (
    <div>
      <h3>정적 타입 지정 예시</h3>
      <p>Name: {name}</p>
      <p>Age: {age}</p>
      <p>Is Student: {isStudent ? "Yes" : "No"}</p>
    </div>
  );
};

export default StaticTypeComp;
