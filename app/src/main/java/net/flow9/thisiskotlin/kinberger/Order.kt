package net.flow9.thisiskotlin.kinberger

class Order: Item() {

    override fun function(){
        for(menu in Cart.menus){
            println("${menu.name.padEnd(20)}|${menu.price}|${menu.introduce.padStart(20)}")
        }
        println("▲위 메뉴를 장바구니에 추가하시겠습니까?")
        println("[1]확인                     [2]취소")
        while (true) {
            try {
                val x: String? = readLine()
                val y = x?.toInt() ?: -1
                if(y<=-1 || y>2){
                    println("다시 선택해주세요")
                }else {
                    when(y){
                        1 -> {
                            println("아래와 같이 주문 하시겠습니까?\n[ Orders ]")
                            for(menu in Cart.menus){
                                println("${menu.name.padEnd(20)}|${menu.price}|${menu.introduce.padStart(20)}")
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
                                    if(b<=0 || b>2){
                                        println("▶ 다시 선택해주세요")
                                    }else {
                                        if(Cart.money>=add){
                                            when(b){
                                                1 -> {
                                                    println("▶ 잔액${Cart.money}원 중 ${add}원 사용하여 구매 완료 했습니다.")
                                                    println("▶ 현재 잔액은 ${Cart.money-add}원 입니다.")
                                                    Cart.addMenus1()
                                                    Play().run()
                                                }
                                                2 -> Play().run()
                                            }
                                        }else {
                                            println("▶ 잔액이 부족합니다.")
                                            return Play().run()
                                        }

                                    }

                                } catch (e: Exception) {
                                    println("다시 입력해주세요")
                                }
                            }

                            return
                        }
                        2 -> return Play().run()
                    }
                }

            } catch (e: Exception) {
                println("다시 입력해주세요")
            }
        }
    }

}


