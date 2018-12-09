import es.ulpgc.eite.cleancode.kotlin.quiz.cheat.CheatViewModel

interface CheatContract {

    interface View {
        fun displayCheatData(viewModel: CheatViewModel)
    }

    interface Presenter {
        fun fetchCheatData()
    }

    interface Model {
        fun fetchCheatData(): String?
    }
}