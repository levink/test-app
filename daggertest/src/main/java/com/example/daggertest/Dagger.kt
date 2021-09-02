package com.example.daggertest

import dagger.Component
import dagger.Module
import dagger.Provides

@Component(modules = [AppModule::class])
interface AppComponent {
    fun student() : Student
    fun inject(fragment: FirstFragment)
}

@Module
object AppModule {

    @Provides
    fun provideDBHelper(): DBHelper {
        return DBHelper()
    }

    @Provides
    fun provideStudent(db: DBHelper): Student {
        return db.getStudent()
    }

}