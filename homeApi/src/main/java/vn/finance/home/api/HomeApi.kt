package vn.finance.home.api

import androidx.compose.runtime.Composable

interface HomeApi {
    val path: String

    @Composable
    fun HomePage(onGotoSetting: () -> Unit)
}
