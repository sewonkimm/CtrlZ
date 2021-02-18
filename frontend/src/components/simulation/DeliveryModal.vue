<template>
  <div class="modalMask" @click.self="$emit('close')">
    <div class="modalWrapper">
      <div class="modalTitle">
        <span>Ctrl Z</span>
      </div>
      <div class="modalContent">
        <p>배달 음식 주문이 확인되었습니다.</p>
        <p>환경의 민족 챌린지에 참여하시겠습니까?</p>
      </div>
      <div class="modalButton">
        <Button class="uploadImageButton" style="margin-bottom:15px" @click="handleChallengeClick">
          챌린지 참여하기
        </Button>
      </div>
    </div>
  </div>
</template>

<script>
import "@/components/css/uploadModal.scss";

export default {
  name: "DeliveryModal",
  props: {},
  data() {
    return {
      postImage: "",
    };
  },
  methods: {
    uploadImage() {
      this.postImage = this.$refs.postImage.files[0];
      if (this.postImage !== null) {
        this.movePostUpload();
      }
      document.querySelector("#uploadImage").value = "";
    },
    movePostUpload() {
      this.handleChallengeClick();
    },
    // 해당 챌린지 상세보기로 이동
    handleChallengeClick() {
      // vuex 사용자 SET 필요
      this.$store.commit("SETUSERID", 14);

      this.$axios({
        url: "/challenge/status/",
        method: "POST",
        data: {
          challengeId: "7",
          userId: "14",
        },
      })
        .then(() => {
          // 챌린지 시작하면 페이지 새로고침
          this.$router.go(this.$router.currentRoute);
        })
        .catch((error) => {
          console.error(error);
        }); // 현재 사용자의 해당 챌린지 참여 현황 추가

      this.$router.push({
        name: "InProgressChallenge",
        params: {
          challengeId: "7",
        },
      });
    },
  },
};
</script>
