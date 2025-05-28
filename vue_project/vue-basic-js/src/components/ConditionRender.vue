<template>
  <h1 v-if="isLogin">환영합니다. {{ name }}님.</h1>
  <h1 v-else>로그인 후 사용하세요.</h1>
</template>

<script setup>
const isLogin = false;
const name = "곰돌이사육사";
</script>
