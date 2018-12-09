package es.ulpgc.eite.cleancode.kotlin.quiz.question

import android.arch.lifecycle.ViewModel

class QuestionViewModel : ViewModel() {

    var quizIndex = 0
    var questionText: String? = null
    var answerText: String? = null

    //lateinit var data: QuestionData

    //val questionLabel: String? = null
    //val answerLabel: String? = null
    var trueLabel: String? = null
    var falseLabel: String? = null
    var cheatLabel: String? = null
    var nextLabel: String? = null

    var trueEnabled = true
    var falseEnabled = true
    var cheatEnabled = true
    var nextEnabled = false
}

