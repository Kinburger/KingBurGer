package net.flow9.thisiskotlin.kinberger

class ForzenCustard : Item() {
    val forzencustardList: MutableList<Menu> = mutableListOf(
        Menu(1, "Soft Corn", 2000, ""),
        Menu(2, "Shake", 4500, ""),
        Menu(3, "Dippin' Dots", 5000, ""),
        Menu(4, "Gelātus", 4500, "")
    )

    override fun displayInfo() {
        println("▶메뉴를 선택해주세요")
        println("[ForzenCustard Menu]")
        for (menu in forzencustardList) {
            println("${menu.num} ${menu.name.padEnd(15)}|${menu.price}|${menu.introduce.padStart(10)}")
        }
        while (true) {
            try {
                val select: String? = readLine()
                val selects = select?.toInt() ?: -1

                if (selects <= -1 || selects > 4) {
                    println("메뉴를 다시 선택해주세요")
                } else {
                    when (selects) {
                        in 1..4 -> {
                            print(forzencustardList[selects - 1].name.padEnd(15))
                            print(forzencustardList[selects - 1].price)
                            println(forzencustardList[selects - 1].introduce.padStart(10))
                            println("▲위 메뉴를 장바구니에 추가하시겠습니까?")
                            println("[1]확인                     [2]취소")
                            while (true) {
                                try {
                                    val select1: String? = readLine()
                                    val selects1 = select1?.toInt() ?: -1
                                    if(selects1<=-1 || selects1>2){
                                        println("다시 선택해주세요")
                                    }else {
                                        when(selects1){
                                            1 -> {

                                                val forzencart=forzencustardList[selects-1]
                                               Cart.addmenus(Menu(forzencart.num,forzencart.name,forzencart.price,forzencart.introduce))
                                                println("${forzencart.name}메뉴가 장바구니에 추가되었습니다.\n")

                                                println("▼장바구니 목록\n")
                                                for(cart in Cart.menus){
                                                    println("${cart.name.padEnd(15)} ${cart.price} ${cart.introduce.padStart(15)}")
                                                }
                                                return
                                            }
                                            2 -> return
                                        }
                                    }

                                } catch (e: Exception) {
                                    println("다시 입력해주세요")
                                }
                            }
                        }

                        0 -> {
                            println("▶ 뒤로 가기")
                            return
                        }
                    }
                }
            } catch (e: Exception) {
                println("메뉴를 다시 선택해주세요")
            }
        }
    }

    override fun function() {



    }
}