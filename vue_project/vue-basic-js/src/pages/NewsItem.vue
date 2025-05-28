<template>
  <p>{{ item.title }}</p>
  <p>{{ item.content }}</p>
  <p>{{ item.date }}</p>
</template>

<script setup>
const props = defineProps({
  item: Object,
});
</script>
