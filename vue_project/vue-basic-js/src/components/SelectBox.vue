<!-- <template>
  <select v-model="fruit">
    <option disabled value="">과일을 선택하세요.</option>
    <option value="apple">사과</option>
    <option value="banana">바나나</option>
    <option value="mango">망고</option>
  </select>
  <p>선택된 과일: {{ fruit }}</p>
</template>

<script setup>
import { ref } from "vue";
const fruit = ref("");
</script> -->

<!-- <template>
  <label><input type="radio" value="apple" v-model="selected" /> 사과</label>
  <label><input type="radio" value="orange" v-model="selected" /> 오렌지</label>
  <label
    ><input type="radio" value="strawberry" v-model="selected" /> 딸기</label
  >

  <p>선택된 과일: {{ selected }}</p>
</template>

<script setup>
import { ref } from "vue";
const selected = ref("");
</script> -->

<!-- <template>
  <label><input type="checkbox" value="apple" v-model="selected" /> 사과</label>
  <label
    ><input type="checkbox" value="orange" v-model="selected" /> 오렌지</label
  >
  <label><input type="checkbox" value="berry" v-model="selected" /> 딸기</label>
  <p>선택된 과일: {{ selected.join(", ") }}</p>
</template>

<script setup>
import { ref } from "vue";
const selected = ref(["apple"]);
</script> -->

<template>
  <table>
    <tr v-for="user in users" :key="user.id" @click="selectUser(user)">
      <td>{{ user.id }}</td>
      <td>{{ user.name }}</td>
      <td>{{ user.age }}</td>
    </tr>
  </table>
</template>

<script setup>
import { ref, onMounted } from "vue";

const users = ref([]);

onMounted(() => {
  // onMounted는 컴포넌트가 마운트된 직후(초기 렌더링 완료 후)에 실행되는 Lifecycle Hook입니다.
  // 여기서는 컴포넌트가 화면에 표시되면 users 배열을 초기화합니다.
  users.value = [
    { id: 1, name: "John", age: 25 },
    { id: 2, name: "Jane", age: 30 },
  ];
});

function selectUser(user) {
  console.log(user);
}
</script>
