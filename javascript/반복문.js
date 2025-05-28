// 반복문 : 조건이 참인 동안 반복 수행하는 구문
// for : for(초기값;최종값;증감값), for ..in(키값 순회), for ..of(이터러블 객체 반복,)
// while, do ~ while

// const prompt = require("prompt-sync")();
// let num = Number(prompt("정수 입력: "));

// // 입력 받은 정수 범위의 합을 구하기
// let sum = 0; // 반드시 초기화 해줘야 함함
// // while (num) {
// //   sum += num;
// //   num--;
// // }

// let i = 1;
// for (; i <= num; ) {
//   sum += i;
//   i++;
// }
// console.log(sum);

// while문 사용 예 : 반복 횟수를 알 수 없는 경우 사용하면 유리
// 1 ~ 200 사이를 정상 입력으로 간주
// const prompt = require("prompt-sync")();
// let age = 0;
// while (true) {
//   age = Number(prompt("나이를 입력하세요: "));
//   if (age >= 0 && age <= 200) break;
//   console.log("나이를 잘 못 입력 하셨습니다.");
// }
// console.log(`당신의 나이는 ${age} 입니다.`);

// for문
const cars = ["테슬라 모델 y", "제네시스 G80", "그랜저", "싼타페", "코나"];
for (let i = 0; i < cars.length; i++) {
  // cars[i] += "0000";
  console.log(cars[i]);
}

// for ..of : 이터러블 순회 방식 (원본 데이터 유지)
for (let e of cars) {
  e += "0000";
  console.log(e);
}

for (let e of cars) {
  console.log(e);
}
