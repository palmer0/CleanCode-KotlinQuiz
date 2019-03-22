package es.ulpgc.eite.cleancode.kotlin.quiz.cheat

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import es.ulpgc.eite.cleancode.kotlin.quiz.R
import kotlinx.android.synthetic.main.activity_cheat.*

class CheatActivity : AppCompatActivity(), CheatContract.View {

  override lateinit var presenter: CheatContract.Presenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_cheat)

    /*
    setContentView(R.layout.activity_cheat_fragment)

    if (savedInstanceState == null) {
      supportFragmentManager.beginTransaction()
        .replace(R.id.container, CheatFragment())
        .commitNow()
    }

    return
    */

    yesButton.setOnClickListener { presenter.clickYesButton() }
    noButton.setOnClickListener { presenter.clickNoButton() }

    // Do the setup
    CheatScreen.configureActivity(this)

    // Do some work
    fetchData()
  }

  fun fetchData() {

    // Call the presenter to fetch the data
    presenter.fetchCheatData()
  }

  override fun displayCheatData(viewModel: CheatViewModel) {
    Log.d(TAG, "displayCheatData()")

    // Deal with the data, update the states, ui etc..
    questionText.text = viewModel.questionText
    answerText.text = viewModel.answerText

    yesButton.text = viewModel.yesLabel
    noButton.text = viewModel.noLabel

    yesButton.isEnabled = viewModel.yesEnabled
    noButton.isEnabled = viewModel.noEnabled
  }

  /*
  override fun displayCheatData(state: CheatState) {
    Log.d(TAG, "displayCheatData()")

    // Deal with the data, update the states, ui etc..
    questionText.text = state.questionText
    answerText.text = state.answerText

    yesButton.text = state.yesLabel
    noButton.text = state.noLabel

    yesButton.isEnabled = state.yesEnabled
    noButton.isEnabled = state.noEnabled
  }
  */

  companion object {
    const val TAG = "CheatActivity"
  }
}
