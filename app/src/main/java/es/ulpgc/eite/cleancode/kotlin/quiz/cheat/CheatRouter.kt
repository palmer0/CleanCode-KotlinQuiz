package es.ulpgc.eite.cleancode.kotlin.quiz.cheat

import android.support.v4.app.Fragment
import es.ulpgc.eite.cleancode.kotlin.quiz.app.AppMediator
import java.lang.ref.WeakReference

class CheatRouter {

    var fragment: WeakReference<CheatFragment>? = null
    var activity: WeakReference<CheatActivity>? = null

    fun passDataToNextScreen(text: String?) {
        //val mediator = activity?.get()?.application as AppMediator
        //mediator.text = text
    }

    private fun _passDataToQuestionScreen(
        mediator: AppMediator, cheated: Boolean?) {

        mediator.cheated = cheated
    }

    fun passDataToQuestionScreen(cheated: Boolean?) {

        activity?.get()?.let {
            _passDataToQuestionScreen(it.application as AppMediator, cheated)
            //val mediator = it.application as AppMediator
            //mediator.cheated = cheated
        }

        /*
        val mediator = activity?.get()?.application as AppMediator
        mediator.cheated = cheated
        */

        fragment?.get()?.activity?.let {
            _passDataToQuestionScreen(it.application as AppMediator, cheated)
        }
    }

    private fun _getDataFromQuestionScreen(mediator: AppMediator): Boolean? {
        //val mediator = it.application as AppMediator
        val answer = mediator.answer
        mediator.answer = null
        return answer
    }

    fun getDataFromQuestionScreen(): Boolean? {
        activity?.get()?.let {
            return _getDataFromQuestionScreen(it.application as AppMediator)

            /*
            val mediator = it.application as AppMediator
            val answer = mediator.answer
            mediator.answer = null
            return answer
            */
        }

        /*
        val mediator = activity?.get()?.application as AppMediator
        val answer = mediator.answer
        mediator.answer = null
        return answer
        */

        fragment?.get()?.activity?.let {
            return _getDataFromQuestionScreen(it.application as AppMediator)
        }
    }


    fun navigateToQuestionScreen() {
        //activity?.get()?.finish()

        activity?.get()?.let {
            it.finish()
        }

        fragment?.get()?.activity?.let {
            it.finish()
        }
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
