package es.ulpgc.eite.cleancode.kotlin.quiz.question

import android.content.Intent
import android.support.v4.app.Fragment
import es.ulpgc.eite.cleancode.kotlin.quiz.AppMediator
import es.ulpgc.eite.cleancode.kotlin.quiz.cheat.CheatActivity
import java.lang.ref.WeakReference

class QuestionRouter {

    var fragment: WeakReference<QuestionFragment>? = null
    var activity: WeakReference<QuestionActivity>? = null


    fun passDataToCheatScreen(answer: Boolean?) {
        activity?.get()?.let {
            val mediator = it.application as AppMediator
            mediator.answer = answer
        }

        /*
        val mediator = activity?.get()?.application as AppMediator
        mediator.answer = answer
        */

        fragment?.get()?.activity?.let {
            val mediator = it.application as AppMediator
            mediator.answer = answer
        }
    }

    fun getDataFromCheatScreen(): Boolean? {
        activity?.get()?.let {
            val mediator = it.application as AppMediator
            val cheated = mediator.cheated
            mediator.cheated = null
            return cheated
        }

        fragment?.get()?.activity?.let {
            val mediator = it.application as AppMediator
            val cheated = mediator.cheated
            mediator.cheated = null
            return cheated
        }

        /*
        val mediator = activity?.get()?.application as AppMediator
        val cheated = mediator.cheated
        mediator.cheated = null
        return cheated
        */
    }

    fun navigateToCheatScreen() {

        activity?.get()?.let {
            val intent = Intent(it, CheatActivity::class.java)
            it.startActivity(intent)
        }

        /*
        val intent = Intent(activity?.get(), CheatActivity::class.java)
        activity?.get()?.startActivity(intent)
        */

        fragment?.get()?.activity?.let {
            val intent = Intent(it, CheatActivity::class.java)
            it.startActivity(intent)
        }

        /*
        fragment?.get()?.let {
            it.childFragmentManager.beginTransaction()
                .replace(R.id.container, QuestionFragment())
                .commitNow()
        }
        */

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
