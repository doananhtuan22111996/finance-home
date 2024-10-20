package finance.home.presentation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import vn.finance.home.business.data.repository.AvailableBalanceRepositoryImpl
import vn.finance.home.business.domain.repository.AvailableBalanceRepository

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataModule {

    @Binds
    @ViewModelScoped
    abstract fun bindsAvailableBalanceRepository(availableBalanceRepositoryImpl: AvailableBalanceRepositoryImpl): AvailableBalanceRepository
}


