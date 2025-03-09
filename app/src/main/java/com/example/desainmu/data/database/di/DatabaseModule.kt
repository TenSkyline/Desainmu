package com.example.desainmu.data.database.di

import android.content.Context
import androidx.room.Room
import com.example.desainmu.data.database.DATABASE_NAME
import com.example.desainmu.data.database.DesainmuLocalDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): DesainmuLocalDb {
        return Room.databaseBuilder(context, DesainmuLocalDb::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
}