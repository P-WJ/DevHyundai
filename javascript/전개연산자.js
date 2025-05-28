const arr1 = [1, 2, 3];
const arr2 = [4, 5, 6];
const arr3 = arr1.concat(arr2);

console.log(arr3);

const arr4 = [...arr1, ...arr2];
console.log(arr4);

const obj1 = { name: "장원영", age: 22 };
const obj2 = { addr: "서울시 강남구", position: "center" };
const obj3 = { ...obj1, ...obj2, name: "안유진" };

console.log(obj3);

// 가변함수 만들기
const sum = (...numbers) => {
  return numbers.reduce((a, b) => a + b, 0);
};

console.log(sum(1, 3, 5, 7, 9, 11, 45, 777, 8888, 9999));
