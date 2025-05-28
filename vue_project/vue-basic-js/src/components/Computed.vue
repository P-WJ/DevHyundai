<template>
  <div style="padding: 2rem">
    <h2>computed 예제</h2>
    <input v-model.number="num0" placeholder="숫자0 입력" />
    <input v-model.number="num1" placeholder="숫자1 입력" />
    <input v-model.number="num2" placeholder="숫자2 입력" />
    <p>합계 : {{ sum }}</p>
  </div>
</template>

<script setup>
import { ref, computed } from "vue";
const num0 = ref(0);
const num1 = ref(0);
const num2 = ref(0);

// computed는 의존하는 값이 변경될 때만 재계산됨
const sum = computed(() => {
  console.log("sum 값을 재계산");
  return num1.value + num2.value;
});
</script>

<style scoped>
input {
  padding: 8px;
  margin-right: 8px;
  width: 120px;
}
p {
  margin-top: 1rem;
  font-size: 20px;
}
</style>
