package es.ulpgc.eite.cleancode.kotlin.quiz.cheat

import CheatContract
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import es.ulpgc.eite.cleancode.kotlin.quiz.R

class CheatFragment : Fragment(), CheatContract.View {

    lateinit var presenter: CheatContract.Presenter

    lateinit var yesButton: Button
    lateinit var noButton: Button
    lateinit var questionText: TextView
    lateinit var answerText: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val rootView = inflater.inflate(
            R.layout.fragment_cheat, container, false
        )

        yesButton = rootView.findViewById(R.id.trueButton)
        noButton = rootView.findViewById(R.id.falseButton)
        questionText = rootView.findViewById(R.id.questionText)
        answerText = rootView.findViewById(R.id.answerText)

        yesButton.setOnClickListener { presenter.clickYesButton() }
        noButton.setOnClickListener { presenter.clickNoButton() }

        // Do the setup
        CheatConfigurator.configureFragment(this)

        // Do some work
        fetchData()

        return rootView
    }

    fun fetchData() {

        // Call the presenter to fetch the data
        presenter.fetchCheatData()
    }

    override fun displayCheatData(viewModel: CheatViewModel) {
        // Log.d(TAG, "displayCheatData()")

        // Deal with the data, update the states, ui etc..
        questionText.text = viewModel.questionText
        answerText.text = viewModel.answerText

        yesButton.text = viewModel.yesLabel
        noButton.text = viewModel.noLabel

        yesButton.isEnabled = viewModel.yesEnabled
        noButton.isEnabled = viewModel.noEnabled
    }

    companion object {
        const val TAG = "CheatFragment"
    }
}
