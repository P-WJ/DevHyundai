<template>
  <div class="container">
    <h2>회원정보</h2>
    <userItem v-for="user in users" :key="user.name" :user="user" />
  </div>
</template>

<script setup>
import { reactive, onMounted } from "vue";
import UserItem from "../components/UserItem.vue";
const users = reactive([]);
const fetchedData = [
  { name: "장원영", age: 20, address: "서울 강남구", isAdult: true },
  { name: "장원영", age: 20, address: "서울 강남구", isAdult: true },
  { name: "장원영", age: 20, address: "서울 강남구", isAdult: true },
  { name: "장원영", age: 20, address: "서울 강남구", isAdult: true },
  { name: "장원영", age: 20, address: "서울 강남구", isAdult: true },
  { name: "장원영", age: 20, address: "서울 강남구", isAdult: true },
  { name: "장원영", age: 20, address: "서울 강남구", isAdult: true },
  { name: "장원영", age: 20, address: "서울 강남구", isAdult: true },
  { name: "장원영", age: 20, address: "서울 강남구", isAdult: true },
  { name: "장원영", age: 20, address: "서울 강남구", isAdult: true },
];
// 화면이 처음 나타나는 시점
onMounted(() => {
  // 서버로 데이터를 요청하고 데이터가 전달되면 아래의 동작 수행행
  users.push(...fetchedData);
});
</script>

<style scoped>
.container {
  width: 500px;
  margin: 40px auto;
  text-align: center;
  background-color: beige;
}
</style>
