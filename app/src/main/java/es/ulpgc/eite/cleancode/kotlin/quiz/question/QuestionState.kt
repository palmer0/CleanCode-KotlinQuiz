package es.ulpgc.eite.cleancode.kotlin.quiz.question

import androidx.lifecycle.ViewModel


class QuestionState : ViewModel() {

  var quizIndex = 0

  var questionText: String? = null
  var resultText: String? = null

  var trueLabel: String? = null
  var falseLabel: String? = null
  var cheatLabel: String? = null
  var nextLabel: String? = null

  var trueEnabled = true
  var falseEnabled = true
  var cheatEnabled = true
  var nextEnabled = false
}

