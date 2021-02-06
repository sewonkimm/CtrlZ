<template>
  <div class="zbtiTest">
    <div class="question" v-html="zbtiTest[testId].testQuestion"></div>
    <div class="answer" @click="handleAnswerClick(1)" v-html="zbtiTest[testId].testAnswer1"></div>
    <div class="answer" @click="handleAnswerClick(2)" v-html="zbtiTest[testId].testAnswer2"></div>
    <div class="answer" @click="handleAnswerClick(3)" v-html="zbtiTest[testId].testAnswer3"></div>
    <div class="answer" @click="handleAnswerClick(4)" v-html="zbtiTest[testId].testAnswer4"></div>
    <progress class="testProgress" :value="value" max="100"></progress>
  </div>
</template>

<script>
import axios from "axios";
import "@/components/css/zbti/zbtiTest.scss";

export default {
  name: "ZbtiTest",
  data: () => {
    return {
      zbtiTest: [],
      testId: 0,
      testResult: "",
    };
  },
  computed: {
    value() {
      return (100 / this.zbtiTest.length) * (this.testId + 1);
    },
  },
  created() {
    axios({
      url: "/zbti/",
      method: "GET",
    })
      .then((response) => {
        this.zbtiTest = response.data;

        for (let index = 0; index < this.zbtiTest.length; index++) {
          this.zbtiTest[index].testQuestion = this.zbtiTest[index].testQuestion
            .split("\n")
            .join("<br />");
          this.zbtiTest[index].testAnswer1 = this.zbtiTest[index].testAnswer1
            .split("\n")
            .join("<br />");
          this.zbtiTest[index].testAnswer2 = this.zbtiTest[index].testAnswer2
            .split("\n")
            .join("<br />");
          this.zbtiTest[index].testAnswer3 = this.zbtiTest[index].testAnswer3
            .split("\n")
            .join("<br />");
          this.zbtiTest[index].testAnswer4 = this.zbtiTest[index].testAnswer4
            .split("\n")
            .join("<br />");
        }
      })
      .catch((error) => {
        console.error(error);
      });
  },
  methods: {
    handleAnswerClick(answer) {
      console.log(`ZBTI 테스트 답안 버튼 동작 ${answer}`);

      if (this.testId + 1 === this.zbtiTest.length) {
        this.$router.push({
          name: "ZbtiResult",
          params: {
            zbtiId: "A",
          },
        });
      }

      this.testId = this.testId + 1;
    },
  },
};
</script>
