package tuppersoft.com.evolution.core.platform

/**
 * Created by Raúl Rodríguez Concepción on 2019-06-16.
 *
 * raulrcs@gmail.com
 */

import android.os.Bundle
import androidx.fragment.app.Fragment
import tuppersoft.com.evolution.App
import tuppersoft.com.evolution.core.di.AppComponent
import tuppersoft.com.evolution.core.di.viewmodel.ViewModelFactory
import tuppersoft.com.evolution.core.extension.viewModel
import tuppersoft.com.evolution.features.main.MainActivity
import tuppersoft.com.evolution.features.main.MainViewModel
import javax.inject.Inject

abstract class GlobalFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var mainViewModel: MainViewModel

    val appComponent: AppComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (requireActivity().application as App).appComponent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        initViewModel()
    }

    private fun initViewModel() {
        if (activity is MainActivity) {
            mainViewModel = (activity as MainActivity).viewModel(viewModelFactory) {}
        }
    }


}