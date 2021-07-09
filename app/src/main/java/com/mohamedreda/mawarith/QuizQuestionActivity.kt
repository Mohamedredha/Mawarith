package com.mohamedreda.mawarith

import Constants
import Question
import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.mohamedreda.mawarith.databinding.ActivityQuizQuestionBinding

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition : Int = 1
    private var mQuestionList: ArrayList<Question>? =null
    private var mSelectedOptionPosition : Int = 0
    private lateinit var binding: ActivityQuizQuestionBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setContentView(R.layout.activity_quiz_question)

        mQuestionList = Constants.getQuestions()
        setQuestion()
        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThere.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)


    }

    //setQuestion
    @SuppressLint("SetTextI18n")
    private fun setQuestion(){
        val question : Question = mQuestionList!![mCurrentPosition-1]
        defaultOptionView()

        if(mCurrentPosition== mQuestionList!!.size){
            binding.btnSubmit.text="FINISH"
        }else{
            binding.btnSubmit.text="SUBMIT" }

        binding.progressBar.progress= mCurrentPosition
        binding.tvProgress.text="$mCurrentPosition"+"/"+binding.progressBar.max
        binding.tvQuestion.text=question.question
        binding.ivImage.setImageResource(question.image)
        binding.tvOptionOne.text=question.optionOne
        binding.tvOptionTwo.text=question.optionTow
        binding.tvOptionThere.text=question.optionThere
        binding.tvOptionFour.text=question.optionFour
    }

    //defaultOptionView
    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        options.add(0,binding.tvOptionOne)
        options.add(1,binding.tvOptionTwo)
        options.add(2,binding.tvOptionThere)
        options.add(3,binding.tvOptionFour)
        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)

        }


    }

    //onClick
    @SuppressLint("SetTextI18n")
    override fun onClick(V: View?) {
        when(V?.id){
            R.id.tv_option_one->{
                selectedOptionView(binding.tvOptionOne,1)

            }
            R.id.tv_option_two->
            { selectedOptionView(binding.tvOptionTwo,2) }
            R.id.tv_option_there->
            { selectedOptionView(binding.tvOptionThere,3) }
            R.id.tv_option_four->
            { selectedOptionView(binding.tvOptionFour,4) }
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++
                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            Toast.makeText(
                                this,
                                "You have successfully completed the Quiz",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }else{
                    val question = mQuestionList?.get(mCurrentPosition-1)
                    if (question!!.correctAnswer!=mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }
                    answerView(question.correctAnswer,R.drawable.correct_option_border_bg)
                    if (mCurrentPosition== mQuestionList!!.size){
                        binding.btnSubmit.text="FINISH"
                    }else{
                        binding.btnSubmit.text="GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition=0
                }
            }


        }
    }

    private fun answerView(answer:Int,drawableView:Int){
        when(answer){
            1->{
                binding.tvOptionOne.background=ContextCompat.getDrawable(this ,drawableView)
            }
            2->{
                binding.tvOptionTwo.background=ContextCompat.getDrawable(this ,drawableView)
            }
            3->{
            binding.tvOptionThere.background=ContextCompat.getDrawable(this ,drawableView)
        }
            4->{
            binding.tvOptionFour.background=ContextCompat.getDrawable(this ,drawableView)
        }
        }
    }
    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defaultOptionView()
        mSelectedOptionPosition=selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)
    }

}