import request from "@/utils/request"


export function remove(id) {
    return request({
        url: "/log/remove/" + id,
        method: "delete",
    })
}

export function getAll(query) {
    return request({
        url: "/log/list",
        method: "get",
        params: query
    })
}
