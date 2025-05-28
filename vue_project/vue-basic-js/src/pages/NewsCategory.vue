<template>
  <div class="nav">
    <button v-for="cate in categorys" @click="handleClick(cate)">
      {{ cate }}
    </button>
  </div>
</template>

<script setup>
const categorys = ["전체", "정치", "경제", "사회", "문화", "과학"];
const emit = defineEmits(["select"]);
const handleClick = (cate) => {
  console.log(cate);
  emit("select", cate);
};
</script>

<style scoped>
.nav {
  display: flex;
  background-color: beige;
  width: 800px;
  justify-content: center;
}
button {
  width: 100px;
  background-color: royalblue;
  color: white;
}
</style>
