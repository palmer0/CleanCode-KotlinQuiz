package es.ulpgc.eite.cleancode.kotlin.quiz.question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import es.ulpgc.eite.cleancode.kotlin.quiz.R
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity() : AppCompatActivity(), QuestionContract.View {

  override lateinit var presenter: QuestionContract.Presenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    //setContentView(R.layout.activity_question)

    setContentView(R.layout.activity_question_fragment)

    if (savedInstanceState == null) {
      supportFragmentManager.beginTransaction()
        .replace(R.id.container, QuestionFragment())
        .commitNow()
    }

    return


    trueButton.setOnClickListener { presenter.clickTrueButton() }
    falseButton.setOnClickListener { presenter.clickFalseButton() }
    cheatButton.setOnClickListener { presenter.clickCheatButton() }
    nextButton.setOnClickListener { presenter.clickNextButton() }

    // Do the setup
    QuestionScreen.configureActivity(this)

  }


  override fun onResume() {
    super.onResume()

    return

    // Do some work
    fetchData()
  }


  fun fetchData() {

    // Call the presenter to fetch the data
    presenter.fetchQuestionData()
  }

  override fun displayQuestionData(viewModel: QuestionViewModel) {
    Log.d(TAG, "displayQuestionData()")

    // Deal with the data, update the states, ui etc..
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
