package net.flow9.thisiskotlin.kinberger

object Cart:Item() {
    val menus: MutableList<Menu> = mutableListOf()
    fun addmenus(menu1:Menu){
       menus.add(menu1)
    }
}