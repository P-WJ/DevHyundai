<template>
  <div class="card">
    <h2>이름: {{ user.name }}</h2>
    <p>직업: {{ user.job }}</p>
    <p>나이: {{ user.age }}</p>
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
  border-radius: 8px;
}
</style>
