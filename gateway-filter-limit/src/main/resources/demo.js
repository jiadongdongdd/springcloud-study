util.getMenuId = function (vm) {
    const menus1 = vm.$store.getters.userMenus
    if (menus1 && menus1.length) {
        return findMenuId(menus1)
    } else {
        return null
    }
}
// 1
function findMenuId (menus1) {
    const ids = [];
    for (let menu of menus1) {
        if (menu.children && menu.children.length) {
            ids = ids.concat(findMenuId(menu.children));
        } else {
            ids.push(menu.id + '-' + menu.title)
        }
    }
    console.log(ids)
    return ids
}