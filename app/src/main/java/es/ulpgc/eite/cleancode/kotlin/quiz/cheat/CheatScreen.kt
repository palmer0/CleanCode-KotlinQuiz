package es.ulpgc.eite.cleancode.kotlin.quiz.cheat

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import java.lang.ref.WeakReference

object CheatScreen {
  fun configureActivity(view: CheatContract.View) {

    val activity = view as FragmentActivity

    val router = CheatRouter()
    router.activity = WeakReference(activity)

    val presenter = CheatPresenter()
    presenter.view = WeakReference(view)
    presenter.router = router

    presenter.state = ViewModelProviders
      .of(activity)
      .get(CheatState::class.java)

    val model = CheatModel(activity = WeakReference(activity))
    presenter.model = model

    view.presenter = presenter

  }

  fun configureFragment(view: CheatContract.View) {

    /*
    val fragment = view as Fragment

    val router = CheatRouter()
    router.fragment = WeakReference(fragment)

    val presenter = CheatPresenter()
    presenter.view = WeakReference(view)
    presenter.router = router

    presenter.state = ViewModelProviders
      .of(fragment)
      .get(CheatState::class.java)

    val model = CheatModel(fragment = WeakReference(fragment))
    presenter.model = model

    view.presenter = presenter
    */
  }


}
