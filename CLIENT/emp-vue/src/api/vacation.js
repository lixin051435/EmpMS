import request from "@/utils/request"


export function add(vacation) {
    return request({
        url: "/vacation/save",
        method: "post",
        data: vacation
    })
}

export function remove(id) {
    return request({
        url: "/vacation/remove/" + id,
        method: "delete",
    })
}

export function update(vacation) {
    return request({
        url: "/vacation/update",
        method: "put",
        data: vacation
    })
}

export function getAll(query) {
    return request({
        url: "/vacation/list",
        method: "get",
        params: query
    })
}

export function getMyAll(query) {
    return request({
        url: "/vacation/mylist",
        method: "get",
        params: query
    })
}

export function getProcessAll(query) {
    return request({
        url: "/vacation/processlist",
        method: "get",
        params: query
    })
}
