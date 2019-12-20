package tuppersoft.com.evolution.core.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: Application) {


    @Provides
    @Singleton
    fun provideAppContext(): Context = app.applicationContext

    @Provides
    @Singleton
    fun provideApplication(): Application = app

    /*@Provides
    @Singleton
    fun provideChessDatabase(): AppBabyNamesDatabase = getBabyNamesDatabase(app)

    private fun getBabyNamesDatabase(app: Application): AppBabyNamesDatabase {
        return Room.databaseBuilder(
            app,
            AppBabyNamesDatabase::class.java, "database-baby-names"
        ).build()
    }*/
}