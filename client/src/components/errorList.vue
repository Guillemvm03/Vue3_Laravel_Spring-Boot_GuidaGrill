<template>
    <div class="error-list">
      <p v-for="(error, field) in fieldErrors" :key="field" class="error-message">{{ field }}: {{ error }}</p>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      fieldErrors: Object,
    },
  };
  </script>
  
  <style scoped>
  .error-list {
    display: flex;
    justify-content: center;
    align-items: center;
  }
  
  .error-message {
    color: red;
    font-family: 'Roboto', sans-serif;
    font-style: italic;
  }
  </style>