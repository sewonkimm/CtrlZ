<template>
  <div>
    <img src="@/assets/background_example.png" class="testBackground" />
    <DeliveryModal @close="isModalViewed = false" />
  </div>
</template>

<script>
import DeliveryModal from "@/components/simulation/DeliveryModal.vue";

export default {
  name: "Delivery",
  components: {
    DeliveryModal,
  },
  data: () => {
    return {
      isModalViewed: true,
    };
  },
};
</script>
