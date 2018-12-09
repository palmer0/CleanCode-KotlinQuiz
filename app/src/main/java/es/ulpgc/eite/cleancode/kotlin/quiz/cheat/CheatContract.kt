
import es.ulpgc.eite.cleancode.kotlin.quiz.cheat.CheatData
import es.ulpgc.eite.cleancode.kotlin.quiz.cheat.CheatViewModel

interface CheatContract {

    interface View {
        fun displayCheatData(viewModel: CheatViewModel)
    }

    interface Presenter {
        fun fetchCheatData()
        fun clickNoButton()
        fun clickYesButton()
    }

    interface Model {
        //fun fetchCheatData(): String?
        fun fetchCheatData() : CheatData
    }
}