package finance.home.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import vn.finance.home.business.domain.repository.AvailableBalanceRepository
import vn.finance.home.business.domain.usecase.AvailableBalanceUseCase

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    @ViewModelScoped
    fun providesAvailableBalanceUseCase(repository: AvailableBalanceRepository): AvailableBalanceUseCase =
        AvailableBalanceUseCase(repository = repository)

}