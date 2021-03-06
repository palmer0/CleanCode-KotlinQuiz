package es.ulpgc.eite.cleancode.kotlin.quiz.cheat

import androidx.lifecycle.ViewModel


class CheatState : ViewModel() {

  var warningText: String? = null
  var answerText: String? = null

  var yesLabel: String? = null
  var noLabel: String? = null

  var yesEnabled = true
  var noEnabled = true

}

