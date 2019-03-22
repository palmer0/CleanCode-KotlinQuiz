package es.ulpgc.eite.cleancode.kotlin.quiz.cheat

import android.arch.lifecycle.ViewModel

class CheatState : ViewModel() {

  var questionText: String? = null
  var answerText: String? = null

  var yesLabel: String? = null
  var noLabel: String? = null

  var yesEnabled = true
  var noEnabled = true

}

