import axios from "axios"
import { Notification } from 'element-ui'
const baseURL = "http://127.0.0.1:9000/emp"

// 创建axios实例
const service = axios.create({
  baseURL: baseURL, // api 的 base_url
  timeout: 1200000 // 请求超时时间
})

service.interceptors.request.use(
  config => {
    config.headers['Content-Type'] = 'application/json'
    return config
  },
  error => {
    console.log(error)
    Promise.reject(error)
  }
)

// response 拦截器
service.interceptors.response.use(
  response => {
    const code = response.status
    if (code < 200 || code > 300) {
      Notification.error({
        title: response.message
      })
      return Promise.reject('error')
    } else {
      return response.data
    }
  }
)

export default service