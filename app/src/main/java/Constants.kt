import com.mohamedreda.mawarith.R

object Constants {
    fun getQuestions():ArrayList<Question>{
        val questionsList = ArrayList<Question>()
        val que1 = Question(
            id = 1,
            image = R.drawable.algeria,
            question = "what is name of this flag ",
            optionOne = "Algeria",
            optionTow = "Usa",
            optionThere = "Dubai",
            optionFour = "France",
            correctAnswer = 1

        )

        questionsList.add(que1)
        //2
        val que2 = Question(
            id = 1,
            image = R.drawable.afghanistan,
            question = "what is name of this flag ",
            optionOne = "vietnam",
            optionTow = "Morocco",
            optionThere = "afghanistan",
            optionFour = "Algeria",
            correctAnswer = 3

        )

        questionsList.add(que2)
        //3
        val que3 = Question(
            id = 1,
            image = R.drawable.albania,
            question = "what is name of this flag ",
            optionOne = "Bangladesh",
            optionTow = "Morocco",
            optionThere = "Bahamas",
            optionFour = "albania",
            correctAnswer = 4

        )

        questionsList.add(que3)

        //4
        val que4 = Question(
            id = 1,
            image = R.drawable.andorra,
            question = "what is name of this flag ",
            optionOne = "Cuba",
            optionTow = "andorra",
            optionThere = "Chile",
            optionFour = "Cyprus",
            correctAnswer = 2

        )

        questionsList.add(que4)
        //5
        val que5 = Question(
            id = 1,
            image = R.drawable.angola,
            question = "what is name of this flag ",
            optionOne = "Czech Republic",
            optionTow = "Djibouti",
            optionThere = "angola",
            optionFour = "Dominican Republic",
            correctAnswer = 3

        )

        questionsList.add(que5)


        return questionsList

    }
}