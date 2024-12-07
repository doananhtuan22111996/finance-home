package vn.finance.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import vn.finance.home.api.HomeApi
import vn.finance.theme.AppTheme
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    @Inject
    lateinit var homeApi: HomeApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            AppTheme {
                HomeNavHost(navController = navController)
            }
        }
    }

    @Composable
    fun HomeNavHost(navController: NavHostController) {
        NavHost(navController = navController, startDestination = homeApi.path) {
            composable(homeApi.path) {
                homeApi.HomePage()
            }
        }
    }
}