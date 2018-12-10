package es.ulpgc.eite.cleancode.kotlin.quiz.question

import android.arch.lifecycle.ViewModelProviders
import java.lang.ref.WeakReference

object QuestionConfigurator {

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
}
