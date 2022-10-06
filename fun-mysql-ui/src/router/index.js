import {createRouter, createWebHashHistory} from "vue-router";

const routes = [
    {path: '/', redirect: 'login'},
    {path: '/login', component: () => import('../views/LoginView.vue')},
    {path: '/dataSource', component: () => import('../views/DataSourceView.vue')},
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router