package es.ulpgc.eite.cleancode.kotlin.quiz.question

import android.util.Log
import java.lang.ref.WeakReference


data class QuestionViewModel(
  val questionText: String?, val resultText: String?,
  val trueLabel: String?, val falseLabel: String?,
  val cheatLabel: String?, val nextLabel: String?,
  val trueEnabled: Boolean, val falseEnabled: Boolean,
  val cheatEnabled: Boolean, val nextEnabled: Boolean
)


class QuestionPresenter : QuestionContract.Presenter {

  var view: WeakReference<QuestionContract.View>? = null
  lateinit var state: QuestionState
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

      with(state) {

        model.setCurrentIndex(quizIndex)

        //warningText = model.getCurrentQuestion(state.quizIndex)
        questionText = model.getCurrentQuestion()

        trueLabel = it.trueLabel
        falseLabel = it.falseLabel
        cheatLabel = it.cheatLabel
        nextLabel = it.nextLabel
      }

      // Call the view
      view?.get()?.displayQuestionData(getScreenData())
    }
  }


  private fun fetchAnswerData(userAnswer: Boolean) {
    Log.d(TAG, "fetchResultData()")

    // Call the model
    val answer = model.getCurrentAnswer()
    //val answer = model.getCurrentAnswer(state.quizIndex)
    val data = model.fetchResultData()

    data?.let {

      with(state) {

        if (answer == userAnswer) {
          resultText = it.correctLabel
        } else {
          resultText = it.incorrectLabel
        }

        trueEnabled = false
        falseEnabled = false
        cheatEnabled = false
        nextEnabled = true
      }

      // Call the view
      view?.get()?.displayQuestionData(getScreenData())
    }

  }

  override fun clickNextButton() {
    Log.d(TAG, "clickNextButton()")

    model.incrCurrentIndex()

    with(state) {

      //quizIndex++
      quizIndex = model.getCurrentIndex()

      //warningText = model.getCurrentQuestion(state.quizIndex)
      questionText = model.getCurrentQuestion()
      resultText = ""

      trueEnabled = true
      falseEnabled = true
      cheatEnabled = true
      nextEnabled = false
    }

    // Call the view
    view?.get()?.displayQuestionData(getScreenData())
  }


  private fun getScreenData(): QuestionViewModel {

    return QuestionViewModel(
      state.questionText, state.resultText,
      state.trueLabel, state.falseLabel,
      state.cheatLabel, state.nextLabel,
      state.trueEnabled, state.falseEnabled,
      state.cheatEnabled, state.nextEnabled
    )
  }

  override fun clickCheatButton() {
    //val answer = model.getCurrentAnswer(state.quizIndex)
    val answer = model.getCurrentAnswer()

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
