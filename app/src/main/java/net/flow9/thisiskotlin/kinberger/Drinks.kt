package net.flow9.thisiskotlin.kinberger

class Drinks : Item() {

    val drinkList: MutableList<Menu> = mutableListOf(
        Menu("음료수",1, "soda", 2000, "콜라, 사이다, 환타"),
        Menu("음료수",2, "juice", 2000, "포도주스, 오렌지주스, 사과주스"),
        Menu("음료수",3, "coffee", 2000, "아메리카노, 라떼"),
    )

    override fun displayInfo() {
        println("[ Drinks MENU ]")
        for (menu in drinkList) {
            println("${menu.num}. ${menu.name.padEnd(18)} | W ${"%.1f".format(menu.price.toDouble() / 1000)} | ${menu.introduce}")
        }
        println("0. ${"뒤로가기".padEnd(15)}")
    }

    override fun function() {
        while (true){
            val input = readLine()!!.toInt()
            when (input) {
                in 1..3 -> {
                    val menu = drinkList[input - 1]
                    println("\n\"${menu.name.padEnd(18)} | ${menu.price} | ${menu.introduce}\"")
//장바구니 화면 출력
                    println(
                        "▲ 위 메뉴를 장바구니에 추가하시겠습니까?\n" +
                                "1. 확인 2. 취소"
                    )
//입력 받기
                    val addCart = readLine()!!.toInt()
//조건문
                    if (1 == addCart) {
//실제로 장바구니 객체에 담는 기능
                        println(
                            "\n${menu.name} 가 장바구니에 추가되었습니다.\n" +
                                    "\n" +
                                    "▼장바구니 목록"
                        )
                        val drinkCart = drinkList[input - 1]
                        Cart.addmenus(
                            Menu(
                                drinkCart.x,
                                drinkCart.num,
                                drinkCart.name,
                                drinkCart.price,
                                drinkCart.introduce
                            )
                        )
                        for (cart in Cart.menus) {
                            println(
                                "${cart.name.padEnd(15)} ${cart.price}"
                            )
                        }
                        println("\n")
                    } else {
                        println("\n취소되었습니다.\n")
                    }
                    break
                }

                0 -> {
//이전 메인메뉴로 돌아가기
                    return
                }

                else -> {
                    println("다시 입력해주세요.")
                    continue
                }
            }
        }
    }
}