package es.ulpgc.eite.cleancode.kotlin.quiz.cheat

import android.util.Log
import java.lang.ref.WeakReference

class CheatPresenter : CheatContract.Presenter {

    var view: WeakReference<CheatContract.View>? = null
    lateinit var viewModel: CheatViewModel
    lateinit var model: CheatContract.Model
    lateinit var router: CheatRouter

    override fun fetchCheatData() {
        // Log.d(TAG, "fetchCheatData()")

        // Call the model
        var text = model.fetchCheatData()
        Log.d(TAG, "text: $text")
        viewModel.text = text

        // Call the view
        view?.get()?.displayCheatData(viewModel)
    }

    companion object {
        const val TAG = "CheatPresenter"
    }
}
