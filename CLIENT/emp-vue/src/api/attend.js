import request from "@/utils/request"


export function add(attend) {
    return request({
        url: "/attend/save",
        method: "post",
        data: attend
    })
}

export function remove(id) {
    return request({
        url: "/attend/remove/" + id,
        method: "delete",
    })
}

export function update(attend) {
    return request({
        url: "/attend/update",
        method: "put",
        data: attend
    })
}

export function getAll(query) {
    return request({
        url: "/attend/list",
        method: "get",
        params: query
    })
}

export function shangban(no) {
    return request({
        url: "/attend/shangban?no=" + no,
        method: "get"
    })
}

export function xiaban(no) {
    return request({
        url: "/attend/xiaban?no=" + no,
        method: "get"
    })
}

export function canshangban(no) {
    return request({
        url: "/attend/canshangban?no=" + no,
        method: "get"
    })
}

export function canxiaban(no) {
    return request({
        url: "/attend/canxiaban?no=" + no,
        method: "get"
    })
}


