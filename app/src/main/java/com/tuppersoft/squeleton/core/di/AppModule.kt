package com.tuppersoft.squeleton.core.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    /*  @Provides
      @Singleton
      fun provideExampleClass() = Example("Hola dagger hilt")

     */
}
