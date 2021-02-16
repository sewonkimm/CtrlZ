<template>
  <div class="profile">
    <Header title="마이페이지" />
    <Navigation />

    <ProfileBoard
      :user-name="user.userName"
      :user-image="user.userImage"
      :user-introduce="user.userIntroduce"
    />
    <ZScore :score="user.zscore" :percent="user.rank[1]" :rank="user.rank[0]" :zbti="user.zbti" />
    <ChallengeBoard :length="length" :challenges="userChallenges" />
    <ZFeed :data="feed" />
  </div>
</template>

<script>
import axios from "axios";
import Header from "@/components/common/Header.vue";
import Navigation from "@/components/common/Navigation.vue";
import ProfileBoard from "@/components/user/ProfileBoard.vue";
import ChallengeBoard from "@/components/user/ChallengeBoard.vue";
import ZScore from "@/components/user/ZScore.vue";
import ZFeed from "@/components/user/ZFeed.vue";
import "@/components/css/user/profile.scss";

axios.defaults.baseURL = "http://i4a202.p.ssafy.io:8888";

export default {
  name: "Profile",
  components: {
    Header,
    Navigation,
    ProfileBoard,
    ChallengeBoard,
    ZScore,
    ZFeed,
  },
  data: () => {
    return {
      user: "",
      userId: "",
      userScore: "",
      userRank: [],
      userChallenges: [],
      length: "",
      feed: [],
    };
  },
  created() {
    this.userId = this.$store.state.userInfo.userId;

    axios({
      url: "/user/profile",
      method: "GET",
      params: {
        userId: 3,
      },
    })
      .then((response) => {
        this.user = response.data;
      })
      .catch((error) => {
        console.error(error);
      }); // 해당 유저 데이터 조회

    axios({
      url: "/user/zscore",
      method: "GET",
      params: {
        userId: 3,
      },
    })
      .then((response) => {
        this.userScore = response.data;
      })
      .catch((error) => {
        console.error(error);
      }); // 해당 유저 점수 조회

    axios({
      url: "/user/rank",
      method: "GET",
      params: {
        userId: 3,
      },
    })
      .then((response) => {
        this.userRank = response.data;
      })
      .catch((error) => {
        console.error(error);
      }); // 해당 유저 상위 퍼센트, 등수 조회

    // zbitId에 맞게 zbti 이름 받아오기
    if (this.user.zbtiId === "A") {
      this.user = {
        ...this.user,
        zbti: "패션",
      };
    } else if (this.user.zbtiId === "B") {
      this.user = {
        ...this.user,
        zbti: "음식",
      };
    } else if (this.user.zbtiId === "C") {
      this.user = {
        ...this.user,
        zbti: "일상",
      };
    } else if (this.user.zbtiId === "D") {
      this.user = {
        ...this.user,
        zbti: "활동",
      };
    }

    this.getFeed();

    // // 진행중인 챌린지 조회
    // axios({
    //   url: "/challenge/status/user",
    //   method: "GET",
    //   params: {
    //     userId: 3,
    //   },
    // })
    //   .then((response) => {
    //     this.userChallenges = response.data;
    //     this.length = this.userChallenges.length;
    //   })
    //   .catch((error) => {
    //     console.error(error);
    //   });
  },
  methods: {
    // 유저가 작성한 게시글 조회
    getFeed() {
      this.$axios({
        url: "/post/find/user",
        method: "GET",
        params: {
          userId: this.user.userId,
        },
      })
        .then((response) => {
          this.feed = response.data;
        })
        .catch((error) => {
          console.error(error);
        });
    },
  },
};
</script>
