package es.ulpgc.eite.cleancode.kotlin.quiz.cheat

import android.support.v4.app.Fragment
import es.ulpgc.eite.cleancode.kotlin.quiz.AppMediator
import java.lang.ref.WeakReference

class CheatRouter {

    var fragment: WeakReference<CheatFragment>? = null
    var activity: WeakReference<CheatActivity>? = null

    fun passDataToNextScreen(text: String?) {
        //val mediator = activity?.get()?.application as AppMediator
        //mediator.text = text
    }

    fun passDataToQuestionScreen(cheated: Boolean?) {
        val mediator = activity?.get()?.application as AppMediator
        mediator.cheated = cheated
    }

    fun getDataFromQuestionScreen(): Boolean? {
        val mediator = activity?.get()?.application as AppMediator
        val answer = mediator.answer
        mediator.answer = null
        return answer
    }


    fun navigateToQuestionScreen() {
        activity?.get()?.finish()
    }

    fun navigateToNextScreen() {
        //val intent = Intent(activity?.get(), CheatActivity::class.java)
        //activity?.get()?.startActivity(intent)
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
        const val TAG = "CheatRouter"
    }
}
