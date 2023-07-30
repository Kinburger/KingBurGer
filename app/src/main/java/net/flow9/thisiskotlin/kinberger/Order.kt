package net.flow9.thisiskotlin.kinberger

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.time.LocalDateTime


class Order : Item() {
    var now = LocalDateTime.now()
    var start = LocalDateTime.of(now.year, now.month, now.dayOfMonth, 1, 10, 0)
    var end = LocalDateTime.of(now.year, now.month, now.dayOfMonth, 1, 45, 0)
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
                                        val isMainatainance = isMainatainance()
                                        if(isMainatainance) {
                                            println("현재 시각은 ${now.hour}시 ${now.minute}분 입니다.")
                                            println("은행 점검 시간은 ${start.hour}시 ${start.minute}분 ~ ${end.hour}시 ${end.minute}분이므로 결제할 수 없습니다.")
                                        } else if (Cart.money >= add) {
                                            when (b) {
                                                1 -> {
                                                    println("▶ 잔액${Cart.money}원 중 ${add}원 사용하여 구매 하겠습니다.")

                                                    runBlocking {
                                                        println("3초 후 주문이 완료됩니다.")
                                                        Delay()
                                                    }
                                                    println("결제를 완료 했습니다.")
                                                    println("▶ 현재 잔액은 ${Cart.money - add}원 입니다.")
                                                    println("3초후 메뉴판화면으로 돌아갑니다.")
                                                    println("이용해 주셔서 감사합니다 KinBurger였습니다.\t 현재 시간 : ${now.hour}시 ${now.minute}분 ${now.second}초 입니다.")

                                                    runBlocking {
                                                        Delay()
                                                    }
                                                    Cart.addMenus1()
                                                    return Play().run()
                                                }

                                                2 -> Play().run()
                                            }
                                        }
                                         else {
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

    suspend fun Delay() {

        delay(3000)
    }
    private fun isMainatainance(): Boolean {
        return now.isAfter(start) && now.isBefore(end)
    }
}

