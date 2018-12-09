package es.ulpgc.eite.cleancode.kotlin.quiz.cheat

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import es.ulpgc.eite.cleancode.kotlin.quiz.R

class CheatFragment : Fragment(), CheatContract.View {

    lateinit var presenter: CheatContract.Presenter
    lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        rootView = inflater.inflate(
            R.layout.fragment_cheat, container, false
        )

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
        // Log.d(TAG, "text = $viewModel.text")
        val textView = rootView.findViewById<TextView>(R.id.questionText)
        textView.text = viewModel.text
    }

    companion object {
        const val TAG = "CheatFragment"
    }
}
