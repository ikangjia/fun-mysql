import { createApp } from 'vue'
import './style.css'
import App from './App.vue'

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

import Router from "./router/index.js";

const app = createApp(App)
app.use(ElementPlus, {size: 'small', zIndex: 3000})

app.use(Router)
app.mount('#app')
