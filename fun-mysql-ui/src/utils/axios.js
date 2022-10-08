import axios from "axios";
import {ElMessage} from 'element-plus'

const service = axios.create({
    baseURL: '',
    headers: {
        'Content-Type': 'application/json;charset=utf-8',
    },
    timeout: 30000, // 请求超时时间
})
service.interceptors.request.use(
    config => {
        const token = window.sessionStorage.getItem('token') || ''
        return {
            ...config,
            headers: {
                'Token': token
            }
        }

    },
    error => {
        Promise.reject(error)
    }
)
service.interceptors.response.use(
    response => {
        if (response.data.code === -1) { // 未登录或 token 过期
            window.sessionStorage.setItem('token', '')
            return Promise.reject(response.data);
        } else if (response.data.code === 1) {  // 服务出错了
            ElMessage.error(response.data.msg)
            return Promise.reject(response.data);
        }else {  // 正常响应
            return response.data
        }
    },
    error => {
        ElMessage.error(error)
    }
)

// 常用方法封装
