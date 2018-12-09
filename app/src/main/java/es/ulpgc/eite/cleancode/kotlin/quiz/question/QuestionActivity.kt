package es.ulpgc.eite.cleancode.kotlin.quiz.question

import android.util.Log
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import es.ulpgc.eite.cleancode.kotlin.quiz.R

class QuestionActivity : AppCompatActivity(), QuestionContract.View {

    lateinit var presenter: QuestionContract.Presenter

    lateinit var trueButton: Button
    lateinit var falseButton: Button
    lateinit var cheatButton: Button
    lateinit var nextButton: Button
    lateinit var questionText: TextView
    lateinit var answerText: TextView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        /*
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, QuestionFragment())
                .commitNow()
        }
        */

        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        cheatButton = findViewById(R.id.cheatButton)
        nextButton = findViewById(R.id.nextButton)
        questionText = findViewById(R.id.questionText)
        answerText = findViewById(R.id.answerText)

        trueButton.setOnClickListener { presenter.clickTrueButton() }
        falseButton.setOnClickListener { presenter.clickFalseButton() }
        cheatButton.setOnClickListener { presenter.clickCheatButton() }
        nextButton.setOnClickListener { presenter.clickNextButton() }

        // Do the setup
        QuestionConfigurator.configureActivity(this)

        // Do some work
        fetchData()
    }

    fun fetchData() {

        // Call the presenter to fetch the data
        presenter.fetchQuestionData()
    }

    override fun displayQuestionData(viewModel: QuestionViewModel) {
        // Log.d(TAG, "displayQuestionData()")

        // Deal with the data, update the states, ui etc..
        // Log.d(TAG, "text = $viewModel.text")
        //val textView = findViewById<TextView>(R.id.text)
        //textView.text = viewModel.text


        questionText.text = viewModel.questionText
        answerText.text = viewModel.answerText

        trueButton.text = viewModel.trueLabel
        falseButton.text = viewModel.falseLabel
        cheatButton.text = viewModel.cheatLabel
        nextButton.text = viewModel.nextLabel

        trueButton.isEnabled = viewModel.trueEnabled
        falseButton.isEnabled = viewModel.falseEnabled
        cheatButton.isEnabled = viewModel.cheatEnabled
        nextButton.isEnabled = viewModel.nextEnabled
    }

    companion object {
        const val TAG = "QuestionActivity"
    }
}
