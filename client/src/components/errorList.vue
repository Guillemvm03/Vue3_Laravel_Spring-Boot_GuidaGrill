<template>
    <div class="error-list">
        <p class="error-message">Error: mensaje de error aquí</p>
    </div>
</template>

<script>
export default {

}
</script>

<style>
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