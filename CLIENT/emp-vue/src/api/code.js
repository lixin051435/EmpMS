import request from "@/utils/request"


export function getcode() {
    return request({
        url: "/code",
        method: "get"
    })
}
