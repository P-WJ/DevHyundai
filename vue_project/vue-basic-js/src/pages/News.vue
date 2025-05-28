<template>
  <NewsCategory @select="selectCategory" />
  <NewsList :items="filteredNews" />
</template>

<script setup>
import NewsCategory from "./NewsCategory.vue";
import NewsList from "./NewsList.vue";
import { ref, computed } from "vue";

const selected = ref("전체");
const allNews = [
  {
    title: "정치 뉴스 A",
    content: "정치 관련 내용입니다.",
    date: "2024-05-01",
    category: "정치",
  },
  {
    title: "경제 뉴스 A",
    content: "경제 관련 내용입니다.",
    date: "2024-05-02",
    category: "경제",
  },
  {
    title: "사회 뉴스 A",
    content: "사회 관련 내용입니다.",
    date: "2024-05-03",
    category: "사회",
  },
  {
    title: "문화 뉴스 A",
    content: "문화 관련 내용입니다.",
    date: "2024-05-04",
    category: "문화",
  },
  {
    title: "과학 뉴스 A",
    content: "과학 관련 내용입니다.",
    date: "2024-05-05",
    category: "과학",
  },
  {
    title: "정치 뉴스 B",
    content: "정치 뉴스 2건입니다.",
    date: "2024-05-06",
    category: "정치",
  },
  {
    title: "경제 뉴스 B",
    content: "경제 뉴스 2건입니다.",
    date: "2024-05-07",
    category: "경제",
  },
  {
    title: "사회 뉴스 B",
    content: "사회 뉴스 2건입니다.",
    date: "2024-05-08",
    category: "사회",
  },
  {
    title: "문화 뉴스 B",
    content: "문화 뉴스 2건입니다.",
    date: "2024-05-09",
    category: "문화",
  },
  {
    title: "과학 뉴스 B",
    content: "과학 뉴스 2건입니다.",
    date: "2024-05-10",
    category: "과학",
  },
  {
    title: "정치 뉴스 C",
    content: "정치 뉴스 3건입니다.",
    date: "2024-05-11",
    category: "정치",
  },
  {
    title: "경제 뉴스 C",
    content: "경제 뉴스 3건입니다.",
    date: "2024-05-12",
    category: "경제",
  },
  {
    title: "사회 뉴스 C",
    content: "사회 뉴스 3건입니다.",
    date: "2024-05-13",
    category: "사회",
  },
  {
    title: "문화 뉴스 C",
    content: "문화 뉴스 3건입니다.",
    date: "2024-05-14",
    category: "문화",
  },
  {
    title: "과학 뉴스 C",
    content: "과학 뉴스 3건입니다.",
    date: "2024-05-15",
    category: "과학",
  },
  {
    title: "정치 뉴스 D",
    content: "정치 뉴스 4건입니다.",
    date: "2024-05-16",
    category: "정치",
  },
  {
    title: "경제 뉴스 D",
    content: "경제 뉴스 4건입니다.",
    date: "2024-05-17",
    category: "경제",
  },
  {
    title: "사회 뉴스 D",
    content: "사회 뉴스 4건입니다.",
    date: "2024-05-18",
    category: "사회",
  },
  {
    title: "문화 뉴스 D",
    content: "문화 뉴스 4건입니다.",
    date: "2024-05-19",
    category: "문화",
  },
  {
    title: "과학 뉴스 D",
    content: "과학 뉴스 4건입니다.",
    date: "2024-05-20",
    category: "과학",
  },
];

const selectCategory = (cate) => {
  selected.value = cate;
};

const filteredNews = computed(() => {
  return selected.value === "전체"
    ? allNews
    : allNews.filter((news) => news.category === selected.value);
});
</script>
