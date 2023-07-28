package net.flow9.thisiskotlin.kinberger

class Burgers : Item() {
    val burgerList: MutableList<Menu> = mutableListOf(
        Menu("햄버거",1, "ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
        Menu("햄버거",2, "SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
        Menu("햄버거",3, "ShroomBurger", 9400, "베이컨, 몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거"),
        Menu("햄버거",4, "Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
        Menu("햄버거",5, "Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거")
    )

    override fun displayInfo() {
        println("[ Burgers MENU ]")
        for (menu in burgerList) {
            println("${menu.num}. ${menu.name.padEnd(18)} | W ${"%.1f".format(menu.price.toDouble() / 1000)} | ${menu.introduce}")
        }
        println("0. ${"뒤로가기".padEnd(15)} | 뒤로가기")
    }

    override fun function() {
        //메뉴 번호 입력을 받아야함
        while (true) {
            val input = readLine()!!.toInt()
            //선택한 메뉴 보이게
            when (input) {
                in 1..5 -> {
                    val menu = burgerList[input - 1]
                    println("\n\"${menu.name.padEnd(18)} | ${menu.price} | ${menu.introduce}\"")
                    //장바구니 화면 출력
                    println(
                        "▲위 메뉴를 장바구니에 추가하시겠습니까?\n" +
                                "1. 확인        2. 취소"
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
                        val burgercart = burgerList[input - 1]
                        Cart.addmenus(
                            Menu(
                                burgercart.x,
                                burgercart.num,
                                burgercart.name,
                                burgercart.price,
                                burgercart.introduce
                            )
                        )
                        for (cart in Cart.menus) {
                            println(
                                "${cart.name.padEnd(15)} ${cart.price} ${
                                    cart.introduce.padStart(
                                        15
                                    )
                                }"
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

        //
    }

}