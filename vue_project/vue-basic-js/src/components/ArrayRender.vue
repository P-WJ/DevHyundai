<template>
  <input v-model="inputText" @keydown.enter="addTodo" />
  <button @click="addTodo">추가</button>
  <ul>
    <li
      v-for="user in users"
      :key="user.id"
      @dblclick="() => removeTodo(user.id)"
    >
      {{ user.toDo }}
    </li>
  </ul>
</template>

<script setup>
import { ref, watch } from "vue";
const stored = localStorage.getItem("users");
const users = ref(
  stored
    ? JSON.parse(stored)
    : [
        {
          id: 1,
          toDo: "HTML 공부",
        },
        {
          id: 2,
          toDo: "CSS 복습",
        },
      ]
);

const inputText = ref("");
const nexId = ref(3);

const addTodo = () => {
  if (!inputText.value.trim()) return; // 입력내용 없음
  users.value.push({ id: nexId.value++, toDo: inputText.value });
  inputText.value = "";
};

const removeTodo = (id) => {
  users.value = users.value.filter((user) => user.id !== id);
};
watch(
  users,
  (newVal) => {
    localStorage.setItem("users", JSON.stringify(newVal));
  },
  { deep: true }
);
</script>
