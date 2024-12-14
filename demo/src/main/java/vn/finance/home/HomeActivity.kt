package vn.finance.home

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import vn.finance.home.api.HomeApi
import vn.finance.home.presentation.R
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
        val context = LocalContext.current
        val toast =
            Toast.makeText(context, stringResource(R.string.coming_soon), Toast.LENGTH_SHORT)

        NavHost(navController = navController, startDestination = homeApi.path) {
            composable(homeApi.path) {
                homeApi.HomePage(onGotoSetting = {
                    toast.show()
                })
            }
        }
    }
}