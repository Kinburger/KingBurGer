package net.flow9.thisiskotlin.kinberger

class Beer : Item() {
    val BeerList :MutableList<Menu> = mutableListOf(Menu(1,"소주",2000,"맛있다"),Menu(1,"맥주",3000,"ㅁㅁ"))
    override fun displayInfo() {}
    override fun function() {}
}