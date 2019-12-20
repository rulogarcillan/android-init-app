package tuppersoft.com.evolution.features.main

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import tuppersoft.com.evolution.R
import tuppersoft.com.evolution.core.di.viewmodel.ViewModelFactory
import tuppersoft.com.evolution.core.extension.viewModel
import tuppersoft.com.evolution.core.platform.GlobalActivity
import tuppersoft.com.evolution.databinding.MainActivityBinding
import javax.inject.Inject

class MainActivity : GlobalActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var mainViewModel: MainViewModel
    private lateinit var mainActivityDataBinding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        mainActivityDataBinding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        mainActivityDataBinding.lifecycleOwner = this
        initViewModel()

        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.flContainerFragment, MainFragment.newInstance())
        transaction.commit()
    }

    private fun initViewModel() {
        mainViewModel = viewModel(viewModelFactory) {}
        mainActivityDataBinding.viewModel = mainViewModel
        mainViewModel.setToolbarTitle(getString(R.string.app_name))
    }
}

