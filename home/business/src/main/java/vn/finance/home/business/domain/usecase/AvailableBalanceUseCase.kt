package vn.finance.home.business.domain.usecase

import kotlinx.coroutines.flow.Flow
import vn.core.domain.ResultModel
import vn.core.usecase.BaseUseCase
import vn.finance.home.business.domain.model.AvailableBalanceModel
import vn.finance.home.business.domain.repository.AvailableBalanceRepository
import javax.inject.Inject

class AvailableBalanceUseCase @Inject constructor(private val repository: AvailableBalanceRepository) :
    BaseUseCase<Any, ResultModel<AvailableBalanceModel>>() {
    override fun execute(vararg params: Any?): Flow<ResultModel<AvailableBalanceModel>> {
        return repository.getAvailableBalance()
    }
}