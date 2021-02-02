import VueRouter from "vue-router";
import Vue from "vue";
import routes from "./router";
import store from "./store";
import App from "./App.vue";

Vue.config.productionTip = false;
Vue.use(VueRouter);

const router = new VueRouter({
  routes,
});

new Vue({
  router,
  store,
  // eslint-disable-next-line id-length, comma-dangle
  render: (h) => h(App),
}).$mount("#app");
