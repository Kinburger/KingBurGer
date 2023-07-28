package net.flow9.thisiskotlin.kinberger

class Beer : Item() {
    val BeerList: MutableList<Menu> = mutableListOf(
        Menu("주류",1, "Pale Ale", 5000, "쌉싸름한 맛 도수: 4.2"),
        Menu("주류",2, "India Pale Ale", 6000, "진하고 강한 맛 도수: 5.5~7.5"),
        Menu("주류",3, "Weizen", 7000, "풍부한 과일향과 풍성한 거품 도수: 5.5"),
        Menu("주류",4, "Porter", 8000, "깊은 훈제향과 달콤한 맛 도수: 5.3"),
        Menu("주류",5, "Stout", 8000, "씁쓸하면서 맥주 본연의 맛 도수: 7")
    )

    override fun displayInfo() {
        println("[ Beer MENU ]")
        for (menu in BeerList) {
            println("${menu.num}. ${menu.name.padEnd(18)} | W ${"%.1f".format(menu.price.toDouble() / 1000)} | ${menu.introduce}")
        }
        println("0. ${"뒤로가기".padEnd(15)}")
    }

    override fun function() {
        //메뉴 번호 입력을 받아야함
        while (true) {
            try {
                val input = readLine()!!.toInt()
                //선택한 메뉴 보이게
                when (input) {
                    in 1..5 -> {
                        val menu = BeerList[input - 1]
                        println("\n\"${menu.name.padEnd(18)} | ${menu.price} | ${menu.introduce}\" 를 선택하셨습니다.")
                        when (input) {
                            1 -> {
                                println("\n\"${menu.name.padEnd(18)} 의 도수는 4.2 한가지 입니다.")
                            }

                            2 -> {
                                println("\n\"${menu.name.padEnd(18)} 의 도수는 5.5~7.5 입니다.")
                                println("도수를 선택 해 주세요")
                                while (true) {
                                    try {
                                        val als: String? = readLine()
                                        val al = als?.toDoubleOrNull() ?: -1.0
                                        if (al >= 5.5 && al <= 7.5) {
                                            println("다시 선택해주세요")
                                        } else {
                                            println("도수 ${al}을 선택하셨습니다.")

                                        }
//                                        println("도수 ${al}를 선택 하셨습니다")
//                                        break
                                    } catch (e: java.lang.NumberFormatException) {
                                        println("숫자를 입력하세요")
                                    }
                                }
                            }

                            3 -> {
                                println("\n\"${menu.name.padEnd(18)} 의 도수는 5.5 한가지 입니다.")
                            }

                            4 -> {
                                println("\n\"${menu.name.padEnd(18)} 의 도수는 5.3 한가지 입니다.")
                            }

                            5 -> {
                                println("\n\"${menu.name.padEnd(18)} 의 도수는 7 입니다.")
                            }
                        }
                        //장바구니 화면 출력
                        println(
                            "위 메뉴를 장바구니에 추가하시겠습니까?\n" +
                                    "1. 확인        2. 취소"
                        )
                        //입력 받기
                        val addCart = readLine()!!.toInt()
                        //조건문
                        if (1 == addCart) {
                            //실제로 장바구니 객체에 담는 기능
                            println("\n${menu.name} 가 장바구니에 추가되었습니다.\n")
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
            } catch (e: java.lang.NumberFormatException) {
                println("숫자를 입력하세요")
            }
        }
    }

}