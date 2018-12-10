package es.ulpgc.eite.cleancode.kotlin.quiz.cheat

import android.arch.lifecycle.ViewModelProviders
import java.lang.ref.WeakReference

object CheatConfigurator {

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
}
