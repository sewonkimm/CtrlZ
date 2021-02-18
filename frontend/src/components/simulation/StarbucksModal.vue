<template>
  <div class="modalMask" @click.self="$emit('close')">
    <div class="modalWrapper">
      <div class="modalTitle">
        <span>Ctrl Z</span>
      </div>
      <div class="modalContent">
        <p>결제 내역 : 스타벅스 강남R점</p>
        <p>텀블러 사용 내역을 인증해주세요.</p>
      </div>
      <div class="modalButton">
        <label for="uploadImage" class="uploadImageButton">
          인증샷 올리기
        </label>
        <input
          id="uploadImage"
          ref="postImage"
          type="file"
          accept="image/*"
          name="uploadImage"
          class="uploadImage"
          @change="uploadImage"
        />
      </div>
    </div>
  </div>
</template>

<script>
import "@/components/css/uploadModal.scss";

export default {
  name: "StarbucksModal",
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
      this.$store.commit("SETUSERID", "8");

      this.$router.push({
        name: "PostUpload",
        params: {
          challengeId: "9",
          missionId: "3",
          postImage: this.postImage,
          missionTitle: "우리 헤어지자...",
        },
      });
    },
  },
};
</script>
