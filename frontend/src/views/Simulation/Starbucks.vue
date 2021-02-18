<template>
  <div>
    <img src="@/assets/background_example.png" class="testBackground" />
    <StarbucksModal @close="isModalViewed = false" />
  </div>
</template>

<script>
import StarbucksModal from "@/components/simulation/StarbucksModal.vue";

export default {
  name: "Starbucks",
  components: {
    StarbucksModal,
  },
  data: () => {
    return {
      isModalViewed: true,
    };
  },
};
</script>
