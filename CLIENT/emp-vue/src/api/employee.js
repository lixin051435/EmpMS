import request from "@/utils/request"


export function add(employee) {
    return request({
        url: "/employee/save",
        method: "post",
        data: employee
    })
}

export function remove(id) {
    return request({
        url: "/employee/remove/" + id,
        method: "delete",
    })
}

export function update(employee) {
    return request({
        url: "/employee/update",
        method: "put",
        data: employee
    })
}

export function getAll(query) {
    return request({
        url: "/employee/list",
        method: "get",
        params: query
    })
}

export function getByNo(no) {
    return request({
        url: "/employee/get/"+ no,
        method: "get"
    })
}
