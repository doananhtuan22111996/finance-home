package finance.home.presentation.api

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import finance.home.presentation.PATH
import vn.finance.home.api.HomeApi
import vn.finance.profile.api.ProfileApi
import vn.finance.statistic.api.StatisticApi
import finance.home.presentation.home.HomePage as Page

class HomeApiImpl(private val statisticApi: StatisticApi, private val profileApi: ProfileApi) :
    HomeApi {
    override val path: String
        get() = PATH

    @Composable
    override fun HomePage(onGotoSetting: () -> Unit) {
        Page(
            statisticPage = { statisticApi.StatisticPageWithoutScrollState() },
            profilePage = { profileApi.ProfileView(modifier = Modifier) },
            onGotoSetting = onGotoSetting
        )
    }
}