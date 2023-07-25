package com.example.forezen_custard

open class Item(var name:String, var price:Int)

class soft_menu(name:String, price: Int) : Item(name ,price)
class shakemenuname(name:String, price: Int) : Item(name ,price)
class beadmenu (name:String, price: Int) : Item(name ,price)
class gelatomenu (name:String, price: Int) : Item(name ,price)

fun displayinfo(meun:Item){
    println("메뉴:${meun.name} 가격${meun.price}")
}
fun main(){
    var icemenu = mutableListOf(
        soft_menu("소프트 콘", 2000),
        shakemenuname("쉐이크", 4500),
        beadmenu("구슬아이스크림",5000),
        gelatomenu("젤라또",4500)
    )
    while (true){
        try {
            println(
                "[ Forzen Custard MENU ]\n" +
                        "[1]소프트 콘          |W 2000|\n" +
                        "[2]쉐이크            |W 4500|\n" +
                        "[3]구슬아이스크림      |W 5000|\n" +
                        "[4]젤라또            |W 4500|\n" +
                        "[5]뒤로가기\n" +
                        "[0]종료"
            )
            val choice = readLine()?.toInt()
            when(choice){
                1,2,3,4->{
                    var selectedmenu = icemenu[choice - 1]
                    displayinfo(selectedmenu)
                }
                5 -> {
                    return main()
                }
                0 ->{
                    println("종료합니다")
                }
                else -> {
                    println("잘못 입력하셨습니다.")
                }
            }
            break
        }catch (e :NumberFormatException){
            println("잘못 입력하셨습니다.")
        }
    }
}