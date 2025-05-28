<template>
  <div class="container">
    <div class="input-box">
      <input v-model="user.email" placeholder="email" type="email" />
    </div>
    <div class="input-box">
      <input v-model="user.pwd" placeholder="password" type="password" />
    </div>
    <div class="input-box">
      <input v-model="user.name" placeholder="name" type="text" />
    </div>
    <button @click="handleSubmit">제출</button>
  </div>
</template>

<script setup>
import { reactive } from "vue";
import axios from "axios";
const user = reactive({
  email: "",
  pwd: "",
  name: "",
});

const handleSubmit = async () => {
  try {
    const payload = {
      email: user.email,
      pwd: user.pwd,
      name: user.name,
    };
    const res = await axios.post(
      "http://222.117.237.119:8111/auth/signup",
      payload
    );
    if (res.data) {
      alert("회원 가입 성공");
    } else {
      alert("회원 가입 실패");
    }
  } catch (err) {
    console.error(err);
    alert("가입 실패! 서버 오류 발생");
  }
};
</script>

<style scoped>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: rgb(226, 244, 255);
  display: flex;
  justify-content: center;
  align-items: center;
  height: calc(100vh - 20px);
}
.container {
  background-color: white;
  width: 400px;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  padding: 20px;
}
h1 {
  text-align: center;
  margin-bottom: 20px;
}

.input-box {
  position: relative;
  margin-bottom: 24px;
}
.input-box input {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 5px;
  outline: none;
  transition: border-color 0.3s ease;
}
.input-box input:focus {
  border-color: #007bff;
}
.input-box p {
  position: absolute;
  bottom: -20px;
  right: 0;
  color: red;
  font-size: 0.875em;
  margin: 0;
}
.input-box p.valid {
  color: #28a745;
}
.reg-req-btn {
  width: 100%;
  padding: 12px;
  font-size: 1em;
  color: #fff;
  background-color: #6c757d;
  border: none;
  border-radius: 5px;
  /* cursor: not-allowed; */
  transition: background-color 0.3s ease;
}
.reg-req-btn.enabled {
  background-color: #007bff;
  cursor: pointer;
}
.reg-req-btn:active {
  position: relative;
  top: 2px;
  left: 2px;
}
</style>
