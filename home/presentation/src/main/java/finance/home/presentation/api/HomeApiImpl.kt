package finance.home.presentation.api

import androidx.compose.runtime.Composable
import finance.home.presentation.PATH
import vn.finance.home.api.HomeApi
import vn.finance.statistic.api.StatisticApi
import finance.home.presentation.home.HomePage as Page

class HomeApiImpl(private val statisticApi: StatisticApi) : HomeApi {
    override val path: String
        get() = PATH

    @Composable
    override fun HomePage() {
        Page(statisticPage = { statisticApi.StatisticPageWithoutScrollState() })
    }
}