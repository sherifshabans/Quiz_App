package com.example.quizapp


object Constants {
const val USER_NAME:String ="user_name"
const val TOTSL_QUESTIONS:String ="total_questions"
const val CORRECT_ANSWERS:String ="correct_answers"




    fun getQuestions():ArrayList<Question>{
         val questionList =ArrayList<Question>()
        //1
        val que1=Question(
            1,"خمن اسم الشخص اللي مع شريف في الصورة لو جاوبت كله صح هتكسب رحلة إلى ليبيا ",
            R.drawable.abdo,
            "عبدالرحمن عمر",
            "عبده عمر",
            "فاروق الصغير",
            "شريف واخوه",
            4

        )
        questionList.add(que1)

        //2
        val que2=Question(
            2,"خمن اسم الشخص اللي مع شريف في الصورة لو جاوبت كله صح هتكسب رحلة إلى ليبيا ",
            R.drawable.ah,
            "أحمد هشام",
            "عبده عمر",
            "هشام أحمد",
            "شريف مين؟",
            1

        )

        questionList.add(que2)
//3
        val que3=Question(
            3,"خمن اسم الشخص اللي مع شريف في الصورة لو جاوبت كله صح هتكسب رحلة إلى ليبيا ",
            R.drawable.omar,
            "عمر رأفت ",
            "التالت",
            "ميرو ",
            "كلهم صح",
            4

        )

        questionList.add(que3)
//4
        val que4=Question(
            4,"خمن اسم الشخص اللي مع شريف في الصورة لو جاوبت كله صح هتكسب رحلة إلى ليبيا ",
            R.drawable.mod,
            "مدثر إبراهيم",
            "محمد نادي",
            "نور إبراهيم",
            "المدثر إبراهيم",
            4

        )

        questionList.add(que4)
//5
        val que5=Question(
            5,"خمن اسم الشخص اللي مع شريف في الصورة لو جاوبت كله صح هتكسب رحلة إلى ليبيا ",
            R.drawable.khaled,
            "خالد علي",
            "الظابط خالد",
            "العسكري خالد",
            "كلهم",
            4

        )

        questionList.add(que5)
//6
        val que6=Question(
            6,"خمن اسم الشخص اللي مع شريف في الصورة لو جاوبت كله صح هتكسب رحلة إلى ليبيا ",
            R.drawable.mo,
            "محمد عثمان",
            "عبده عمر",
            "أحمد هشام",
            "شريف شعبان",
            1

        )

        questionList.add(que6)
//7
        val que7=Question(
            7,"خمن اسم الشخص اللي مع شريف في الصورة لو جاوبت كله صح هتكسب رحلة إلى ليبيا ",
            R.drawable.diab,
            "محمد أحمد دياب",
            "أحمد محمد دياب",
            "ديبو",
            "مين دا؟",
            1

        )

        questionList.add(que7)
//8
        val que8=Question(
            8,"خمن اسم الشخص اللي مع شريف في الصورة لو جاوبت كله صح هتكسب رحلة إلى ليبيا ",
            R.drawable.moadel,
            "محمد عادل",
            "طبيب الإنسانية",
            "محمد عادل سليم",
            "ولا واحد من دول",
            1

        )

        questionList.add(que8)
//9
        val que9=Question(
            9,"خمن اسم الشخص اللي مع شريف في الصورة لو جاوبت كله صح هتكسب رحلة إلى ليبيا ",
            R.drawable.me,
            "أحمد هشام",
            "عبده عمر",
            "شريف شعبان ",
            "مين دول؟",
            3

        )

        questionList.add(que9)
//10
        val que10=Question(
            9,"خمن اسم الشخص اللي مع شريف في الصورة لو جاوبت كله صح هتكسب رحلة إلى ليبيا ",
            R.drawable.sherif,
            "شريف وحده أصلا",
            "الصحاب",
            "شريف شعبان ",
            "الصورة دي فين؟",
            2

        )

        questionList.add(que10)



        return questionList

    }


}