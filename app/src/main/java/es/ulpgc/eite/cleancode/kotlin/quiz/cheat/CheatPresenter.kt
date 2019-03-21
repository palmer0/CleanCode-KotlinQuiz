package es.ulpgc.eite.cleancode.kotlin.quiz.cheat

import android.util.Log
import java.lang.ref.WeakReference

class CheatPresenter : CheatContract.Presenter {

  var view: WeakReference<CheatContract.View>? = null
  lateinit var viewModel: CheatViewModel
  lateinit var model: CheatContract.Model
  lateinit var router: CheatContract.Router

  override fun fetchCheatData() {
    Log.d(TAG, "fetchCheatData()")

    val data = model.fetchCheatData()

    data?.let {

      with(viewModel) {
        questionText = it.questionText
        yesLabel = it.yesLabel
        noLabel = it.noLabel
      }

      // Call the view
      view?.get()?.displayCheatData(viewModel)
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

      with(viewModel) {

        if (answer) {
          answerText = it.trueLabel
        } else {
          answerText = it.falseLabel
        }

        yesEnabled = false
        noEnabled = false
      }

      // Call the view
      view?.get()?.displayCheatData(viewModel)
    }
  }


  override fun clickNoButton() {
    router.passDataToQuestionScreen(false)
    router.navigateToQuestionScreen()
  }

  companion object {
    const val TAG = "CheatPresenter"
  }
}
