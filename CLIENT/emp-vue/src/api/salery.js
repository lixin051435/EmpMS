import request from "@/utils/request"


export function add(salery) {
    return request({
        url: "/salery/save",
        method: "post",
        data: salery
    })
}

export function remove(id) {
    return request({
        url: "/salery/remove/" + id,
        method: "delete",
    })
}

export function update(salery) {
    return request({
        url: "/salery/update",
        method: "put",
        data: salery
    })
}

export function getAll(query) {
    return request({
        url: "/salery/list",
        method: "get",
        params: query
    })
}
