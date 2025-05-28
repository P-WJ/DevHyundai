<template>
  <NewsItem v-for="news in items" :item="news" />
</template>

<script setup>
import NewsItem from "./NewsItem.vue";
const props = defineProps({
  items: Array,
});
</script>
