package es.ulpgc.eite.cleancode.kotlin.quiz.cheat

import CheatContract
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import es.ulpgc.eite.cleancode.kotlin.quiz.R

class CheatActivity : AppCompatActivity(), CheatContract.View {

    lateinit var presenter: CheatContract.Presenter

    lateinit var yesButton: Button
    lateinit var noButton: Button
    lateinit var questionText: TextView
    lateinit var answerText: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)

        /*
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CheatFragment())
                .commitNow()
        }
        */

        yesButton = findViewById(R.id.trueButton)
        noButton = findViewById(R.id.falseButton)
        questionText = findViewById(R.id.questionText)
        answerText = findViewById(R.id.answerText)

        yesButton.setOnClickListener { presenter.clickYesButton() }
        noButton.setOnClickListener { presenter.clickNoButton() }

        // Do the setup
        CheatConfigurator.configureActivity(this)

        // Do some work
        fetchData()
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

        questionText.text = viewModel.questionText
        answerText.text = viewModel.answerText

        yesButton.text = viewModel.yesLabel
        noButton.text = viewModel.noLabel

        yesButton.isEnabled = viewModel.yesEnabled
        noButton.isEnabled = viewModel.noEnabled
    }

    companion object {
        const val TAG = "CheatActivity"
    }
}
