package finance.home.presentation.di

import com.feature.api.NotificationApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import finance.home.presentation.api.HomeApiImpl
import vn.finance.home.api.HomeApi
import vn.finance.profile.api.ProfileApi
import vn.finance.statistic.api.StatisticApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun provideHomeApi(
        statisticApi: StatisticApi,
        profileApi: ProfileApi,
        notificationApi: NotificationApi
    ): HomeApi =
        HomeApiImpl(
            statisticApi = statisticApi,
            profileApi = profileApi,
            notificationApi = notificationApi
        )
}