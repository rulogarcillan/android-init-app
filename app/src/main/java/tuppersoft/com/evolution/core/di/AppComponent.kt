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
    fun inject(mainActivity: MainActivity)
    fun inject(globalFragmnent: GlobalFragment)
    /*fun inject(fragment: SelectNamesFragment)
    fun inject(fragment: FavoritesFragment)*/
}