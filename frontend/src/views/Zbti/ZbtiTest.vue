<template>
  <div class="zbtiTest container">
    <h3 class="question">
      {{ zbtiTest[testId].testQuestion }}
    </h3>
    <div class="answer" @click="clickAnswer">
      <p class="answerText">
        {{ zbtiTest[testId].testAnswer1 }}
      </p>
    </div>
    <div class="answer" @click="clickAnswer">
      <p class="answerText">
        {{ zbtiTest[testId].testAnswer2 }}
      </p>
    </div>
    <div class="answer" @click="clickAnswer">
      <p class="answerText">
        {{ zbtiTest[testId].testAnswer3 }}
      </p>
    </div>
    <div class="answer" @click="clickAnswer">
      <p class="answerText">
        {{ zbtiTest[testId].testAnswer4 }}
      </p>
    </div>
    <progress class="testProgress" :value="value" max="100"></progress>
  </div>
</template>

<script>
import axios from "axios";
import "@/components/css/zbti/index.scss";

export default {
  name: "ZbtiTest",
  data: () => {
    return {
      zbtiTest: "",
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
      })
      .catch((error) => {
        console.error(error);
      });
  },
  methods: {
    clickAnswer() {
      console.log("ZBTI 테스트 답안 버튼 동작");

      if (this.testId + 1 === this.zbtiTest.length) {
        this.$router.push("/zbti/result");
        // this.$router.push({ name: "ZbtiResult", params: {zbtiId: "A"}});
      }

      this.testId = this.testId + 1;
    },
  },
};
</script>
