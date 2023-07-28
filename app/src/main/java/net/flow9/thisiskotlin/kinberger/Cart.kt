package net.flow9.thisiskotlin.kinberger

object Cart : Item() {
    val menus: MutableList<Menu> = mutableListOf()
    val menus1: MutableList<Menu> = mutableListOf()
    var money: Int = 0

    fun addmenus(menu: Menu) {
        menus.add(menu)
    }

    //    fun addmenus1(menu: Menu) {
//        if (money >= menu.price) {
//            Cart.menus1.add(menu)
//            money -= menu.price
//        } else {
//            println("잔액은 ${money}원으로 ${menu.price - money}이 부족해서 주문할 수 없습니다.")
//        }
//    }
    fun addMenus1(){
        for(i in 0 until menus.size){

            val menuItem = menus[i]
            if (money >= menuItem.price) {
                Cart.menus1.add(menuItem)
                money -= menuItem.price
                Cart.menus.clear()
                ForzenCustard.selectedMenus.clear()

            } else {
                println("잔액은 ${money}원으로 ${menuItem.price - money}이 부족해서 주문할 수 없습니다.")
            }
        }
    }


}
fun Inputmoney(): Int {
    while (true) {
        try {
            println("초기 자본을 입력해주세요")
            val money1: String? = readLine()
            var money = money1?.toInt() ?: -1
            if (money >= 0) {
                return money
            }
        } catch (e: java.lang.Exception) {
            println("초기자본을 다시 입력해주세요\n")
        }

    }

}