<template>
    <h1>欢迎回来，{{$cookies.get("username")}}</h1>
</template>

<script>
    export default {
        name: "Home"
    }
</script>

<style scoped>

</style>