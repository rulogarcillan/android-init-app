package tuppersoft.com.evolution.features.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import tuppersoft.com.evolution.core.platform.GlobalViewModel
import javax.inject.Inject

/**
 * Created by Raúl Rodríguez Concepción on 2019-12-20.
 * Talento Mobile
 * raulrcs@gmail.com
 */

class MainViewModel @Inject constructor() : GlobalViewModel() {

    private val _toolbarTitle: MutableLiveData<String> = MutableLiveData("")
    val toolbarTitle: LiveData<String>
        get() = _toolbarTitle

    fun setToolbarTitle(title: String) {
        _toolbarTitle.value = title
    }
}