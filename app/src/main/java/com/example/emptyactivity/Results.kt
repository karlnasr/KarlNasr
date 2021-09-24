package com.example.emptyactivity

data class Results (var Dices: MutableList<Int>, var DiceNb: Int)
{
    override fun toString(): String{
        var result=""
        result+=DiceNb
        result+=": "
        for (i in Dices)
        {
            result+=i
            result+=" "
        }
        return result
    }
}