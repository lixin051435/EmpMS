import request from "@/utils/request"

export function getAll() {
    return request({
        url: "/permission/list",
        method: "get"
    })
}
