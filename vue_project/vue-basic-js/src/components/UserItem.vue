<template>
  <div class="card">
    <h2>{{ user.name }}</h2>
    <p>나이 : {{ user.age }}</p>
    <p>주소 : {{ user.address }}</p>
    <p>성인 여부 : {{ user.isAdult ? "성인" : "미성년자" }}</p>
  </div>
</template>

<script setup>
const props = defineProps({
  user: Object,
});
</script>

<style scoped>
.card {
  border: 1px solid #ccc;
  padding: 1rem;
  border-radius: 6px;
  width: 300px;
  background-color: bisque;
  margin: 1rem auto;
}
</style>
