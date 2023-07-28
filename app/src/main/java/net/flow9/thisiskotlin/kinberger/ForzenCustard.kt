package net.flow9.thisiskotlin.kinberger

class ForzenCustard : Item() {
    val icemeun: MutableList<Menu> = mutableListOf(
        Menu("아이스크림",1,"소프트 콘\t\t", 2000, "부드러운 아이스크림"),
        Menu("아이스크림",2,"쉐이크\t\t\t", 2500, "섞어먹는 아이스크림"),
        Menu("아이스크림",3,"구슬아이스크림\t", 2500, "방울방울 아이스크림"),
        Menu("아이스크림",4,"젤라또\t\t\t", 3000, "꾸덕한 아이스크림")
    )
    companion object {
        val selectedMenus: MutableList<Pair<Menu, String>> = mutableListOf()
    }
    override fun displayInfo() {
        println("[ Frozen Custard MENU ]")
        for (menu in icemeun) {
            println(
                "[${menu.num}] ${menu.name}  ${menu.price}  ${menu.introduce}"
            )
        }
        println("[0] 뒤로가기")
    }
    override fun function() {
        first@ while (true) {
            try {
                val choice = readLine()?.toInt()

                when (choice) {
                    1, 2, 3, 4 -> {
                        val selectedMenu = icemeun[choice - 1]
                        println("메뉴: ${selectedMenu.name} 가격: ${selectedMenu.price}원 설명: ${selectedMenu.introduce}")

                        // 맛 선택
                        second@ while (true) {
                            try {

                                println("맛을 선택하세요. [1] 초콜릿 [2] 바나나 [3] 딸기 [4]메론 [0]뒤로 가기")
                                val flavorChoice = readLine()?.toInt()
                                when (flavorChoice) {

                                    1 -> {
                                        selectedMenus.add(selectedMenu to "초콜릿")
                                        break
                                    }

                                    2 -> {
                                        selectedMenus.add(selectedMenu to "바나나")
                                        break
                                    }

                                    3 -> {
                                        selectedMenus.add(selectedMenu to "딸기")
                                        break
                                    }

                                    4 -> {
                                        selectedMenus.add(selectedMenu to "메론")
                                        break
                                    }

                                    0 -> {
                                        displayInfo()
                                        continue@first
                                    }

                                    else -> {
                                        println("잘못된 맛을 선택하셨습니다.")
                                        continue
                                    }
                                }
                            } catch (e: NumberFormatException) {
                                println("잘못 입력하셨습니다. 메뉴 번호를 다시 입력하세요.")
                                continue@second
                            }
                        }

                        println("다른 메뉴도 선택하시겠습니까? ([1] 네       [2] 아니요)")
                        third@ while (true) {

                            val anotherChoice = readLine()?.toInt()
                            if (anotherChoice == 1) {
                                println("[ Frozen Custard MENU ]")

                                for ((index, menu) in icemeun.withIndex()) {
                                    println(
                                        "[${index + 1}] ${menu.name} ${menu.price} ${menu.introduce}"
                                    )
                                }
                                println("[0] 뒤로가기")
                                break
                            } else if (anotherChoice == 2) {
                                for ((menu, flavor) in selectedMenus) {
                                    println("메뉴: ${menu.name}\t가격: ${menu.price}원\t설명: ${menu.introduce}\t맛: ${flavor}")
                                }
                                println("위 메뉴를 장바구니에 추가하시겠습니까?")
                                println("[1]확인                     [2]취소")
                                fourth@ while (true) {
                                    try {
                                        val selec = readLine()?.toInt()
                                        if (selec == 1) {

                                            for ((menu) in selectedMenus) {
                                                Cart.addmenus((menu))
                                            }
                                            println("메뉴가 장바구니에 추가되었습니다.\n")

                                            println("장바구니 목록")
                                            for ((menu, flavor) in selectedMenus) {
                                                println("메뉴: ${menu.name}가격: ${menu.price}원\t\t설명: ${menu.introduce}\t맛: ${flavor}")
                                            }
                                            return Play().run()
                                        } else if (selec == 2) {
                                            println("메뉴판으로 이동합니다")
                                            return Play().run()
                                        } else {
                                            println("잘못 입력하셨습니다.")
                                            continue@fourth
                                        }

                                    } catch (e: Exception) {
                                        println("잘못 입력하셨습니다.")
                                    }
                                }
                            }
                            else if (anotherChoice == 0){
                                return Play().run()
                            }
                            else {
                                println("잘못 입력하셨습니다 y 또는 n를 입력하세요.")

                                continue@third
                            }
                        }
                    }
                    0 -> {
                        return
                    }
                    else -> {
                        println("잘못된 선택입니다. 번호를 다시 입력하세요.")
                        displayInfo()
                    }
                }
            } catch (e: Exception) {
                println("잘못 입력하셨습니다. 번호를 다시 입력하세요.")
                displayInfo()
            }
        }
    }
}