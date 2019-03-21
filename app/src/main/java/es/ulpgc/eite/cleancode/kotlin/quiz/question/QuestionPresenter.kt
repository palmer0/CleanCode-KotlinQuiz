package es.ulpgc.eite.cleancode.kotlin.quiz.question

import android.util.Log
import java.lang.ref.WeakReference

class QuestionPresenter : QuestionContract.Presenter {

  var view: WeakReference<QuestionContract.View>? = null
  lateinit var viewModel: QuestionViewModel
  lateinit var model: QuestionContract.Model
  lateinit var router: QuestionContract.Router

  override fun fetchQuestionData() {
    Log.d(TAG, "fetchQuestionData()")

    val cheated = router.getDataFromCheatScreen()

    cheated?.let {
      Log.d(TAG, "cheated: $it")

      if (it) {
        clickNextButton()
        return
      }
    }

    // Call the model
    val data = model.fetchQuestionData()

    data?.let {
      viewModel.questionText = model.getCurrentQuestion(viewModel.quizIndex)

      viewModel.trueLabel = it.trueLabel
      viewModel.falseLabel = it.falseLabel
      viewModel.cheatLabel = it.cheatLabel
      viewModel.nextLabel = it.nextLabel

      // Call the view
      view?.get()?.displayQuestionData(viewModel)
    }
  }


  private fun fetchAnswerData(userAnswer: Boolean) {
    Log.d(TAG, "fetchAnswerData()")

    // Call the model
    val answer = model.getCurrentAnswer(viewModel.quizIndex)
    val data = model.fetchAnswerData()

    data?.let {
      if (answer == userAnswer) {
        viewModel.answerText = it.correctLabel
      } else {
        viewModel.answerText = it.incorrectLabel
      }

      viewModel.trueEnabled = false
      viewModel.falseEnabled = false
      viewModel.cheatEnabled = false
      viewModel.nextEnabled = true

      // Call the view
      view?.get()?.displayQuestionData(viewModel)
    }

  }

  override fun clickNextButton() {
    Log.d(TAG, "clickNextButton()")

    viewModel.quizIndex++

    viewModel.questionText = model.getCurrentQuestion(viewModel.quizIndex)
    viewModel.answerText = ""

    viewModel.trueEnabled = true
    viewModel.falseEnabled = true
    viewModel.cheatEnabled = true
    viewModel.nextEnabled = false

    // Call the view
    view?.get()?.displayQuestionData(viewModel)
  }

  override fun clickCheatButton() {
    val answer = model.getCurrentAnswer(viewModel.quizIndex)

    router.passDataToCheatScreen(answer)
    router.navigateToCheatScreen()
  }

  override fun clickFalseButton() {
    fetchAnswerData(false)
  }

  override fun clickTrueButton() {
    fetchAnswerData(true)
  }


  companion object {
    const val TAG = "QuestionPresenter"
  }
}
