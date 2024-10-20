package vn.finance.home.business.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import vn.core.data.di.AnoRetrofitApiService
import vn.core.data.di.ProviderModule.provideRetrofit
import vn.core.provider.finance.Configs
import vn.finance.home.business.data.DashboardApiService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class NetworkModule {

    @Provides
    @Singleton
    @AnoRetrofitApiService
    fun provideApiServices(
        okHttpClient: OkHttpClient, gsonConverterFactory: GsonConverterFactory
    ): DashboardApiService {
        return provideRetrofit<DashboardApiService>(
            baseUrl = Configs.MAIN_DOMAIN,
            okHttpClient = okHttpClient,
            gsonConverterFactory = gsonConverterFactory
        )
    }
}