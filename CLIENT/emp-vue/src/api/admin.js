import request from "@/utils/request"


export function login(data) {
    return request({
        url: "/employee/login",
        method: "post",
        data: data
    })
}

export function changePass(data) {
    return request({
        url: "/employee/changePass",
        method: "post",
        data: data
    })
}
