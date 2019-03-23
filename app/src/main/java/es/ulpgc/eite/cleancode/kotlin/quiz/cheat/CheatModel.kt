package es.ulpgc.eite.cleancode.kotlin.quiz.cheat

import android.content.res.Resources
import android.support.v4.app.FragmentActivity
import android.util.Log
import es.ulpgc.eite.cleancode.kotlin.quiz.R
import java.lang.ref.WeakReference

data class CheatData(
  val warningText: String?,
  val trueLabel: String?, val falseLabel: String?,
  val yesLabel: String?, val noLabel: String?
)

class CheatModel(
  //var fragment: WeakReference<Fragment>? = null,
  var activity: WeakReference<FragmentActivity>? = null
) : CheatContract.Model {


  override fun fetchCheatData(): CheatData? {
    Log.d(TAG, "fetchCheatData()")

    activity?.get()?.resources?.let {
      return fetchCheatData(it)
    }

    /*
    fragment?.get()?.resources?.let {
      return fetchCheatData(it)
    }
    */

    return null
  }

  private fun fetchCheatData(resources: Resources): CheatData {
    var falseLabel = resources.getString(R.string.false_label)
    var trueLabel = resources.getString(R.string.true_label)
    var noLabel = resources.getString(R.string.no_label)
    var yesLabel = resources.getString(R.string.yes_label)
    var warningText = resources.getString(R.string.warning_text)

    return CheatData(
      warningText, trueLabel, falseLabel, yesLabel, noLabel
    )
  }

  companion object {
    const val TAG = "CheatModel"
  }
}
