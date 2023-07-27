package net.flow9.thisiskotlin.kinberger

class Drinks : Item() {

    val drinkList: MutableList<Menu> = mutableListOf(
        Menu(1, "soda", 2000, "extreme! sparkling!"),
        Menu(2, "juice", 2000, "fresh! fruity!"),
        Menu(3, "coffee", 2000, "tasty! deep!"),
    )

    override fun displayInfo() {

        for (beverage in drinkList) {
            println("${beverage.num} | ${beverage.name.padEnd(10)} | ${beverage.price} | ${beverage.introduce.padStart(10)}")
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