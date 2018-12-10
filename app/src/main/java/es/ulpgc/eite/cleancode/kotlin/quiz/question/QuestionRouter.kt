package es.ulpgc.eite.cleancode.kotlin.quiz.question

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import es.ulpgc.eite.cleancode.kotlin.quiz.app.AppMediator
import es.ulpgc.eite.cleancode.kotlin.quiz.cheat.CheatActivity
import java.lang.ref.WeakReference

class QuestionRouter {

    var fragment: WeakReference<QuestionFragment>? = null
    var activity: WeakReference<QuestionActivity>? = null


    private fun _passDataToCheatScreen(mediator: AppMediator, answer: Boolean?) {
        //val mediator = it.application as AppMediator
        mediator.answer = answer
    }

    fun passDataToCheatScreen(answer: Boolean?) {
        activity?.get()?.let {
            _passDataToCheatScreen(it.application as AppMediator, answer)

            /*
            val mediator = it.application as AppMediator
            mediator.answer = answer
            */
        }

        fragment?.get()?.activity?.let {
            _passDataToCheatScreen(it.application as AppMediator, answer)

            /*
            val mediator = it.application as AppMediator
            mediator.answer = answer
            */
        }
    }


    private fun _getDataFromCheatScreen(mediator: AppMediator): Boolean? {
        //val mediator = it.application as AppMediator
        val cheated = mediator.cheated
        mediator.cheated = null
        return cheated
    }


    fun getDataFromCheatScreen(): Boolean? {
        activity?.get()?.let {
            return _getDataFromCheatScreen(it.application as AppMediator)

            /*
            val mediator = it.application as AppMediator
            //return _getDataFromCheatScreen(mediator)
            val cheated = mediator.cheated
            mediator.cheated = null
            return cheated
            */
        }

        fragment?.get()?.activity?.let {
            return _getDataFromCheatScreen(it.application as AppMediator)

            /*
            val mediator = it.application as AppMediator
            //return _getDataFromCheatScreen(mediator)
            val cheated = mediator.cheated
            mediator.cheated = null
            return cheated
            */
        }

    }


    private fun _navigateToCheatScreen(mediator: AppMediator) {
        val context = mediator.baseContext
        val intent = Intent(context, CheatActivity::class.java)
        context.startActivity(intent)
    }

    fun navigateToCheatScreen() {

        activity?.get()?.let {
            _navigateToCheatScreen(it.application as AppMediator)

            /*
            val intent = Intent(it, CheatActivity::class.java)
            it.startActivity(intent)
            */
        }

        fragment?.get()?.activity?.let {
            _navigateToCheatScreen(it.application as AppMediator)

            /*
            val intent = Intent(it, CheatActivity::class.java)
            it.startActivity(intent)
            */
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
