let userName = "안유진"; // 변수이름은 카멜표기법(첫 소문자, 다음 대문자) 준수
let _score = 100;
let $value = 50;
let _1val = 1;

// 변수와 상수
// let : 변수 선언 시 사용, 블럭 스코프, ES6(?)
// const : 상수 선언 시, 재할당 불가
// var : 예전 사용 방식 (사용 금지), 호이스팅이 일어남.
// var tmp;
// console.log(tmp);
// var tmp = 100;

// 템플릿 문자열 : ES6에서 추가된 문법
// 자바스크립트는 문자열을 출력 할 때 "",'' 구분하지 않음, 문자와 문자열을을
const name = "장원영";
const age = 22;
const addr = "서울시 강남구 역삼동";
console.log(`이름 : ${name}, 나이 : ${age}, 주소 : ${addr}`);

// 숫자형 (Number) : 정수와 실수형을 포함해서 숫자형으로 취급, 근사치 계산법으로 계산되기 때문에 정확한 값 표현이 안됨
console.log(0.1 + 0.2);

// 논리형 : 참과 거짓으로 값을 표현
console.log(Boolean(10)); // true
console.log(Boolean(0)); // false
console.log(Boolean("")); // false
console.log(Boolean(" ")); // true
console.log(Boolean(0.0001)); // true
console.log(Boolean(undefined)); // false
console.log(Boolean(null)); // false
console.log(Boolean(NaN)); // false

// 배열 : 동일한 데이터 타입(동일하지 않아도 됨)이 연속된 공간에 저장되는 방식, 인덱스를 가지고 값을 찾는 방식,(O(1))
const arr1 = [
  "아이브",
  "안유진",
  23,
  true,
  [100, 99, 56],
  ["대전시", "수원시", "서울시"],
  { position: "리더" },
];
console.log(arr1);
// 인덱싱 : 인덱스로 원하는 값을 추출하는 것
console.log(arr1[1]);
console.log(arr1[5][0]);
console.log(arr1[5][0][1]);
console.log(arr1[6]["position"]);

// 객체 : 키와 값으로 구성
const person = {
  name: "민지",
  addr: {
    city: "서울시",
    gu: "강남구",
    dong: "역삼동",
  },
};
console.log(person);
console.log(person.name);
console.log(person.addr.city);

// 객체는 객체 타입 : 개체 타입이라는 주소를 참조하는 타입
const person1 = person; // 주소에 대한 참조 복사
person1.name = "하니";
person1.addr.city = "태국";
console.log(person.name);
console.log(person.addr.city);
