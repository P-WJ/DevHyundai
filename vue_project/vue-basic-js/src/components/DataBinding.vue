<template>
  <!-- 화면을 그려주는 부분 -->
  <h2>{{ refName }}</h2>
  <h2>{{ name }}</h2>
  <input :value="name" @input="updateName($event)" />
</template>

<script setup>
// 데이터 로직을 정의하는 부분
// ref : 원시 값을 감싸는 반응형 래퍼
import { ref } from "vue"; // 구조 분해, {} 해당 모듈에서 ref만 가져옴
const refName = ref("장원영"); // ref로 변경점을 감지하기 때문에 화면을 다시 그려줌
let name = "안유진"; // input에 입력해서 name이 변경되어도 랜더링이 일어나지 않음

const updateName = (e) => {
  name.value = e.target.value;
};
</script>
