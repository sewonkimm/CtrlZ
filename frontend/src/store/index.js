import Vue from "vue";
import Vuex from "vuex";
import jwtDecode from "jwt-decode";
import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    splash: true,
    userInfo: {
      userId: "",
      userEmail: "",
      userName: "",
      userImage: "",
      userIntroduce: "",
      zscore: 0,
      rank: [],
      zbtiId: "",
    },
    zbtiId: "",
  },
  mutations: {
    ENDSPLASH: (state) => {
      state.splash = false;
    },
    LOGIN: (state, token) => {
      const user = jwtDecode(token).user;
      state.userInfo = user;
      if (state.userInfo.userImage === null) {
        state.userInfo.userImage = "http://i4a202.p.ssafy.io/img/no_profile.png";
      }
    },
    LOGOUT: (state) => {
      state.userInfo = {
        userId: "",
      };
    },
    GOOGLELOGIN: (state, userInfo) => {
      state.userInfo = userInfo;
    },
    SETZSCORE: (state, zscore) => {
      state.userInfo.zscore = zscore.zscore;
      state.userInfo.zbtiId = zscore.zbtiId;
    },
    SETRANK: (state, rank) => {
      state.userInfo.rank = rank;
    },
    SETZBTI: (state, zbtiId) => {
      state.zbtiId = zbtiId;
    },
  },
  plugins: [createPersistedState()],
});
