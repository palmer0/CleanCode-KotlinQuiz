package es.ulpgc.eite.cleancode.kotlin.quiz.question

import QuestionContract
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import java.lang.ref.WeakReference

object QuestionScreen {

    /*
    fun configureActivity(activity: QuestionActivity) {

        val router = QuestionRouter()
        router.activity = WeakReference(activity)

        val presenter = QuestionPresenter()
        presenter.view = WeakReference(activity)
        presenter.router = router

        presenter.viewModel = ViewModelProviders
            .of(activity)
            .get(QuestionViewModel::class.java)

        val model = QuestionModel(activity = WeakReference(activity))
        presenter.model = model

        activity.presenter = presenter

    }
    */

    fun configureActivity(view: QuestionContract.View) {

        val activity = view as FragmentActivity

        val router = QuestionRouter()
        router.activity = WeakReference(activity)

        val presenter = QuestionPresenter()
        presenter.view = WeakReference(view)
        presenter.router = router

        presenter.viewModel = ViewModelProviders
            .of(activity)
            .get(QuestionViewModel::class.java)

        val model = QuestionModel(activity = WeakReference(activity))
        presenter.model = model

        view.presenter = presenter

    }


    fun configureFragment(view: QuestionContract.View) {

        val fragment = view as Fragment

        val router = QuestionRouter()
        router.fragment = WeakReference(fragment)

        val presenter = QuestionPresenter()
        presenter.view = WeakReference(view)
        presenter.router = router

        presenter.viewModel = ViewModelProviders
            .of(fragment)
            .get(QuestionViewModel::class.java)

        val model = QuestionModel(fragment = WeakReference(fragment))
        presenter.model = model

        view.presenter = presenter

    }

    /*
    fun configureFragment(fragment: QuestionFragment) {

        val router = QuestionRouter()
        router.fragment = WeakReference(fragment)

        val presenter = QuestionPresenter()
        presenter.view = WeakReference(fragment)
        presenter.router = router

        presenter.viewModel = ViewModelProviders
            .of(fragment)
            .get(QuestionViewModel::class.java)

        val model = QuestionModel(fragment = WeakReference(fragment))
        presenter.model = model

        fragment.presenter = presenter

    }
    */
}