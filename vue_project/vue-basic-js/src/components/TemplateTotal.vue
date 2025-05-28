<template>
  <div class="form-container">
    <h2>사용자 정보 입력</h2>

    <div class="form-group">
      <label>이름</label>
      <input v-model="member.name" type="text" />
    </div>

    <div class="form-group">
      <label>나이</label>
      <input v-model.number="member.age" type="number" />
    </div>

    <p>
      👉 현재 상태: <strong>{{ isAdult ? "성인" : "미성년자" }}</strong>
    </p>

    <button @click="handleSubmit">제출</button>
  </div>
</template>

<script setup>
import { reactive, computed, watch, onMounted } from "vue";

const member = reactive({
  name: "",
  age: 0,
});
// 불필요한 함수의 호출 방지, 리렌더링 시 함수 호출이 일어나지 않는 경우 이전 값 유지
const isAdult = computed(() => member.age > 19);

// 상태 변경이 일어나면, 리렌더링이 일어나고, 이후 동작을 정의의
watch(
  () => member.age,
  (newAge, oldAge) => {
    console.log(`나이가 ${oldAge} -> ${newAge}로 변경`);
  }
);
// 화면이 처음 그려질 때 동작
onMounted(() => {
  console.log("해당 컴포넌트가 마운트 되었습니다.");
});

const handleSubmit = () => {
  alert(`${member.name}님은 ${isAdult.value ? "성인" : "미성년자"}입니다.`);
};
</script>

<style scoped>
.form-container {
  width: 360px;
  margin: 40px auto;
  padding: 24px;
  border: 1px solid #ccc;
  border-radius: 8px;
  background-color: #f9f9f9;
  font-family: sans-serif;
}

h2 {
  font-size: 20px;
  margin-bottom: 16px;
}

.form-group {
  margin-bottom: 16px;
}

label {
  display: block;
  margin-bottom: 4px;
  font-weight: bold;
}

input {
  width: 100%;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
  font-size: 14px;
}

button {
  padding: 8px 16px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}
</style>
