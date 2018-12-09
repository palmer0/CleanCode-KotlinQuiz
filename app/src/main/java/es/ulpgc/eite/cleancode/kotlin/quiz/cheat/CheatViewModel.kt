package es.ulpgc.eite.cleancode.kotlin.quiz.cheat

import android.arch.lifecycle.ViewModel

class CheatViewModel : ViewModel() {

    //var text: String? = null

    var questionText: String? = null
    var answerText: String? = null
    //var answerCheated: Boolean? = null

    var yesLabel: String? = null
    var noLabel: String? = null
    var yesEnabled = true
    var noEnabled = true

}

