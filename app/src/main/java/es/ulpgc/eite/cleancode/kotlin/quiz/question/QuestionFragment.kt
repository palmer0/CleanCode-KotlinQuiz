package es.ulpgc.eite.cleancode.kotlin.quiz.question

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.ulpgc.eite.cleancode.kotlin.quiz.R
import kotlinx.android.synthetic.main.fragment_question.view.*

class QuestionFragment : Fragment(), QuestionContract.View {

  override lateinit var presenter: QuestionContract.Presenter

  lateinit var rootView: View


  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    // Inflate the layout for this fragment
    rootView = inflater.inflate(
      R.layout.fragment_question, container, false
    )

    with(rootView) {
      trueButton.setOnClickListener { presenter.clickTrueButton() }
      falseButton.setOnClickListener { presenter.clickFalseButton() }
      cheatButton.setOnClickListener { presenter.clickCheatButton() }
      nextButton.setOnClickListener { presenter.clickNextButton() }
    }


    // Do the setup
    QuestionScreen.configureFragment(this)

    return rootView
  }


  override fun onResume() {
    super.onResume()

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
    with(rootView) {
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

  }

  /*
  override fun displayQuestionData(state: QuestionState) {
    Log.d(TAG, "displayQuestionData()")

    // Deal with the data, update the states, ui etc..
    with(rootView) {
      questionText.text = state.questionText
      answerText.text = state.answerText

      trueButton.text = state.trueLabel
      falseButton.text = state.falseLabel
      cheatButton.text = state.cheatLabel
      nextButton.text = state.nextLabel

      trueButton.isEnabled = state.trueEnabled
      falseButton.isEnabled = state.falseEnabled
      cheatButton.isEnabled = state.cheatEnabled
      nextButton.isEnabled = state.nextEnabled
    }

  }
  */

  companion object {
    const val TAG = "QuestionFragment"
  }
}
