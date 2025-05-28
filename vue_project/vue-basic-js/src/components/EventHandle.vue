<template>
  <div>
    <button @click="() => (message = '안녕하세요.')">입장</button>
    <button @click="onClickLeave">퇴장</button>
    <h1 :style="{ color }">{{ message }}</h1>
    <button @click="() => setColor('red')">빨간색</button>
    <button @click="() => setColor('green')">초록색</button>
    <button @click="() => setColor('blue')">파란색</button>
  </div>
</template>

<script setup>
import { ref } from "vue";
const message = ref("");
const color = ref("black");

const onClickEnter = () => {
  message.value = "안녕하세요.";
};
const onClickLeave = () => {
  message.value = "안녕히가세요.";
};
const setColor = (val) => {
  color.value = val;
};
</script>
