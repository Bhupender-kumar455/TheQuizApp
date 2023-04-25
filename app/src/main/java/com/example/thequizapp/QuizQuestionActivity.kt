package com.example.thequizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat


class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener{
    private var mCurrentPosition:Int=1
    private var mQuestionList:ArrayList<Question>?=null
    private var mSelectedOptionPosition:Int = 0

    private var progressBar:ProgressBar?=null
    private var tvProgress :TextView?=null
    private var tvQuestion:TextView?=null
    private var ivImage:ImageView?=null

    private var tvOptionOne:TextView? = null
    private var tvOptionTwo:TextView? = null
    private var tvOptionThree:TextView? = null
    private var tvOptionFour:TextView? = null
    private var btnSubmit: Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        mQuestionList = Constant.getQuestion()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        setQuestion()
        defaultOptionView()
    }

    private fun setQuestion() {
        defaultOptionView()
        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_image)

        tvOptionOne = findViewById(R.id.tv_option_one)
        tvOptionTwo = findViewById(R.id.tv_option_two)
        tvOptionThree = findViewById(R.id.tv_option_three)
        tvOptionFour = findViewById(R.id.tv_option_four)
        btnSubmit = findViewById(R.id.submit)

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)

        btnSubmit?.setOnClickListener(this)

        val question: Question = mQuestionList!![mCurrentPosition - 1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "${mCurrentPosition}/${progressBar?.max}"

        tvQuestion?.text = question.question
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour

        if(mCurrentPosition==mQuestionList!!.size){
            btnSubmit?.text = "FINISH"
        }
        else{
            btnSubmit?.text = "NEXT"
        }
    }
    private fun defaultOptionView(){
        val option = ArrayList<TextView>()
        tvOptionOne?.let { option.add(0,it) }
        tvOptionTwo?.let { option.add(1,it) }
        tvOptionThree?.let { option.add(2,it) }
        tvOptionFour?.let { option.add(3,it) }
        for(options in option){
            options.setTextColor(Color.parseColor("#7A8089"))
            options.typeface= Typeface.DEFAULT
            options.background= ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)
        }
    }
    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defaultOptionView()
        mSelectedOptionPosition=selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background =ContextCompat.getDrawable(this,
        R.drawable.selected_option_border_bg
        )
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_option_one ->{
                tvOptionOne?.let{
                    selectedOptionView(it,1)
                }
            }
            R.id.tv_option_two ->{
                tvOptionTwo?.let{
                    selectedOptionView(it,2)
                }
            }
            R.id.tv_option_three->{
                tvOptionThree?.let{
                    selectedOptionView(it,3)
                }
            }
            R.id.tv_option_four ->{
                tvOptionFour?.let{
                    selectedOptionView(it,4)
                }
            }
            R.id.submit->{
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition++
                    when{
                        mCurrentPosition <= mQuestionList!!.size ->{
                            setQuestion()
                        }
                        else ->{
                            Toast.makeText(this,"Congrats You made till the end",Toast.LENGTH_LONG).show()
                        }
                    }
                }
                else{
                    val question = mQuestionList?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }
                    answerView(question.correctAnswer,R.drawable.correct_option_border_bg)
                    if(mCurrentPosition==mQuestionList!!.size){
                        btnSubmit?.text = "FINISH"
                    }
                    else{
                        btnSubmit?.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }

        }

    }
    private fun answerView(answer:Int,drawableView:Int){
        when(answer){
            1->{
                tvOptionOne?.background = ContextCompat.getDrawable(this,drawableView)
            }
            2->{
                tvOptionTwo?.background = ContextCompat.getDrawable(this,drawableView)
            }
            3->{
                tvOptionThree?.background = ContextCompat.getDrawable(this,drawableView)
            }
            4->{
                tvOptionFour?.background = ContextCompat.getDrawable(this,drawableView)
            }
        }
    }
}