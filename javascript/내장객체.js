// 문자열을 다루는 String 객체
// 특정 문자열 포함 여부 : includes(), indexOf
const email = "pwj1103@gmail.com";
if (!email.includes("@")) {
  console.log("올바른 이메일 형식이 아닙니다.");
}

// if (email.indexOf("@") == -1) {
//   console.log("올바른 이메일 형식이 아닙니다.");
// }

console.log(email.indexOf("@"));

/// 슬라이싱 : 문자열에 특정 부분 문자열 추출
const fruits = "Apple, Banana, Kiwi";
const subStr1 = fruits.slice(1, -1);
const subStr2 = fruits.substring(1, 5);
console.log(subStr1);
console.log(subStr2);

let str = "지구오락실, 이영지, 안유진, 미미, 이은지";
let n = str.replace("이은지", "나영석");
console.log(n);

// 문자열 결합
let text = "안녕하세요. ";
text += "오늘은 ";
text += "날씨가 아주 별로에요. ";
text += "집에 가고 싶어요~~";
console.log(text);

const text1 = "안녕하세요. ";
const text2 = text1.concat("오늘은 ");
const text3 = text2.concat("날씨가 아주 별로에요. ");
const text4 = text3.concat("집에 가고 싶어요~~");
console.log(text4);

// forEach() : ES5에서 도입, 배열의 각 요소에 대한 반복 수행 (단순 반복)
const numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]; // const -> 주소는 바뀔 수 없지만, 내용은 바뀔 수 있음 (객체)
numbers.forEach((num) => {
  console.log(num);
});

// map() : ES5에서 도입, 배열의 각 요소를 변형, 새로운 배열을 만듦
const doubled = numbers.map((num) => num * 2);
console.log(doubled);

// filter() : ES5에서 도입, 조건에 맞는 요소만 추출해서 새로운 배열 생성
const even = numbers.filter((num) => num % 2 === 0);
console.log(even);

// reduce() : ES6에서 도입, 합이나 곱을 구할 때 사용
const sum = numbers.reduce((a, b) => a + b, 0);
console.log(sum);
