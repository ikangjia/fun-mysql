import axios from "axios";

const Api = axios.create({
    baseURL: process.env.VUE_APP_API_BASE, // 域名配置，可添加变量配置文件定义
    headers: {
        'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8',
    },
    withCredentials: true, // 跨域请求时是否需要使用凭证
    timeout: 30000, // 请求超时时间
});