package es.ulpgc.eite.cleancode.kotlin.quiz.question

import QuestionContract
import es.ulpgc.eite.cleancode.kotlin.quiz.R
import java.lang.ref.WeakReference

data class QuestionData(
    val trueLabel: String?, val falseLabel: String?,
    val cheatLabel: String?, val nextLabel: String?
)

data class AnswerData(
    val correctLabel: String?, val incorrectLabel: String?
)

class QuestionModel(
    var activity: WeakReference<QuestionActivity>? = null,
    var fragment: WeakReference<QuestionFragment>? = null
) : QuestionContract.Model {


    override fun fetchQuestionData() : QuestionData {
        // Log.d(TAG, "fetchQuestionData()")

        var falseLabel =
            activity?.get()?.resources?.getString(R.string.false_label)
        var trueLabel =
            activity?.get()?.resources?.getString(R.string.true_label)
        var nextLabel =
            activity?.get()?.resources?.getString(R.string.next_label)
        var cheatLabel =
            activity?.get()?.resources?.getString(R.string.cheat_label)

        return QuestionData(trueLabel, falseLabel, cheatLabel, nextLabel)
    }


    override fun fetchAnswerData() : AnswerData {

        var correctLabel =
            activity?.get()?.resources?.getString(R.string.correct_label)
        var incorrectLabel =
            activity?.get()?.resources?.getString(R.string.incorrect_label)

        return AnswerData(correctLabel, incorrectLabel)
    }

    override fun getCurrentAnswer(index: Int): Boolean? {
        val answers =
            activity?.get()?.resources?.getStringArray(R.array.answers)

        return answers?.get(index)?.toBoolean()
    }

    override fun getCurrentQuestion(index: Int): String? {
        val questions =
            activity?.get()?.resources?.getStringArray(R.array.questions)

        return questions?.get(index)
    }

    companion object {
        const val TAG = "QuestionModel"
    }
}
