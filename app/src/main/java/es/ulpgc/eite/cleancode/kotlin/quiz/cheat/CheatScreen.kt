package es.ulpgc.eite.cleancode.kotlin.quiz.cheat

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import java.lang.ref.WeakReference

object CheatScreen {
  fun configureActivity(view: CheatContract.View) {

    val activity = view as FragmentActivity

    val router = CheatRouter()
    router.activity = WeakReference(activity)

    val presenter = CheatPresenter()
    presenter.view = WeakReference(view)
    presenter.router = router

    presenter.viewModel = ViewModelProviders
      .of(activity)
      .get(CheatViewModel::class.java)

    val model = CheatModel(activity = WeakReference(activity))
    presenter.model = model

    view.presenter = presenter

  }


  fun configureFragment(view: CheatContract.View) {

    val fragment = view as Fragment

    val router = CheatRouter()
    router.fragment = WeakReference(fragment)

    val presenter = CheatPresenter()
    presenter.view = WeakReference(view)
    presenter.router = router

    presenter.viewModel = ViewModelProviders
      .of(fragment)
      .get(CheatViewModel::class.java)

    val model = CheatModel(fragment = WeakReference(fragment))
    presenter.model = model

    view.presenter = presenter

  }

  /*
  fun configureActivity(activity: CheatActivity) {

      val router = CheatRouter()
      router.activity = WeakReference(activity)

      val presenter = CheatPresenter()
      presenter.view = WeakReference(activity)
      presenter.router = router

      presenter.viewModel = ViewModelProviders
          .of(activity)
          .get(CheatViewModel::class.java)

      val model = CheatModel(activity = WeakReference(activity))
      presenter.model = model

      activity.presenter = presenter

  }

  fun configureFragment(fragment: CheatFragment) {

      val router = CheatRouter()
      router.fragment = WeakReference(fragment)

      val presenter = CheatPresenter()
      presenter.view = WeakReference(fragment)
      presenter.router = router

      presenter.viewModel = ViewModelProviders
          .of(fragment)
          .get(CheatViewModel::class.java)

      val model = CheatModel(fragment = WeakReference(fragment))
      presenter.model = model

      fragment.presenter = presenter

  }
  */

}
