package es.ulpgc.eite.cleancode.kotlin.quiz.question


interface QuestionContract {

  interface View {
    var presenter: QuestionContract.Presenter

    fun displayQuestionData(viewModel: QuestionViewModel)
    //fun displayQuestionData(state: QuestionState)
  }

  interface Presenter {
    fun fetchQuestionData()
    fun clickNextButton()
    fun clickCheatButton()
    fun clickFalseButton()
    fun clickTrueButton()
  }

  interface Model {

    fun fetchQuestionData(): QuestionData?
    fun getCurrentAnswer(index: Int): Boolean?
    fun fetchResultData(): ResultData?
    fun getCurrentQuestion(index: Int): String?
  }

  interface Router {
    fun getDataFromCheatScreen(): Boolean?
    fun navigateToCheatScreen()
    fun passDataToCheatScreen(answer: Boolean?)
  }
}