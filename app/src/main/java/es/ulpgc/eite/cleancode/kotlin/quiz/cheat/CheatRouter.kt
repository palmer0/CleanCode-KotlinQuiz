package es.ulpgc.eite.cleancode.kotlin.quiz.cheat

import androidx.fragment.app.FragmentActivity
import es.ulpgc.eite.cleancode.kotlin.quiz.app.AppMediator
import java.lang.ref.WeakReference

class CheatRouter : CheatContract.Router {

  //var fragment: WeakReference<Fragment>? = null
  var activity: WeakReference<FragmentActivity>? = null

  private fun passDataToQuestionScreen(mediator: AppMediator, cheated: Boolean?) {

    mediator.cheated = cheated
  }

  override fun passDataToQuestionScreen(cheated: Boolean?) {

    activity?.get()?.let {
      passDataToQuestionScreen(it.application as AppMediator, cheated)
    }

    /*
    fragment?.get()?.activity?.let {
      passDataToQuestionScreen(it.application as AppMediator, cheated)
    }
    */
  }

  private fun getDataFromQuestionScreen(mediator: AppMediator): Boolean? {
    val answer = mediator.answer
    mediator.answer = null
    return answer
  }


  override fun getDataFromQuestionScreen(): Boolean? {
    activity?.get()?.let {
      return getDataFromQuestionScreen(it.application as AppMediator)
    }

    /*
    fragment?.get()?.activity?.let {
      return getDataFromQuestionScreen(it.application as AppMediator)
    }
    */

    return null
  }


  override fun navigateToQuestionScreen() {
    activity?.get()?.let {
      it.finish()
    }

    /*
    fragment?.get()?.activity?.let {
      it.finish()
    }
    */
  }


  /*
  fun passDataToNextScreen(text: String?) {
    //val mediator = activity?.get()?.application as AppMediator
    //mediator.text = text
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
  */

  companion object {
    const val TAG = "CheatRouter"
  }
}
