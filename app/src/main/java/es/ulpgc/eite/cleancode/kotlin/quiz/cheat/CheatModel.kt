package es.ulpgc.eite.cleancode.kotlin.quiz.cheat

import android.content.res.Resources
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.util.Log
import es.ulpgc.eite.cleancode.kotlin.quiz.R
import java.lang.ref.WeakReference

data class CheatData(
  val questionText: String?,
  val trueLabel: String?, val falseLabel: String?,
  val yesLabel: String?, val noLabel: String?
)

class CheatModel(
  //var activity: WeakReference<CheatActivity>? = null,
  //var fragment: WeakReference<CheatFragment>? = null
  var fragment: WeakReference<Fragment>? = null,
  var activity: WeakReference<FragmentActivity>? = null
) : CheatContract.Model {


  override fun fetchCheatData(): CheatData {
    Log.d(TAG, "fetchCheatData()")

    activity?.get()?.resources?.let {
      return _fetchCheatData(it)
    }

    fragment?.get()?.resources?.let {
      return _fetchCheatData(it)
    }
  }

  private fun _fetchCheatData(resources: Resources): CheatData {
    var falseLabel = resources.getString(R.string.false_label)
    var trueLabel = resources.getString(R.string.true_label)
    var noLabel = resources.getString(R.string.no_label)
    var yesLabel = resources.getString(R.string.yes_label)
    var questionText = resources.getString(R.string.question)

    return CheatData(
      questionText, trueLabel, falseLabel, yesLabel, noLabel
    )
  }

  companion object {
    const val TAG = "CheatModel"
  }
}
