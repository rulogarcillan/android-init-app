package tuppersoft.com.evolution.core.extension

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

inline fun <reified T : ViewModel> Fragment.viewModel(
    factory: ViewModelProvider.Factory,
    body: T.() -> Unit
): T {
    val vm = ViewModelProvider(this, factory).get(T::class.java)
    vm.body()
    return vm
}

inline fun <reified T : ViewModel> Fragment.viewModel(
    body: T.() -> Unit
): T {
    val vm = ViewModelProvider(this).get(T::class.java)
    vm.body()
    return vm
}