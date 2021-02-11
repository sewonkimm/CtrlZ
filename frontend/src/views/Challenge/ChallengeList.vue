<template>
  <div class="challengeList">
    <Header title="전체 챌린지" />
    <Navigation />

    <Categories />
    <div class="challengeContainer">
      <div v-for="(challenge, index) in challenges" :key="index" class="challenge">
        <img :src="challenge.challengeImage" class="thumbnail" />

        <p class="category">
          <span>#{{ challenge.levelId }}</span>
          <span>#{{ challenge.challengeType }}</span>
        </p>
        <p class="challengeName">
          {{ challenge.challengeName }}
        </p>
        <p class="participants">
          {{ challenge.participants }}
          명 도전 중
        </p>
      </div>
    </div>
  </div>
</template>
<script>
import Header from "@/components/common/Header.vue";
import Navigation from "@/components/common/Navigation.vue";
import Categories from "@/components/challenge/Categories.vue";
import "@/components/css/challenge/index.scss";
import axios from "axios";

axios.defaults.baseURL = "http://i4a202.p.ssafy.io:8888";

export default {
  name: "ChallengeList",
  components: {
    Header,
    Navigation,
    Categories,
  },
  data: () => {
    return {
      challenges: [],
    };
  },
  created() {
    axios({
      url: "/challenge/all",
      method: "GET",
    }).then((res) => {
      this.challenges = res.data;
    });
  },
};
</script>
