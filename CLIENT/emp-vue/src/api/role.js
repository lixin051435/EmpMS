import request from "@/utils/request"


export function add(role) {
    return request({
        url: "/role/save",
        method: "post",
        data: role
    })
}

export function remove(id) {
    return request({
        url: "/role/remove/" + id,
        method: "delete",
    })
}

export function update(role) {
    return request({
        url: "/role/update",
        method: "put",
        data: role
    })
}

export function getAll(query) {
    return request({
        url: "/role/list",
        method: "get",
        params: query
    })
}

export function addPermission(form) {
    return request({
        url: "/role/addpermission",
        method: "get",
        params: {
            roleId:form.roleId,
            permissionIds:form.permissionIds.join(",")
        }
    })
}