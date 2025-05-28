// 연산자 : 수학적인 계산을 위해 사용되거나, 참과 거짓을 판별할 때 사용
// 산술 연산자 : +, -, /, *, %, **
// 대입 연산자 : =, +=, -=, *=, /=, %=
// 증감 연산자 : x++, ++x, x--, --x
// 비교 연산자 : ==
// 논리 연산자
// 3항 연산자
// 비트 연산자
// 전개 연산자

let a = 10;
let b = 4;
console.log(a + b);
console.log(a - b);
console.log(a * b);
console.log(a / b); // 나눗셈
console.log(parseInt(a / b)); // 몫을 구하기 위해 정수로 형 변환
console.log(Math.floor(a / b)); // 소수점 이하를 날림
console.log(a % b);
console.log(a ** b); // 제곱 구하기

// 증감 연산자
console.log(++a); // 11
console.log(a); // 11
console.log(a++); // 11, 선 대입 후 증가
console.log(a); // 12

// 대입 연산자
let c = 10;
console.log((c += 2)); // c = c + 2
console.log((c -= 2)); // 10
console.log((c *= 2)); // 20
console.log((c /= 2)); // 10
console.log((c %= 2)); // 0

// 비교 연산자 : == (값이 같은지 판단), === (동등 비교 연산자, 값과 타입까지 비교)
console.log(100 == "100"); // true
console.log(100 === "100"); // false
console.log(100 != "100"); // false
console.log(100 !== "100"); // true

// 3항 연산자 : 참과 거짓을 구분하는 간단한 조건식인데, 연산자 취급
const age = 18;
console.log(`당신은 ${age > 19 ? "성인" : "미성년자"}`);

// 형 변환 : 정해진 타입을 다른 타입으로 변경하는 것
// 형 변환은 묵시적 형 변환과 명시적 형 변환

const rst = 100 + 3.14; // 묵시적 형 변환
console.log(rst);
console.log(10 + 10 + "10"); // 묵시적 형 변환

console.log(100 + Number("3.14")); // 명시적 형 변환

// 윤년 계산하기
// 1. 연도가 4로 나누어 떨어짐
// 2. 100으로 나누어 떨어지면 윤년이 아님
// 3. 400으로 나누어 떨어지면 윤년

let year = 2100;

if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
  console.log(`${year} 윤년o`);
} else {
  console.log(`${year} 윤년x`);
}

// 주민등록번호를 입력 : 010222-3164414
// 성별 :
// 나이 :
// 생년월일 :
// 문자열의 인덱싱과 슬라이싱 사용 : slice(시작인덱스, 종료인덱스)
// new Date(), getFullYear()
// 7번 인덱스가 1,2이면 19xx, 3,4이면 20xx 출생자, 1,3이면 남성, 2,4이면 여성

const prompt = require("prompt-sync")();
const crrYear = new Date().getFullYear(); // 운영체제로부터 현재 년도 가져옴
const jumin = prompt("주민등록번호 입력: ");

const year1 = parseInt(jumin.slice(0, 2));
const month = parseInt(jumin.slice(2, 4));
const day = parseInt(jumin.slice(4, 6));
const val = parseInt(jumin[7]);

// 생년월일
const birthday = `${year1}년 ${month}월 ${day}일`;
// 성별
const gender = val === 1 || val === 3 ? "남성" : "여성";
// 나이
const age1 =
  val === 1 || val === 2 ? crrYear - (1900 + year1) : crrYear - (2000 + year1);
// 출력
console.log("생년월일: " + birthday);
console.log("성별: " + gender);
console.log("나이: " + age1);
