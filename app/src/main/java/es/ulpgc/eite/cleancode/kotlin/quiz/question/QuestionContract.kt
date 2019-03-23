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
    fun fetchResultData(): ResultData?
    fun getCurrentAnswer(): Boolean?
    fun getCurrentQuestion(): String?
    fun incrCurrentIndex()
    fun getCurrentIndex(): Int
    fun setCurrentIndex(index: Int)
    //fun getCurrentAnswer(index: Int): Boolean?
    //fun getCurrentQuestion(index: Int): String?
  }

  interface Router {
    fun getDataFromCheatScreen(): Boolean?
    fun navigateToCheatScreen()
    fun passDataToCheatScreen(answer: Boolean?)
  }
}