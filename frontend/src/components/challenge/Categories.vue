<template>
  <div class="categories">
    <div class="category type1">
      <div class="text">
        <p class="type">
          일상
        </p>
        <p class="total">
          {{ challengeType1.length }}
        </p>
      </div>
    </div>
    <div class="category type2">
      <div class="text">
        <p class="type">
          음식
        </p>
        <p class="total">
          {{ challengeType2.length }}
        </p>
      </div>
    </div>
    <div class="category type3">
      <div class="text">
        <p class="type">
          패션
        </p>
        <p class="total">
          {{ challengeType3.length }}
        </p>
      </div>
    </div>
    <div class="category type4">
      <div class="text">
        <p class="type">
          활동
        </p>
        <p class="total">
          {{ challengeType4.length }}
        </p>
      </div>
    </div>
  </div>
</template>
<script>
import "@/components/css/challenge/categories.scss";
import axios from "axios";

axios.defaults.baseURL = "http://i4a202.p.ssafy.io:8888";
export default {
  name: "Categories",
  data: () => {
    return {
      challengeType1: [],
      challengeType2: [],
      challengeType3: [],
      challengeType4: [],
    };
  },
  created() {
    axios({
      url: "/challenge/type?challengeType=일상",
      method: "GET",
    }).then((res) => {
      this.challengeType1 = res.data;
    });
    axios({
      url: "/challenge/type?challengeType=음식",
      method: "GET",
    }).then((res) => {
      this.challengeType2 = res.data;
    });
    axios({
      url: "/challenge/type?challengeType=패션",
      method: "GET",
    }).then((res) => {
      this.challengeType3 = res.data;
    });
    axios({
      url: "/challenge/type?challengeType=활동",
      method: "GET",
    }).then((res) => {
      this.challengeType4 = res.data;
    });
  },
};
</script>
