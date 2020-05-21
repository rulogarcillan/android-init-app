package tuppersoft.com.evolution.core.di

import dagger.Component
import tuppersoft.com.evolution.App
import tuppersoft.com.evolution.core.di.repositories.RepositoriesModule
import tuppersoft.com.evolution.core.di.viewmodel.ViewModelModule
import tuppersoft.com.evolution.core.platform.GlobalFragment
import tuppersoft.com.evolution.features.main.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class, RepositoriesModule::class])
interface AppComponent {

    fun inject(app: App)
    fun inject(main: MainActivity)
    fun inject(fragment: GlobalFragment)
}