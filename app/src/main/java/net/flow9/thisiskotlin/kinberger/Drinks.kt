package net.flow9.thisiskotlin.kinberger

class Drinks : Item() {

    val drinkList: MutableList<Menu> = mutableListOf(
        Menu("음료수",1, "soda", 2000, "콜라, 사이다, 환타"),
        Menu("음료수", 2,"juice", 2000, "포도주스, 오렌지주스, 사과주스"),
        Menu("음료수", 3,"coffee", 2000, "아메리카노, 라떼"),
    )

    override fun displayInfo() {
        println("[ Burgers MENU ]")
        for (menu in drinkList) {
            println("${menu.num}. ${menu.name.padEnd(18)} | W ${"%.1f".format(menu.price.toDouble() / 1000)} | ${menu.introduce}")
        }


        while (true){
            when (readLine()) {
                "1" -> {
                    println("Your select menu is ${drinkList[0].name}.")
                    Cart.addmenus(drinkList[0])
                    for (menuList in Cart.menus) {
                        println("${menuList.num} | ${menuList.name.padEnd(10)} | ${menuList.price} | ${menuList.introduce.padStart(10)}")
                    }
                    return
                }
                "2" -> {
                    println("Your select menu is ${drinkList[1].name}입니다")
                    Cart.addmenus(drinkList[1])
                    for (menuList in Cart.menus) {
                        println("${menuList.num} | ${menuList.name.padEnd(10)} | ${menuList.price} | ${menuList.introduce.padStart(10)}")
                    }
                    return
                }
                "3" -> {
                    println("Your select menu is ${drinkList[2].name}입니다")
                    Cart.addmenus(drinkList[2])

                    for (menuList in Cart.menus) {
                        println("${menuList.num} | ${menuList.name.padEnd(10)} | ${menuList.price} | ${menuList.introduce.padStart(10)}")
                    }
                    return
                }
                "0" -> {
                    return main()
                }
                else -> {
                    println("다시 선택해 주세요")

                }
            }
        }
    }

    override fun function() {
    }
}