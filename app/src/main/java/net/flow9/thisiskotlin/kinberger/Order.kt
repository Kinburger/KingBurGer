package net.flow9.thisiskotlin.kinberger



class Order : Item() {
    override fun function() {
        println("[ORDER MENU]")
        println("[1]order\t\t|\t장바구니를 확인 후 주문합니다.\n[2]Cancel\t\t|\t진행중인 주문을 취소합니다.")
        while (true) {
            try {
                val x: String? = readLine()
                val y = x?.toInt() ?: -1
                if (y <= -1 || y > 2) {
                    println("다시 선택해주세요")
                } else {
                    when (y) {
                        1 -> {
                            println("아래와 같이 주문 하시겠습니까?\n[ Orders ]")
                            for (common in Cart.menus) {
                                if (common.x != "아이스크림") {
                                    println("메뉴: ${common.name}가격: ${common.price}원\t\t설명: ${common.introduce}")
                                }
                            }
                            for ((menu, flavor) in ForzenCustard.selectedMenus) {
                                println("메뉴: ${menu.name}가격: ${menu.price}원\t\t설명: ${menu.introduce}\t\t맛: ${flavor}")
                            }
                            println("[1]주문\t\t\t [2]메뉴판")
                            var add = 0
                            for (menuItem in Cart.menus) {
                                add += menuItem.price
                            }
                            println("▶ 계산서 : 총 ${add}원 입니다.")
                            println("▶ 잔액${Cart.money}")

                            while (true) {
                                try {
                                    val a: String? = readLine()
                                    val b = a?.toInt() ?: -1
                                    if (b <= 0 || b > 2) {
                                        println("▶ 다시 선택해주세요")
                                    } else {
                                        if (Cart.money >= add) {
                                            when (b) {
                                                1 -> {
                                                    println("▶ 잔액${Cart.money}원 중 ${add}원 사용하여 구매 완료 했습니다.")
                                                    println("▶ 현재 잔액은 ${Cart.money - add}원 입니다.")
                                                    Cart.addMenus1()
                                                    break
                                                }

                                                2 -> Play().run()
                                            }
                                        } else {
                                            println("▶ 잔액이 부족합니다.")
                                            return Play().run()
                                        }

                                    }

                                } catch (e: Exception) {
                                    return Play().run()
                                }
                            }
                            return

                        }

                        2 -> return Play().run()
                    }
                }

            } catch (e: Exception) {
                return Play().run()
            }
        }
    }
}