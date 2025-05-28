// 함수란? 특정 작업을 반복하거나 재사용할 수 있도록 작성된 코드 블록
// 입력값을 받받을 수 있으며, 반환값을 줄 수 있음
// 함수 선언문 : 호이스팅 됨 (끌어올림), 함수는 호출을 해야 실행 됨

console.log(sum(100, 200));
console.log(sum(1.1, 2.2));
console.log(sum("아이브", "안유진"));

function sum(a, b) {
  return a + b;
}

// 함수 표현식 : 변수에 익명 또 기명 함수 할당, 호이스팅 되지 않음
const mul = function (a, b) {
  return a * b;
};

console.log(mul(5, 3));

// 화살표 함수 : 간결한 표현에 유리, 콜백함수에서 익명의 함수를 사용하는 경우 주로 사용
const div = (a, b) => a / b;
console.log(div(10, 4));

// 즉시 실행 함수 : 호출이 없어도 실행되는 함수
(function () {
  console.log("디바이스 정보 불러와서 셋업....");
})();

// 기본값 할당
function sum1(a, b, c = 300) {
  return a + b + c;
}
console.log(sum1(100, 200));

// Callback 함수 : 콜백함수는 비동기처리와 아주 밀접한 관계를 가짐
// 콜백함수란? 함수의 인자로 다른 함수를 전달하여, 그 함수가 설행될 때 호출되는 함수를 의미
// 사용자 이벤트 처리 : btn.addEventListener("click", 콜백함수{})
// 서버와 통신 시 사용 : axios기반의 비동기 통신(async / await)
// 파일 입출력 시 : 속도 차이가 발생하므로...
// 의도적으로 지연이 필요한 경우에도 사용

function birdSing() {
  console.log("🐦 새가 즐겁게 노래합니다!");
}

function catCry() {
  console.log("😿 고양이가 슬프게 웁니다.");
}

function dogDance() {
  console.log("🐶 강아지가 신나게 춤을 춥니다!");
}

function checkAnimalMood(mood) {
  if (mood === "happy") birdSing();
  else if (mood === "sad") catCry();
  else dogDance();
}

// 콜백 함수
function checkAnimalMoodCallback(mood, happAction, sadAction) {
  if (mood === "happy") happAction();
  else if (mood === "sad") sadAction();
}

checkAnimalMoodCallback("happy", dogDance, birdSing);

checkAnimalMoodCallback(
  "sad",
  () => {
    console.log("아무것도 안함");
  },
  birdSing
);

function buyToy(item, price, quantity, callback) {
  console.log(
    "🧒 아이가 '" +
      item +
      "' 장난감을 " +
      quantity +
      "개 골라서 엄마에게 가져갔습니다."
  );
  setTimeout(function () {
    console.log("💰 계산이 필요합니다.");
    let total = price * quantity;
    callback(total);
  }, 2000);
}

function pay(total) {
  console.log("엄마: '지불할 금액은 " + total + "원입니다.'");
  console.log("🧒 아이: '와! 고마워요, 엄마!' 🎉");
}

buyToy("공룡 장난감", 3000, 3, pay);

// 클로저 : 함수가 해당 함수의 스코프 외부에 있는 변수에 접근할 수 있는 메커니즘
function Counter() {
  let count = 0;
  return {
    increment: function () {
      count++;
      console.log(count);
    },
    decrement: function () {
      count--;
      console.log(count);
    },
  };
}

const myCnt = Counter();
myCnt.increment();
myCnt.increment();
myCnt.decrement();
