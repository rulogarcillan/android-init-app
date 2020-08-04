package com.tuppersoft.squeleton.features.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.tuppersoft.squeleton.R
import com.tuppersoft.squeleton.core.platform.GlobalFragment

class MainFragment : GlobalFragment() {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.sayHello()
        return inflater.inflate(R.layout.main_fragment, container, false)
    }
}
