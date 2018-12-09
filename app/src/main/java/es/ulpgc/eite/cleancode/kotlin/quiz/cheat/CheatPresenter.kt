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
        // Log.d(TAG, "fetchCheatData()")

        val data = model.fetchCheatData()

        /*
        val answer = router.getDataFromQuestionScreen()

        answer?.let {
            if (answer) {
                viewModel.answerText = data.trueLabel
            } else {
                viewModel.answerText = data.falseLabel
            }
        }
        */

        viewModel.questionText = data.questionText
        viewModel.yesLabel = data.yesLabel
        viewModel.noLabel = data.noLabel

        // Call the view
        view?.get()?.displayCheatData(viewModel)
    }

    override fun clickNoButton() {
        router.passDataToQuestionScreen(false)
        router.navigateToQuestionScreen()
    }

    override fun clickYesButton() {

        val answer = router.getDataFromQuestionScreen()

        answer?.let {

            Log.d(TAG, "answer: $answer")

            //router.passDataToQuestionScreen(viewModel.answerCheated)
            router.passDataToQuestionScreen(true)

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
    }


    /*
    override fun fetchCheatData() {
        // Log.d(TAG, "fetchCheatData()")

        // Call the model
        var text = model.fetchCheatData()
        Log.d(TAG, "text: $text")
        viewModel.text = text

        // Call the view
        view?.get()?.displayCheatData(viewModel)
    }
    */

    /*
    override fun clickCheatButton() {
        router.passDataToCheatScreen(viewModel.answerText)
        router.navigateToCheatScreen()
    }
    */

    companion object {
        const val TAG = "CheatPresenter"
    }
}
