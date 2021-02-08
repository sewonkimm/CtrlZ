<template>
  <div class="challengeDetail">
    <Header title="챌린지 상세보기" />
    <Challenge category="#패션" title="에코패셔니스타" participants="7,234명 참여 중" />
    <h4 class="description">
      패션 분야의 환경 보호를 실천하고, 모두가 인정하는 에코 패셔니스타가 되어보세요!
    </h4>
    <button class="startButton" @click="startChallenge">
      (participants + 1)번째 참여자 되기
    </button>
    <ChallengeFeed />
  </div>
</template>

<script>
import Header from "@/components/common/Header.vue";
import Challenge from "@/components/challenge/Challenge.vue";
import ChallengeFeed from "@/components/challenge/ChallengeFeed.vue";
import "@/components/css/challenge/challengeDetail.scss";

export default {
  name: "ChallengeDetail",
  components: {
    Header,
    Challenge,
    ChallengeFeed,
  },
  methods: {
    startChallenge() {
      console.log("버튼 동작");
    },
  },
};
</script>
