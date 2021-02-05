<template>
  <div class="zbtiResult container">
    <h2 class="title">
      {{ zbtiResult.zbtiName }}
    </h2>
    <img src="@/assets/zbti_example.jpg" class="result" />
    <div class="title">
      <span>추천 챌린지 영역 #</span>
      {{ zbtiResult.zbtiType }}
    </div>
    <h3 class="description">
      {{ zbtiResult.zbtiDescription }}
    </h3>
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
      zbtiId: "A",
      zbtiResult: "",
    };
  },
  created() {
    //this.zbtiId = this.$route.params;

    axios({
      url: "/zbti/result",
      method: "GET",
      params: {
        zbtiId: this.zbtiId,
      },
    })
      .then((response) => {
        this.zbtiResult = response.data;
      })
      .catch((error) => {
        console.error(error);
      });
  },
};
</script>
