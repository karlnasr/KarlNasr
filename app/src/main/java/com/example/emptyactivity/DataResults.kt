package com.example.emptyactivity

object DataResults {
    val results1 : MutableList<Results> = mutableListOf()

    fun Remove(){
        results1.clear()
    }

    fun Get(): MutableList<Results>{
        return results1
    }

    fun AddResults(x: Results){
        results1.add(x)
    }

    fun AddOne(dice: Int, DiceNb: Int){
        if(results1.size==0)
        {
            val list: MutableList<Int> = mutableListOf(dice)
            results1.add(Results(list,DiceNb))
            return
        }

        val last= results1.removeLast()
        if(last.Dices.size == last.DiceNb)
        {
            results1.add(last)
            val list: MutableList<Int> = mutableListOf(dice)
            results1.add(Results(list,DiceNb))
        }
        else
        {
            last.Dices.add(dice)
            last.DiceNb= DiceNb
            results1.add(last)
        }
    }
}