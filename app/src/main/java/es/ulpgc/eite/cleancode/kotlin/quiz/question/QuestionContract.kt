import es.ulpgc.eite.cleancode.kotlin.quiz.question.AnswerData
import es.ulpgc.eite.cleancode.kotlin.quiz.question.QuestionData
import es.ulpgc.eite.cleancode.kotlin.quiz.question.QuestionViewModel

interface QuestionContract {

    interface View {
        var presenter: QuestionContract.Presenter
        fun displayQuestionData(viewModel: QuestionViewModel)
    }

    interface Presenter {
        fun fetchQuestionData()
        fun clickNextButton()
        fun clickCheatButton()
        fun clickFalseButton()
        fun clickTrueButton()
    }

    interface Model {

        fun fetchQuestionData(): QuestionData
        fun getCurrentAnswer(index: Int): Boolean?
        fun fetchAnswerData() : AnswerData
        fun getCurrentQuestion(index: Int): String?
    }

    interface Router {
        fun getDataFromCheatScreen(): Boolean?
        fun navigateToCheatScreen()
        fun passDataToCheatScreen(answer: Boolean?)
    }
}