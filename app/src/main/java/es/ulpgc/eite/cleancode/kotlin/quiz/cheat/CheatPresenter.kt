package es.ulpgc.eite.cleancode.kotlin.quiz.cheat

import CheatContract
import android.util.Log
import java.lang.ref.WeakReference

class CheatPresenter : CheatContract.Presenter {

    var view: WeakReference<CheatContract.View>? = null
    lateinit var viewModel: CheatViewModel
    lateinit var model: CheatContract.Model
    lateinit var router: CheatRouter

    override fun fetchCheatData() {
        Log.d(TAG, "fetchCheatData()")

        val data = model.fetchCheatData()

        viewModel.questionText = data.questionText
        viewModel.yesLabel = data.yesLabel
        viewModel.noLabel = data.noLabel

        // Call the view
        view?.get()?.displayCheatData(viewModel)
    }

    override fun clickYesButton() {
        Log.d(TAG, "clickYesButton()")

        val answer = router.getDataFromQuestionScreen()

        answer?.let {

            Log.d(TAG, "answer: $answer")
            updateCheatData(answer)

            router.passDataToQuestionScreen(true)

            /*
            val data = model.fetchCheatData()

            if (answer) {
                viewModel.answerText = data.trueLabel
            } else {
                viewModel.answerText = data.falseLabel
            }

            viewModel.yesEnabled = false
            viewModel.noEnabled = false

            // Call the view
            view?.get()?.displayCheatData(viewModel)
            */
        }
    }

    private fun updateCheatData(answer: Boolean) {
        val data = model.fetchCheatData()

        if (answer) {
            viewModel.answerText = data.trueLabel
        } else {
            viewModel.answerText = data.falseLabel
        }

        viewModel.yesEnabled = false
        viewModel.noEnabled = false

        // Call the view
        view?.get()?.displayCheatData(viewModel)
    }

    override fun clickNoButton() {
        router.passDataToQuestionScreen(false)
        router.navigateToQuestionScreen()
    }

    companion object {
        const val TAG = "CheatPresenter"
    }
}
