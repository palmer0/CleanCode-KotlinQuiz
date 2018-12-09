package es.ulpgc.eite.cleancode.kotlin.quiz.cheat

import android.util.Log
import java.lang.ref.WeakReference
import es.ulpgc.eite.cleancode.kotlin.quiz.R

class CheatModel(
    var activity: WeakReference<CheatActivity>? = null,
    var fragment: WeakReference<CheatFragment>? = null
) : CheatContract.Model {

    override fun fetchCheatData(): String? {
        // Log.d(TAG, "fetchCheatData()")

        var text = "Hello"
        //var text = fragment?.get()?.resources?.getString(R.string.text)
        //var text = activity?.get()?.resources?.getString(R.string.text)
        Log.d(TAG, "text: $text")

        return text

    }

    companion object {
        const val TAG = "CheatModel"
    }
}
