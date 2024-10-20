package vn.finance.home.business.domain.repository

import kotlinx.coroutines.flow.Flow
import vn.core.domain.ResultModel
import vn.finance.home.business.domain.model.AvailableBalanceModel

interface AvailableBalanceRepository {
    fun getAvailableBalance(): Flow<ResultModel<AvailableBalanceModel>>
}