package vn.finance.home.business.data.repository

import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import vn.core.data.di.AnoRetrofitApiService
import vn.core.data.model.ObjectResponse
import vn.core.data.network.NetworkBoundService
import vn.core.domain.ResultModel
import vn.finance.home.business.data.DashboardApiService
import vn.finance.home.business.data.model.AvailableBalanceRaw
import vn.finance.home.business.domain.model.AvailableBalanceModel
import vn.finance.home.business.domain.repository.AvailableBalanceRepository
import javax.inject.Inject

class AvailableBalanceRepositoryImpl @Inject constructor(@AnoRetrofitApiService private val apiService: DashboardApiService) :
    AvailableBalanceRepository {
    override fun getAvailableBalance(): Flow<ResultModel<AvailableBalanceModel>> {
        return object : NetworkBoundService<AvailableBalanceRaw, AvailableBalanceModel>() {
            override suspend fun onApi(): Response<ObjectResponse<AvailableBalanceRaw>> {
                return apiService.availableBalance()
            }

            override suspend fun processResponse(request: ObjectResponse<AvailableBalanceRaw>?): ResultModel.Success<AvailableBalanceModel> {
                return ResultModel.Success(data = request?.data?.raw2Model())
            }

        }.build()
    }
}
