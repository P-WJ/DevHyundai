// 자바스크립트는 원시 타입을 제외한 모든 값이 객체
// 객체 리터럴은 중괄호 {} 로 생성, 속성과 값의 쌍으로 구성

const person = {
  title: "지구오락실",
  name: "안유진",
  age: 23,
  job: "IVE",
};

console.log(person);

const member = {
  id: "pwj1103",
  pwd: "1234",
  addr: {
    home: "대구광역시 수성구",
    company: "서울시 금천구 가산동",
  },
  name: "박우진",
  func1: () => {
    console.log("함수 호출 입니다.");
  },
};

member.func1();
console.log(member);

const members = [
  { id: "ive1", pwd: "1234", addr: "서울시 강남구", name: "안유진" },
  { id: "ive2", pwd: "1234", addr: "서울시 강남구", name: "장원영" },
  { id: "ive3", pwd: "1234", addr: "서울시 강남구", name: "가을" },
  { id: "ive4", pwd: "1234", addr: "서울시 강남구", name: "레이" },
  { id: "ive5", pwd: "1234", addr: "서울시 강남구", name: "리즈" },
  { id: "aespa1", pwd: "1234", addr: "서울시 강남구", name: "카리나" },
  { id: "aespa2", pwd: "1234", addr: "서울시 강남구", name: "윈터" },
  { id: "aespa3", pwd: "1234", addr: "서울시 강남구", name: "지젤" },
];
members.map((member) => {
  console.log("아이디: " + member.id);
  console.log("비밀번호: " + member.pwd);
  console.log("주소: " + member.addr);
  console.log("이름: " + member.name);
  console.log("-----------------------------");
});
