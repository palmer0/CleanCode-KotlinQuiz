package es.ulpgc.eite.cleancode.kotlin.quiz.cheat

import CheatContract
import es.ulpgc.eite.cleancode.kotlin.quiz.R
import java.lang.ref.WeakReference

data class CheatData(
    val questionText: String?,
    val trueLabel: String?, val falseLabel: String?,
    val yesLabel: String?, val noLabel: String?
)

class CheatModel(
    var activity: WeakReference<CheatActivity>? = null,
    var fragment: WeakReference<CheatFragment>? = null
) : CheatContract.Model {


    override fun fetchCheatData() : CheatData {
        // Log.d(TAG, "fetchQuestionData()")

        var noLabel =
            activity?.get()?.resources?.getString(R.string.no_label)
        var yesLabel =
            activity?.get()?.resources?.getString(R.string.yes_label)
        var falseLabel =
            activity?.get()?.resources?.getString(R.string.false_label)
        var trueLabel =
            activity?.get()?.resources?.getString(R.string.true_label)
        var questionText =
            activity?.get()?.resources?.getString(R.string.question)

        return CheatData(questionText, trueLabel, falseLabel, yesLabel, noLabel)


    }

    /*
    override fun fetchCheatData(): String? {
        // Log.d(TAG, "fetchCheatData()")

        var text = "Hello"
        //var text = fragment?.get()?.resources?.getString(R.string.text)
        //var text = activity?.get()?.resources?.getString(R.string.text)
        Log.d(TAG, "text: $text")

        return text
    }
    */

    companion object {
        const val TAG = "CheatModel"
    }
}
