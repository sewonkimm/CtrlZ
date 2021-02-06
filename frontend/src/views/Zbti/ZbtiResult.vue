<template>
  <div class="zbti">
    <div class="title">
      <p>당신은</p>
      {{ zbtiResult.zbtiName }}
    </div>
    <img src="@/assets/zbti_example.jpg" class="result" />
    <div class="title">
      <span>추천 챌린지 영역 #</span>
      {{ zbtiResult.zbtiType }}
    </div>
    <div class="description" v-html="zbtiResult.zbtiDescription"></div>
    <router-link to="/" tag="button" class="startButton">
      챌린지 하러 가기
    </router-link>
  </div>
</template>

<script>
import axios from "axios";
import "@/components/css/zbti/index.scss";

export default {
  name: "ZbtiResult",
  data: () => {
    return {
      zbtiId: "",
      zbtiResult: "",
    };
  },
  created() {
    this.zbtiId = this.$route.params.zbtiId;

    axios({
      url: "/zbti/result",
      method: "GET",
      params: {
        zbtiId: this.zbtiId,
      },
    })
      .then((response) => {
        this.zbtiResult = response.data;

        this.zbtiResult.zbtiDescription = this.zbtiResult.zbtiDescription
          .split("\n")
          .join("<br />");
        this.zbtiResult.zbtiDescription = this.zbtiResult.zbtiDescription.split("\b").join("<b>");
        this.zbtiResult.zbtiDescription = this.zbtiResult.zbtiDescription.split("/b").join("</b>");
      })
      .catch((error) => {
        console.error(error);
      });
  },
};
</script>
