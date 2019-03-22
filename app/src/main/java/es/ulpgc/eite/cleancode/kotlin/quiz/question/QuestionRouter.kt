package es.ulpgc.eite.cleancode.kotlin.quiz.question

import android.content.Intent
import android.support.v4.app.FragmentActivity
import es.ulpgc.eite.cleancode.kotlin.quiz.app.AppMediator
import es.ulpgc.eite.cleancode.kotlin.quiz.cheat.CheatActivity
import java.lang.ref.WeakReference

class QuestionRouter : QuestionContract.Router {

  //var fragment: WeakReference<Fragment>? = null
  var activity: WeakReference<FragmentActivity>? = null

  private fun passDataToCheatScreen(
    mediator: AppMediator,
    answer: Boolean?
  ) {
    mediator.answer = answer
  }


  override fun passDataToCheatScreen(answer: Boolean?) {
    activity?.get()?.let {
      passDataToCheatScreen(it.application as AppMediator, answer)
    }

    /*
    fragment?.get()?.activity?.let {
      passDataToCheatScreen(it.application as AppMediator, answer)
    }
    */
  }


  private fun getDataFromCheatScreen(mediator: AppMediator): Boolean? {
    val cheated = mediator.cheated
    mediator.cheated = null
    return cheated
  }

  override fun getDataFromCheatScreen(): Boolean? {
    activity?.get()?.let {
      return getDataFromCheatScreen(it.application as AppMediator)
    }

    /*
    fragment?.get()?.activity?.let {
      return getDataFromCheatScreen(it.application as AppMediator)
    }
    */

    return null
  }


  private fun navigateToCheatScreen(mediator: AppMediator) {
    val context = mediator.baseContext
    val intent = Intent(context, CheatActivity::class.java)
    context.startActivity(intent)
  }

  override fun navigateToCheatScreen() {
    activity?.get()?.let {
      navigateToCheatScreen(it.application as AppMediator)
    }

    /*
    fragment?.get()?.activity?.let {
      navigateToCheatScreen(it.application as AppMediator)
    }
    */
  }


  /*
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
  */

  companion object {
    const val TAG = "QuestionRouter"
  }
}
