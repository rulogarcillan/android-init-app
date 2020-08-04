package com.tuppersoft.squeleton.features.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.tuppersoft.skizo.core.logger.SkizoLog

/**
 * Created by Raúl Rodríguez Concepción on 22/05/2020.
 * Talento Mobile
 * raulrcs@gmail.com
 */
class MainViewModel @ViewModelInject constructor() : ViewModel() {

    fun sayHello() {
        SkizoLog.d("Hi hello")
    }
}

