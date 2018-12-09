package es.ulpgc.eite.cleancode.kotlin.quiz.cheat

import android.util.Log
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import es.ulpgc.eite.cleancode.kotlin.quiz.R

class CheatActivity : AppCompatActivity(), CheatContract.View {

    lateinit var presenter: CheatContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CheatFragment())
                .commitNow()
        }

        // Do the setup
        //CheatConfigurator.configureActivity(this)

        // Do some work
        //fetchData()
    }

    fun fetchData() {

        // Call the presenter to fetch the data
        presenter.fetchCheatData()
    }

    override fun displayCheatData(viewModel: CheatViewModel) {
        // Log.d(TAG, "displayCheatData()")

        // Deal with the data, update the states, ui etc..
        // Log.d(TAG, "text = $viewModel.text")
        //val textView = findViewById<TextView>(R.id.text)
        //textView.text = viewModel.text
    }

    companion object {
        const val TAG = "CheatActivity"
    }
}
