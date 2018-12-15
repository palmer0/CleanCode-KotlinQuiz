package es.ulpgc.eite.cleancode.kotlin.quiz.cheat

interface CheatContract {

  interface View {
    var presenter: CheatContract.Presenter

    fun displayCheatData(viewModel: CheatViewModel)
  }

  interface Presenter {
    fun fetchCheatData()
    fun clickNoButton()
    fun clickYesButton()
  }

  interface Model {
    fun fetchCheatData(): CheatData
  }

  interface Router {
    //fun passDataToNextScreen(text: String?)
    //fun navigateToNextScreen()
    fun passDataToQuestionScreen(cheated: Boolean?)

    fun getDataFromQuestionScreen(): Boolean?
    fun navigateToQuestionScreen()
  }
}