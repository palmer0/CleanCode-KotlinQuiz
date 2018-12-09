package es.ulpgc.eite.cleancode.kotlin.quiz.cheat

import android.content.Intent
import java.lang.ref.WeakReference
import android.support.v4.app.Fragment

class CheatRouter {

    var fragment: WeakReference<CheatFragment>? = null
    var activity: WeakReference<CheatActivity>? = null

    fun passDataToNextScreen(text: String?) {
        //val mediator = activity?.get()?.application as AppMediator
        //mediator.text = text
    }

    fun getDataFromPreviousScreen(): String? {
        //val mediator = activity?.get()?.application as AppMediator
        //val text = mediator.text
        //return text

        return null
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
