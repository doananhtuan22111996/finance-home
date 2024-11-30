package finance.home.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import finance.home.presentation.api.HomeApiImpl
import vn.finance.home.api.HomeApi
import vn.finance.statistic.api.StatisticApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun provideHomeApi(statisticApi: StatisticApi): HomeApi =
        HomeApiImpl(statisticApi = statisticApi)
}