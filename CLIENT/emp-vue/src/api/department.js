import request from "@/utils/request"


export function add(department) {
    return request({
        url: "/department/save",
        method: "post",
        data: department
    })
}

export function remove(id) {
    return request({
        url: "/department/remove/" + id,
        method: "delete",
    })
}

export function update(department) {
    return request({
        url: "/department/update",
        method: "put",
        data: department
    })
}

export function getAll(departmentName) {
    return request({
        url: "/department/list",
        method: "get",
        params: {
            departmentName: departmentName
        }
    })
}
