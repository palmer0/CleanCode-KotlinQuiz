package es.ulpgc.eite.cleancode.kotlin.quiz.question

import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import es.ulpgc.eite.cleancode.kotlin.quiz.app.AppMediator
import es.ulpgc.eite.cleancode.kotlin.quiz.cheat.CheatActivity
import java.lang.ref.WeakReference

class QuestionRouter : QuestionContract.Router {

  //var fragment: WeakReference<QuestionFragment>? = null
  //var activity: WeakReference<QuestionActivity>? = null
  var fragment: WeakReference<Fragment>? = null
  var activity: WeakReference<FragmentActivity>? = null

  private fun _passDataToCheatScreen(
    mediator: AppMediator,
    answer: Boolean?
  ) {
    mediator.answer = answer
  }


  override fun passDataToCheatScreen(answer: Boolean?) {
    activity?.get()?.let {
      _passDataToCheatScreen(it.application as AppMediator, answer)
    }

    fragment?.get()?.activity?.let {
      _passDataToCheatScreen(it.application as AppMediator, answer)
    }
  }


  private fun _getDataFromCheatScreen(mediator: AppMediator): Boolean? {
    val cheated = mediator.cheated
    mediator.cheated = null
    return cheated
  }

  override fun getDataFromCheatScreen(): Boolean? {
    activity?.get()?.let {
      return _getDataFromCheatScreen(it.application as AppMediator)
    }

    fragment?.get()?.activity?.let {
      return _getDataFromCheatScreen(it.application as AppMediator)
    }
  }


  private fun _navigateToCheatScreen(mediator: AppMediator) {
    val context = mediator.baseContext
    val intent = Intent(context, CheatActivity::class.java)
    context.startActivity(intent)
  }

  override fun navigateToCheatScreen() {
    activity?.get()?.let {
      _navigateToCheatScreen(it.application as AppMediator)
    }

    fragment?.get()?.activity?.let {
      _navigateToCheatScreen(it.application as AppMediator)
    }
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
