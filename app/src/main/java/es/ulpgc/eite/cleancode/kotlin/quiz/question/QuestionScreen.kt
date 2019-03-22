package es.ulpgc.eite.cleancode.kotlin.quiz.question

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.FragmentActivity
import java.lang.ref.WeakReference

object QuestionScreen {

  fun configureActivity(view: QuestionContract.View) {

    val activity = view as FragmentActivity

    val router = QuestionRouter()
    router.activity = WeakReference(activity)

    val presenter = QuestionPresenter()
    presenter.view = WeakReference(view)
    presenter.router = router

    presenter.state = ViewModelProviders
      .of(activity)
      .get(QuestionState::class.java)

    val model = QuestionModel(activity = WeakReference(activity))
    presenter.model = model

    view.presenter = presenter

  }


  fun configureFragment(view: QuestionContract.View) {

    /*
    val fragment = view as Fragment

    val router = QuestionRouter()
    router.fragment = WeakReference(fragment)

    val presenter = QuestionPresenter()
    presenter.view = WeakReference(view)
    presenter.router = router

    presenter.state = ViewModelProviders
      .of(fragment)
      .get(QuestionState::class.java)

    val model = QuestionModel(fragment = WeakReference(fragment))
    presenter.model = model

    view.presenter = presenter
    */

  }


}
