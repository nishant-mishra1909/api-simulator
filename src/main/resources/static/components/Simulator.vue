<template>
    <md-card class="demo-card">
        <md-card-header>
            <div class="md-title">{{ title }}</div>
            <div class="md-subhead">{{ subtitle }}</div>
        </md-card-header>
        <md-card-content>
            {{ content }}
        </md-card-content>
        <md-card-actions>
            <md-button class="md-raised md-primary">Action 1</md-button>
            <md-button class="md-raised md-accent">Action 2</md-button>
        </md-card-actions>
    </md-card>
</template>

<script>
  export default {
    name: 'Simulator',
    props: {
      title: String,
      subtitle: String,
      content: String
    }
  }
</script>

<style scoped>
.demo-card {
  max-width: 400px;
  margin: 0 auto;
  margin-top: 50px;
}
</style>