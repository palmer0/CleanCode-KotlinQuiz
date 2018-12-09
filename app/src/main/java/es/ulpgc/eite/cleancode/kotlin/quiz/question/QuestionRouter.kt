package es.ulpgc.eite.cleancode.kotlin.quiz.question

import android.content.Intent
import java.lang.ref.WeakReference
import android.support.v4.app.Fragment
import es.ulpgc.eite.cleancode.kotlin.quiz.AppMediator
import es.ulpgc.eite.cleancode.kotlin.quiz.cheat.CheatActivity

class QuestionRouter {

    var fragment: WeakReference<QuestionFragment>? = null
    var activity: WeakReference<QuestionActivity>? = null

    fun passDataToCheatScreen(answerText: String?) {
        //val mediator: AppMediator = activity?.get()?.application as AppMediator
        val mediator = activity?.get()?.application as AppMediator
        mediator.answerText = answerText
    }

    fun getDataFromPreviousScreen(): String? {
        //val mediator = activity?.get()?.application as AppMediator
        //val text = mediator.text
        //return text

        return null
    }

    fun navigateToCheatScreen() {
        val intent = Intent(activity?.get(), CheatActivity::class.java)
        activity?.get()?.startActivity(intent)
    }

    fun determineNextScreen(position: Int): Fragment {
        // based on the position or some other data decide what is the next scene

        // return if (someCondition()) {
        //     OneFragment()
        // } else {
        //     TwoFragment()
        // }

        return Fragment()
    }

    fun navigateToNextScreen(position: Int) {
        val nextFragment = determineNextScreen(position)
        // Ask the activity to show the next fragment 
        // fragment?.get()?.activityListener?.startNextFragment(nextFragment)

    }

    companion object {
        const val TAG = "QuestionRouter"
    }
}
