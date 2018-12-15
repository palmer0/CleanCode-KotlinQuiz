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

  /*
  lateinit var trueButton: Button
  lateinit var falseButton: Button
  lateinit var cheatButton: Button
  lateinit var nextButton: Button
  lateinit var questionText: TextView
  lateinit var answerText: TextView
  */

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    // Inflate the layout for this fragment
    rootView = inflater.inflate(
      R.layout.fragment_question, container, false
    )

    /*
    trueButton = rootView.findViewById(R.id.trueButton)
    falseButton = rootView.findViewById(R.id.falseButton)
    cheatButton = rootView.findViewById(R.id.cheatButton)
    nextButton = rootView.findViewById(R.id.nextButton)
    questionText = rootView.findViewById(R.id.questionText)
    answerText = rootView.findViewById(R.id.answerText)
    */

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

    /*
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
    */
  }

  companion object {
    const val TAG = "QuestionFragment"
  }
}
