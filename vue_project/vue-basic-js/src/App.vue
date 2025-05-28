<script setup>
import DataBinding from "./components/DataBinding.vue";
import ConditionRender from "./components/ConditionRender.vue";
import Iterable from "./components/iterableArray.vue";
import ClassBinding from "./components/ClassBinding.vue";
import Reactive from "./components/Reactive.vue";
import Computed from "./components/Computed.vue";
import Watch from "./components/Watch.vue";
import TemplateTotal from "./components/TemplateTotal.vue";
import CardView from "./components/CardView.vue";
import UserCard from "./pages/UserCard.vue";
import ChildComponent from "./components/ChildComponent.vue";
import News from "./pages/News.vue";
import EventRef from "./components/EventRef.vue";
import Register from "./components/Register.vue";
import EventHandle from "./components/EventHandle.vue";
import SelectBox from "./components/SelectBox.vue";
import ArrayRender from "./components/ArrayRender.vue";
import MemberList from "./components/MemberList.vue";
</script>
<template>
  <!-- <DataBinding /> -->
  <!-- <ConditionRender /> -->
  <!-- <Iterable /> -->
  <!-- <ClassBinding /> -->
  <!-- <Reactive /> -->
  <!-- <Computed /> -->
  <!-- <Watch /> -->
  <!-- <TemplateTotal /> -->
  <!-- <CardView :user="member" /> -->
  <!-- <UserCard /> -->
  <!-- <News />-->
  <!-- <EventRef /> -->
  <!-- <Register /> -->
  <!-- <EventHandle /> -->
  <!-- <SelectBox /> -->
  <!-- <ArrayRender /> -->
  <MemberList />
</template>

<style scoped>
h1 {
  font-size: 24px;
  color: royalblue;
}
input {
  padding: 8px;
  font-size: 18px;
  margin-top: 10px;
}
</style>
