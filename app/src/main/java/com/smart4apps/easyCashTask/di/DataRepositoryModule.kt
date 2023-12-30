package com.smart4apps.easyCashTask.di

import android.content.Context
import androidx.room.Room
import com.smart4apps.easyCashTask.BuildConfig
import com.smart4apps.easyCashTask.data.api.ApiService
import com.smart4apps.easyCashTask.data.repository.MainRepository
import com.smart4apps.easyCashTask.data.room.CompetitionsDao
import com.smart4apps.easyCashTask.data.room.CompetitionsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataRepositoryModule {

    @Provides
    fun provideDataRepository(apiService: ApiService,competitionsDao: CompetitionsDao): MainRepository {
        return MainRepository(apiService,competitionsDao)
    }


    @Provides
    fun provideCompetitionsDao(appDatabase: CompetitionsDatabase): CompetitionsDao {
        return appDatabase.competitionsDao()
    }


    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): CompetitionsDatabase {

        //we used this to secure the database
        val passphrase: ByteArray = SQLiteDatabase.getBytes(BuildConfig.database_secret_key.toCharArray())
        val factory = SupportFactory(passphrase)

        return Room.databaseBuilder(
            appContext,
            CompetitionsDatabase::class.java,
            "CompetitionsDatabase.db"
        ).openHelperFactory(factory) // Use openHelperFactory with SupportFactory for encryption
            .build()
    }
}