package tuppersoft.com.evolution.core.extension

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

inline fun <reified T : ViewModel> AppCompatActivity.viewModel(
    factory: ViewModelProvider.Factory,
    body: T.() -> Unit
): T {
    val vm = ViewModelProvider(this, factory).get(T::class.java)
    vm.body()
    return vm
}

inline fun <reified T : ViewModel> AppCompatActivity.viewModel(
    body: T.() -> Unit
): T {
    val vm = ViewModelProvider(this).get(T::class.java)
    vm.body()
    return vm
}

