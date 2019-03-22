package es.ulpgc.eite.cleancode.kotlin.quiz.cheat

import android.util.Log
import java.lang.ref.WeakReference

data class CheatViewModel(
  val questionText: String?, val answerText: String?,
  val yesLabel: String?, val noLabel: String?,
  val yesEnabled: Boolean, val noEnabled: Boolean
)


class CheatPresenter : CheatContract.Presenter {

  var view: WeakReference<CheatContract.View>? = null
  lateinit var state: CheatState
  lateinit var model: CheatContract.Model
  lateinit var router: CheatContract.Router

  override fun fetchCheatData() {
    Log.d(TAG, "fetchCheatData()")

    val data = model.fetchCheatData()

    data?.let {

      with(state) {
        questionText = it.questionText
        yesLabel = it.yesLabel
        noLabel = it.noLabel
      }

      // Call the view
      view?.get()?.displayCheatData(getViewModel())
    }


  }

  override fun clickYesButton() {
    Log.d(TAG, "clickYesButton()")

    val answer = router.getDataFromQuestionScreen()

    answer?.let {

      Log.d(TAG, "answer: $it")
      updateCheatData(it)

      router.passDataToQuestionScreen(true)
    }
  }


  private fun updateCheatData(answer: Boolean) {
    val data = model.fetchCheatData()

    data?.let {

      with(state) {

        if (answer) {
          answerText = it.trueLabel
        } else {
          answerText = it.falseLabel
        }

        yesEnabled = false
        noEnabled = false
      }

      // Call the view
      view?.get()?.displayCheatData(getViewModel())
    }
  }


  private fun getViewModel(): CheatViewModel {

    return CheatViewModel(
      state.questionText, state.answerText,
      state.yesLabel, state.noLabel,
      state.yesEnabled, state.noEnabled
    )
  }

  override fun clickNoButton() {
    router.passDataToQuestionScreen(false)
    router.navigateToQuestionScreen()
  }

  companion object {
    const val TAG = "CheatPresenter"
  }
}
