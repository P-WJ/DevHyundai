<template>
  <ul>
    <li v-for="user in users" key="user.id">
      <p>이름: {{ user.name }}</p>
      <p>이메일: {{ user.email }}</p>
      <p>가입일: {{ user.regDate }}</p>

      <br />
    </li>
  </ul>
</template>

<script setup>
import { ref, onMounted } from "vue";
import axios from "axios";

const users = ref([]);

const getUserList = async () => {
  try {
    const res = await axios.get("http://222.117.237.119:8111/users/list");
    users.value = res.data;
  } catch (err) {
    console.error(err);
    alert("실패");
  }
};

onMounted(() => {
  getUserList();
});
</script>

<style scoped>
li {
  background-color: bisque;
  list-style: none;
}
</style>
