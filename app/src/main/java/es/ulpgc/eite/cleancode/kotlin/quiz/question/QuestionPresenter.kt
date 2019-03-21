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

      with(viewModel) {

        questionText = model.getCurrentQuestion(viewModel.quizIndex)

        trueLabel = it.trueLabel
        falseLabel = it.falseLabel
        cheatLabel = it.cheatLabel
        nextLabel = it.nextLabel
      }

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

      with(viewModel) {

        if (answer == userAnswer) {
          answerText = it.correctLabel
        } else {
          answerText = it.incorrectLabel
        }

        trueEnabled = false
        falseEnabled = false
        cheatEnabled = false
        nextEnabled = true
      }

      // Call the view
      view?.get()?.displayQuestionData(viewModel)
    }

  }

  override fun clickNextButton() {
    Log.d(TAG, "clickNextButton()")

    with(viewModel) {

      quizIndex++

      questionText = model.getCurrentQuestion(viewModel.quizIndex)
      answerText = ""

      trueEnabled = true
      falseEnabled = true
      cheatEnabled = true
      nextEnabled = false
    }

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
