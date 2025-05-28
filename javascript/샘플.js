// for (let i = 1; i <= 9; i++) {
//   console.log(`2 x ${i} = ${2 * i}`);
// }

// const num = Number(prompt("숫자 입력 : "));

// if (num >= 0) {
//   //console.log(`${num}은 양수 입니다.`)
//   document.write("<h1>양수 입니다.</h1>")
// } else {
//   //console.log(`${num}은 음수 입니다.`)
//   document.write("<h1>음수 입니다.</h1>")
// }

// const PI = 3.14;
// console.log(PI * 20);

// prompt 입력 받기 : 자바스크립트는 기본적으로 웹 기반의 언어이므로 콘솔 입력이 없음.
const name1 = prompt("이름을 입력 하세요.");
const greeting = document.getElementById("greeting");
if (name1) {
  greeting.innerText = `${name1}님. 환영합니다.`;
} else {
  greeting.innerText = "이름을 입력하지 않았습니다.";
}
