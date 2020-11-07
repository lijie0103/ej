<template>
    <div>
        <el-link type="primary" @click='backHandler'>返回</el-link>
        <p>产品名称：{{this.$route.params.id.name}}</p>
        <p>产品编号：{{this.$route.params.id.id}}</p>
        <p>产品序号：{{this.$route.params.id.num}}</p>
        <p>产品父栏目: {{this.$route.params.id.parentId}}</p>
    </div>
</template>
<script>
export default {
    data(){
        return {
            
        }
    },
    created() {
        // console.log(this.$route.params.id);
    },
    methods: {
        //返回上一级
        backHandler(){
            this.$router.push({name:'product'})
        }
    },
}
</script>