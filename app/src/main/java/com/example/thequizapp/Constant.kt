package com.example.thequizapp

object Constant {

    const val USER_NAME:String = "user_name"
    const val TOTAL_QUESTION:String = "total_question"
    const val CORRECT_ANSWER:String = "correct_answer"
    fun getQuestion():ArrayList<Question>{
            val questionList = ArrayList<Question>()
            val que1 = Question(1,"What Country does this belongs to ?",R.drawable.ic_image_bhutan
            ,"Argentina","America","Australia","Bhutan",
            4
            )
        questionList.add(que1)


        val que2 = Question(2,"What Country does this belongs to ?",R.drawable.ic_image_canada
            ,"Singpore","Japan","UnitedKingdom","Canada",
            4
        )
        questionList.add(que2)

        val que3 = Question(3,"What Country does this belongs to ?",R.drawable.ic_image_china
            ,"SouthKorea","China","NorthKorea","Singapore",
            2
        )
        questionList.add(que3)

        val que4 = Question(4,"What Country does this belongs to ?",R.drawable.ic_image_india
            ,"Vietnam","japan","Canda","India",
            4
        )
        questionList.add(que4)

        val que5 = Question(5,"What Country does this belongs to ?",R.drawable.ic_image_japan
            ,"Korea","England","Japan","Finland",
            3
        )
        questionList.add(que5)

        val que6 = Question(6,"What Country does this belongs to ?",R.drawable.ic_image_northkorea
            ,"SouthKorea","NorthKorea","England","Japan",
            2
        )
        questionList.add(que6)

        val que7 = Question(7,"What Country does this belongs to ?",R.drawable.ic_image_singapore
            ,"Singapore","Pakistan","Afganistan","China",
            1
        )
        questionList.add(que7)

        val que8 = Question(8,"What Country does this belongs to ?",R.drawable.ic_image_southkorea
            ,"Malaysia","Kuwaitt","China","SouthKorea",
            4
        )
        questionList.add(que8)

        val que9 = Question(9,"What Country does this belongs to ?",R.drawable.ic_image_unitedkingdom
            ,"England","Africa","SouthAfrica","UnitedState",
            4
        )
        questionList.add(que9)

        val que10 = Question(10,"What Country does this belongs to ?",R.drawable.ic_image_vietnam
            ,"Korea","China","Japan","Vietnam",
            4
        )
        questionList.add(que10)
        return questionList
    }

}