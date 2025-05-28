// let productList = [
//   {
//     name: "레쓰비",
//     price: 700,
//   },
//   {
//     name: "티오피",
//     price: 1000,
//   },
//   {
//     name: "비타500",
//     price: 800,
//   },
//   {
//     name: "포카리스웨트",
//     price: 1000,
//   },
//   {
//     name: "파워에이드",
//     price: 1200,
//   },
// ];

// const prompt = require("prompt-sync")();
// const inputCoin = Number(prompt("금액 입력: "));
// // 구매가능한 제품 목록 출력
// // 전통적인 for문 순회
// for (let i = 0; i < productList.length; i++) {
//   if (productList[i].price <= inputCoin) {
//     console.log(productList[i].name);
//   }
// }
// // for ..of
// for (const e of productList) {
//   if (e.price <= inputCoin) {
//     console.log(e.name);
//   }
// }
// // filter를 사용하는 방법
// productList
//   .filter((e) => e.price <= inputCoin)
//   .forEach((e) => console.log(e.name));

// Math.random() : 0 ~ 1 미만의 임의의 실수값이 반환됨
// Math. random() * 45 + 1
// 두개의 주사위를 굴려 같은 값이 나오면 무인도 탈출하기

const rand1 = parseInt(Math.random() * 6) + 1;
const rand2 = parseInt(Math.random() * 6) + 1;
console.log(`주사위 1번 : ${rand1} 주사위 2번 : ${rand2}`);
if (rand1 === rand2) {
  console.log("무인도 탈출");
} else {
  console.log("무인도 탈출x");
}

// for ..in : 객체의 키값 기준 순회
const person = { name: "안유진", age: 23, isAdult: true };
for (const key in person) {
  console.log(person[key]);
}
