package tuppersoft.com.evolution.features.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import tuppersoft.com.evolution.R
import tuppersoft.com.evolution.core.platform.GlobalFragment
import tuppersoft.com.evolution.databinding.MainFragmentBinding

class MainFragment : GlobalFragment() {

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    private lateinit var mainFragmentBinding: MainFragmentBinding
    override val toolbarTitle: String
        get() = "Titulo de prueba"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        return mainFragmentBinding.root
    }
}