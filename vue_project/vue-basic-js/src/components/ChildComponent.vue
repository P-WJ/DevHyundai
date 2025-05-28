<template>
  <div>
    <h3>자식 컴포넌트</h3>
    <button @click="send">부모 컴포넌트에 메세지 보내기</button>
  </div>
</template>

<script setup>
const emit = defineEmits(["send-message"]);
const send = () => {
  emit("send-message", "안녕하세요! 자식입니다.");
};
</script>

<style scoped></style>
