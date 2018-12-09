package es.ulpgc.eite.cleancode.kotlin.quiz

import android.app.Application

class AppMediator: Application() {

    var answer: Boolean? = null
    //var answerText: String? = null
    var cheated: Boolean? = null
}