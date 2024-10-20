package finance.home.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import finance.home.presentation.home.HomePage
import vn.finance.navigation.NavigationManager

const val HOME = "home"

@Composable
fun AuthenticationNavHost(navigationManager: NavigationManager, navController: NavHostController) {
    val context = LocalContext.current
    NavHost(navController = navController, startDestination = HOME) {
        composable(HOME) {
            HomePage(onGotoSetting = {})
        }
    }
}