package es.ulpgc.eite.cleancode.kotlin.quiz.cheat

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.ulpgc.eite.cleancode.kotlin.quiz.R
import kotlinx.android.synthetic.main.fragment_cheat.view.*

class CheatFragment : Fragment(), CheatContract.View {

  override lateinit var presenter: CheatContract.Presenter

  lateinit var rootView: View

  /*
  lateinit var yesButton: Button
  lateinit var noButton: Button
  lateinit var questionText: TextView
  lateinit var answerText: TextView
  */

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    // Inflate the layout for this fragment
    rootView = inflater.inflate(
      R.layout.fragment_cheat, container, false
    )

    /*
    yesButton = rootView.findViewById(R.id.yesButton)
    noButton = rootView.findViewById(R.id.noButton)
    questionText = rootView.findViewById(R.id.questionText)
    answerText = rootView.findViewById(R.id.answerText)
    */

    with(rootView) {
      yesButton.setOnClickListener { presenter.clickYesButton() }
      noButton.setOnClickListener { presenter.clickNoButton() }
    }

    // Do the setup
    CheatScreen.configureFragment(this)

    // Do some work
    fetchData()

    return rootView
  }

  fun fetchData() {

    // Call the presenter to fetch the data
    presenter.fetchCheatData()
  }


  override fun displayCheatData(viewModel: CheatViewModel) {
    Log.d(TAG, "displayCheatData()")

    // Deal with the data, update the states, ui etc..
    with(rootView) {
      questionText.text = viewModel.questionText
      answerText.text = viewModel.answerText

      yesButton.text = viewModel.yesLabel
      noButton.text = viewModel.noLabel

      yesButton.isEnabled = viewModel.yesEnabled
      noButton.isEnabled = viewModel.noEnabled
    }
  }

  companion object {
    const val TAG = "CheatFragment"
  }
}
