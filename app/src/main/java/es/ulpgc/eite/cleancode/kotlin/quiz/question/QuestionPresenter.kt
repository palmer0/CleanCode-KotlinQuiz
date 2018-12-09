package es.ulpgc.eite.cleancode.kotlin.quiz.question

import java.lang.ref.WeakReference

class QuestionPresenter : QuestionContract.Presenter {

    var view: WeakReference<QuestionContract.View>? = null
    lateinit var viewModel: QuestionViewModel
    lateinit var model: QuestionContract.Model
    lateinit var router: QuestionRouter

    override fun fetchQuestionData() {
        // Log.d(TAG, "fetchQuestionData()")

        // Call the model
        val data = model.fetchQuestionData()
        //val data = model.fetchQuestionData(viewModel.quizIndex)
        //viewModel.data = model.fetchQuestionData(viewModel.quizIndex)
        //viewModel.questionText = data.questionText
        viewModel.questionText = model.getCurrentQuestion(viewModel.quizIndex)
        //viewModel.answerText = data.answerText

        viewModel.trueLabel = data.trueLabel
        viewModel.falseLabel = data.falseLabel
        viewModel.cheatLabel = data.cheatLabel
        viewModel.nextLabel = data.nextLabel


        /*
        var questionText = model.fetchQuestionData()
        Log.d(TAG, "questionText: $questionText")
        viewModel.questionText = questionText
        */

        // Call the view
        view?.get()?.displayQuestionData(viewModel)
    }


    private fun fetchAnswerData(userAnswer: Boolean) {
        // Log.d(TAG, "fetchAnswerData()")

        // Call the model
        val answer = model.getCurrentAnswer(viewModel.quizIndex)
        val data = model.fetchAnswerData()

        if (answer == userAnswer) {
            viewModel.answerText = data.correctLabel
        } else {
            viewModel.answerText = data.incorrectLabel
        }

        viewModel.trueEnabled = false
        viewModel.falseEnabled = false
        viewModel.cheatEnabled = false
        viewModel.nextEnabled = true

        // Call the view
        view?.get()?.displayQuestionData(viewModel)
    }

    override fun clickNextButton() {
        viewModel.quizIndex++

        viewModel.questionText = model.getCurrentQuestion(viewModel.quizIndex)
        viewModel.answerText = ""

        viewModel.trueEnabled = true
        viewModel.falseEnabled = true
        viewModel.cheatEnabled = true
        viewModel.nextEnabled = false

        // Call the view
        view?.get()?.displayQuestionData(viewModel)
    }

    override fun clickCheatButton() {
        router.passDataToCheatScreen(viewModel.answerText)
        router.navigateToCheatScreen()
    }

    override fun clickFalseButton() {
        fetchAnswerData(false)

    }

    override fun clickTrueButton() {
        fetchAnswerData(true)

    }


    companion object {
        const val TAG = "QuestionPresenter"
    }
}
