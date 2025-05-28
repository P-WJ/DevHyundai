<template>
  <ul>
    <li v-for="item in items" :key="item.id">{{ item.name }}</li>
  </ul>
</template>

<script setup>
const items = [
  {
    id: 1,
    name: "Vue",
  },
  {
    id: 2,
    name: "React",
  },
  {
    id: 3,
    name: "Swift",
  },
];
</script>
