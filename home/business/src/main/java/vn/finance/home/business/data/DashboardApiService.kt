package vn.finance.home.business.data

import retrofit2.Response
import retrofit2.http.GET
import vn.core.data.model.ObjectResponse
import vn.finance.home.business.data.model.AvailableBalanceRaw

interface DashboardApiService {

    @GET("/available-balance")
    suspend fun availableBalance(): Response<ObjectResponse<AvailableBalanceRaw>>
}
