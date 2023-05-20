package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionActivity : AppCompatActivity()  , View.OnClickListener{
    private var mCurrentPosition:Int =1;
    private var mQuestionList:ArrayList<Question>? =null
    private var mSelectedOptionPosition:Int =0
    private var mCorrectAnswer:Int =0
    private var mUserName:String ?=null




    private var progressBar :ProgressBar?=null
    private var tvProgress :TextView?=null
    private var tvQuestion :TextView?=null
    private var ivImage :ImageView?=null

    private var tvOptionOne :TextView?=null
    private var tvOptionTwo :TextView?=null
    private var tvOptionThee :TextView?=null
    private var tvOptionFour :TextView?=null
    private var btnSubmit :Button? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        mUserName=intent.getStringExtra(Constants.USER_NAME)
        progressBar=findViewById(R.id.progressBar)
        tvProgress=findViewById(R.id.tv_progress)
        tvQuestion=findViewById(R.id.tv_question)
        ivImage =findViewById(R.id.iv_image)
        tvOptionOne=findViewById(R.id.tv_option_one)
        tvOptionTwo=findViewById(R.id.tv_option_two)
        tvOptionThee=findViewById(R.id.tv_option_three)
        tvOptionFour=findViewById(R.id.tv_option_four)
        btnSubmit=findViewById(R.id.btn_submit)

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThee?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        mQuestionList=Constants.getQuestions()

        setQuestion()

    }

    private fun setQuestion() {
        defaultOptionView()

        val question: Question = mQuestionList!![mCurrentPosition - 1]
        progressBar?.progress = mCurrentPosition
        ivImage?.setImageResource(question.image)
        tvProgress?.text = "${progressBar?.max} / $mCurrentPosition"
        tvQuestion?.text = question.qustion
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThee?.text = question.optionThree
        tvOptionFour?.text = question.optionFour



        if(mCurrentPosition==mQuestionList!!.size){

            btnSubmit?.text ="تعالى نشوف حليت كام "

        }else {
            btnSubmit?.text ="جواب نهائي"

        }
    }

    private fun defaultOptionView (){
        val options =ArrayList<TextView>()
     tvOptionOne?.let {
    options.add(0,it)
     }
        tvOptionTwo?.let {
    options.add(1,it)
     }
        tvOptionThee?.let {
    options.add(2,it)
     }
        tvOptionFour?.let {
    options.add(3,it)
     }
        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(
               this,
                R.drawable.option_border
            )
        }

    }
    private fun selectedOptionView (tv:TextView , selectedOptionNum :Int){
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum
tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background= ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_background
        )
    }
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_option_one -> {
                tvOptionOne?.let {
                    selectedOptionView(it,1)
                }
            } R.id.tv_option_two -> {
                tvOptionTwo?.let {
                    selectedOptionView(it,2)
                }
            } R.id.tv_option_three -> {
                tvOptionThee?.let {
                    selectedOptionView(it,3)
                }
            }
            R.id.tv_option_four -> {
                tvOptionFour?.let {
                    selectedOptionView(it,4)
                }
            }
            R.id.btn_submit-> {
            if(mSelectedOptionPosition==0){
                mCurrentPosition++

                 when{
                     mCurrentPosition <=mQuestionList!!.size-> {
                         setQuestion()
                     }
                     else ->{
                  val intent = Intent(this,ResultActivity::class.java)
                         intent.putExtra(Constants.USER_NAME,mUserName)
                         intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswer)
                         intent.putExtra(Constants.TOTSL_QUESTIONS,mQuestionList?.size)
                         startActivity(intent)
                         finish()

                     }

                 }
                 }
            else {
            val question=mQuestionList?.get(mCurrentPosition-1)
              if(mSelectedOptionPosition != question!!.correctAnswer){
                      answerView(mSelectedOptionPosition,R.drawable.wrong_option_border)
                  }
              else {
                      mCorrectAnswer++
                  }

                answerView(question.correctAnswer,R.drawable.correct_option_border)
                if(mCurrentPosition==mQuestionList!!.size){
                btnSubmit?.text ="تعالى نشوف حليت كام"
                 }else {
                    btnSubmit?.text ="يلا بينا نشوف الصورةاللي بعدها"

                 }
mSelectedOptionPosition=0;

                 }
            }

            }
        }

    private fun answerView(answer:Int ,dewableView :Int){
when(answer){
    1->{
        tvOptionOne?.background=ContextCompat.getDrawable(
            this,dewableView
        )
    }
    2->{
        tvOptionTwo?.background=ContextCompat.getDrawable(
            this,dewableView
        )
    }
    3->{
        tvOptionThee?.background=ContextCompat.getDrawable(
            this ,
            dewableView
        )
    }
    4->{
        tvOptionFour?.background=ContextCompat.getDrawable(
            this,dewableView
        )
    }


}


    }


}