package es.ulpgc.eite.cleancode.kotlin.quiz.app

import android.app.Application

class AppMediator: Application() {

    var answer: Boolean? = null
    var cheated: Boolean? = null
}