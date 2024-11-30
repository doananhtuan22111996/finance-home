package vn.finance.home.api

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

interface HomeApi {
    val path: String

    @Composable
    fun HomePage()
}