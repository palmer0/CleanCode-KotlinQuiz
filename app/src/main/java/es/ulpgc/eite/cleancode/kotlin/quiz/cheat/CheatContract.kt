package es.ulpgc.eite.cleancode.kotlin.quiz.cheat

interface CheatContract {

  interface View {
    var presenter: CheatContract.Presenter

    //fun displayCheatData(state: CheatState)
    fun displayCheatData(state: CheatViewModel)
  }

  interface Presenter {
    fun fetchCheatData()
    fun clickNoButton()
    fun clickYesButton()
  }

  interface Model {
    fun fetchCheatData(): CheatData?
  }

  interface Router {
    fun passDataToQuestionScreen(cheated: Boolean?)

    fun getDataFromQuestionScreen(): Boolean?
    fun navigateToQuestionScreen()
  }
}