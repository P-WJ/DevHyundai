<template>
  <div class="box">
    <h2>✅ ref() 방식 (반응형)</h2>
    <p>countRef: {{ countRef }}</p>
    <button @click="countRef++">+1</button>
    <button @click="countRef--">-1</button>

    <hr />

    <h2>🚫 일반 변수 방식 (비반응형)</h2>
    <p>countVar: {{ countVar }}</p>
    <button @click="incrementVar">+1</button>
    <button @click="decrementVar">-1</button>
  </div>
</template>

<script setup>
import { ref } from "vue";

// ✅ 반응형 변수 (화면 자동 갱신)
const countRef = ref(0);

// 🚫 일반 변수 (화면에 반영되지 않음)
let countVar = 0;

const incrementVar = () => {
  countVar++;
  console.log("일반 변수 증가:", countVar);
};

const decrementVar = () => {
  countVar--;
  console.log("일반 변수 감소:", countVar);
};
</script>

<style scoped>
.box {
  font-family: sans-serif;
  max-width: 400px;
  margin: 40px auto;
  padding: 1rem;
  border: 1px solid #ccc;
  border-radius: 8px;
}
button {
  margin-right: 8px;
  padding: 6px 12px;
}
hr {
  margin: 1.5rem 0;
}
</style>
