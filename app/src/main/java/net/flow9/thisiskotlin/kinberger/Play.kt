package net.flow9.thisiskotlin.kinberger

class Play {
    val mainList: MutableList<MutableList<String>> = mutableListOf(
        mutableListOf("[1]Bergers", "      | 앵거스 비프 통살을 다져만든 버거"),
        mutableListOf("[2]ForzenCustard", "| 매장에서 신선하게 만드는 아이스크림"),
        mutableListOf("[3]Drink", "        | 매장에서 직접 만드는 음료"),
        mutableListOf("[4]Beer", "         | 뉴욕 브루클린 브루어리에서 양조한 맥주"),
        mutableListOf("[0]Exit", "         | 종료하기")
    )
    val burgers = Burgers()
    fun run(){
        println("▼ 아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n")
        for(mainlist in mainList){
            println(mainlist.joinToString("  "))
        }

        while(true){
            try {
                val select: String? = readLine()
                val selects =select?.toInt()?: -1

                if(selects<=-1 || selects> 4){
                    println("잘못된 번호를 입력했어요 다시 입력해주세요.")
                } else {
                    when(selects){
                        1 -> {
                            burgers.displayInfo()
                            burgers.function()
                        }
                        0 -> {
                            println("키오스크 종료")
                            break
                        }
                    }
                }

            }catch (e:Exception){
                println("잘못된 번호를 입력했어요 다시 입력해주세요.")
            }
        }
    }
}
