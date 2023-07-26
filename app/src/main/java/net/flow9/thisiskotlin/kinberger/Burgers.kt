package net.flow9.thisiskotlin.kinberger

class Burgers : Item() {
    val burgerList: MutableList<Menu> = mutableListOf(
        Menu(1,"ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
        Menu(2,"SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
        Menu(3,"ShroomBurger", 9400, "베이컨, 몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거"),
        Menu(4,"Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
        Menu(5,"Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거")
    )

    override fun displayInfo() {
        for (menu in burgerList) {
            println("${menu.name.padEnd(18)} | ${menu.price} | ${menu.introduce}")
        }
    }

    override fun function() {
    }

}