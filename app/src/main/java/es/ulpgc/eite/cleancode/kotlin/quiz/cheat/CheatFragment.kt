package es.ulpgc.eite.cleancode.kotlin.quiz.cheat

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import es.ulpgc.eite.cleancode.kotlin.quiz.R
import kotlinx.android.synthetic.main.fragment_cheat.view.*

class CheatFragment : Fragment(), CheatContract.View {

  override lateinit var presenter: CheatContract.Presenter

  lateinit var rootView: View

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    // Inflate the layout for this fragment
    rootView = inflater.inflate(
      R.layout.fragment_cheat, container, false
    )

    with(rootView) {
      yesButton.setOnClickListener { presenter.clickYesButton() }
      noButton.setOnClickListener { presenter.clickNoButton() }
    }

    // Do the setup
    CheatScreen.configureFragment(this)

    // Call the presenter to fetch the data
    presenter.fetchCheatData()


    return rootView
  }


  override fun displayCheatData(viewModel: CheatViewModel) {
    Log.d(TAG, "displayCheatData()")

    // Deal with the data, update the states, ui etc..
    with(rootView) {
      warningText.text = viewModel.warningText
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
