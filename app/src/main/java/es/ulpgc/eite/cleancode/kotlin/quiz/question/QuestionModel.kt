package es.ulpgc.eite.cleancode.kotlin.quiz.question

import android.content.res.Resources
import android.support.v4.app.FragmentActivity
import android.util.Log
import es.ulpgc.eite.cleancode.kotlin.quiz.R
import java.lang.ref.WeakReference

data class QuestionData(
  val trueLabel: String?, val falseLabel: String?,
  val cheatLabel: String?, val nextLabel: String?
)

data class ResultData(
  val correctLabel: String?, val incorrectLabel: String?
)

class QuestionModel(
  //var fragment: WeakReference<Fragment>? = null,
  var activity: WeakReference<FragmentActivity>? = null
) : QuestionContract.Model {


  override fun fetchQuestionData(): QuestionData? {
    Log.d(TAG, "fetchQuestionData()")

    activity?.get()?.resources?.let {
      return fetchQuestionData(it)
    }

    /*
    fragment?.get()?.resources?.let {
      return fetchQuestionData(it)
    }
    */

    return null
  }

  override fun fetchResultData(): ResultData? {
    Log.d(TAG, "fetchResultData()")

    activity?.get()?.resources?.let {
      return fetchResultData(it)
    }

    /*
    fragment?.get()?.resources?.let {
      return fetchResultData(it)
    }
    */

    return null
  }

  private fun fetchQuestionData(resources: Resources): QuestionData {
    var falseLabel = resources.getString(R.string.false_label)
    var trueLabel = resources.getString(R.string.true_label)
    var nextLabel = resources.getString(R.string.next_label)
    var cheatLabel = resources.getString(R.string.cheat_label)

    return QuestionData(trueLabel, falseLabel, cheatLabel, nextLabel)
  }


  private fun fetchResultData(resources: Resources): ResultData {
    var correctLabel = resources.getString(R.string.correct_label)
    var incorrectLabel = resources.getString(R.string.incorrect_label)

    return ResultData(correctLabel, incorrectLabel)
  }

  override fun getCurrentAnswer(index: Int): Boolean? {
    activity?.get()?.resources?.let {
      return getCurrentAnswer(it, index)
    }

    /*
    fragment?.get()?.resources?.let {
      return getCurrentAnswer(it, index)
    }
    */

    return null
  }


  override fun getCurrentQuestion(index: Int): String? {
    activity?.get()?.resources?.let {
      return getCurrentQuestion(it, index)
    }

    /*
    fragment?.get()?.resources?.let {
      return getCurrentQuestion(it, index)
    }
    */

    return null
  }

  private fun getCurrentQuestion(resources: Resources, index: Int): String? {
    val questions = resources.getStringArray(R.array.questions)
    return questions.get(index)
  }

  private fun getCurrentAnswer(resources: Resources, index: Int): Boolean? {
    val answers = resources.getStringArray(R.array.answers)
    return answers.get(index)?.toBoolean()
  }

  companion object {
    const val TAG = "QuestionModel"
  }
}
