package net.flow9.thisiskotlin.kinberger

//fun main() {
//    runBurgerMenu()
//}
//
//fun runBurgerMenu() {
//    //ArrayList로 Item을 관리 - 의도
//    // Item 타입(클래스)의 객체를 담을 ArrayList 객체를 생성해서 menuItems에 넣어준다(연결).
//    val menuItems = ArrayList<Item>()
//    menuItems.add(ShackBurger("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"))
//    menuItems.add(SmokeShack("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"))
//    menuItems.add(ShroomBurger("ShroomBurger", 9.4, "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거"))
//    menuItems.add(CheeseBurger("CheesBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"))
//    menuItems.add(HamBurger("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"))
//
//    // menuItems에 들어있는 리스트를 순차적으로 하나씩 가져와서 item에 넣어줌
//    // item.displayinfo()를 통해서 println("\"$name    | W $price | $description\"")을 수행함
////    for (item in menuItems) {
////        item.displayinfo()
////    }
//
//    println(
//        "[ Burgers MENU ]\n" +
//                "1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거\n" +
//                "2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거\n" +
//                "3. Shroom Burger | W 9.4 | 몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거\n" +
//                "4. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거\n" +
//                "5. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거\n" +
//                "0. 뒤로가기      | 뒤로가기\n" +
//                "0 <-"
//    )
//    while (true) {
//        val input = readLine()!!.toInt()
//        //입력창에서 입력값을 받은 결과가 출력됨
//        when (input) {
//            in 1..5 -> {
//                menuItems[input - 1].displayinfo()
//                break
//            }
//            0 -> {
//                //이전 메인메뉴로 돌아가기
//                return
//            }
//            else -> {
//                println("다시 입력해주세요.")
//                continue
//            }
//        }
//    }
//}
//open class Item(val name: String, val price: Double, val description: String) {
//    //displayinfo()를 구현함
//    open fun displayinfo() {
//        println("\"$name    | W $price | $description\"")
//
//    }
//
//}
//
//// Burger 클래스 (Item 클래스를 상속)
//open class Burger(name: String, price: Double, description: String) :
//    Item(name, price, description) {
//
//}
//
//class ShackBurger(name: String, price: Double, description: String) :
//    Burger(name, price, description) {
//
//}
//class SmokeShack(name: String, price: Double, description: String) :
//    Burger(name, price, description) {
//
//}
//class ShroomBurger(name: String, price: Double, description: String) :
//    Burger(name, price, description) {
//
//}
//class CheeseBurger(name: String, price: Double, description: String) :
//    Burger(name, price, description) {
//
//}
//class HamBurger(name: String, price: Double, description: String) :
//    Burger(name, price, description) {
//
//}
//