package finance.home.presentation.home

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DocumentScanner
import androidx.compose.material.icons.outlined.BarChart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import finance.home.presentation.home.dashboard.DashboardView
import vn.core.composex.uikit.AppBottomNavigationBar
import vn.core.composex.uikit.Container
import vn.core.composex.uikit.NavElement
import vn.finance.home.presentation.R

@Composable
fun HomePage(statisticPage: @Composable () -> Unit) {
    val viewModel: HomeViewModel = hiltViewModel()
    val selected by viewModel.selected.collectAsStateWithLifecycle()
    val context = LocalContext.current
    val toast = Toast.makeText(context, stringResource(R.string.coming_soon), Toast.LENGTH_SHORT)

    Container(
        appBarTitle = stringResource(R.string.home),
        actions = {
            IconButton(onClick = {
                toast.show()
            }) {
                Icon(Icons.Outlined.Settings, contentDescription = stringResource(R.string.setting))
            }
        },
        bottomBar = {
            BottomAppBar {
                AppBottomNavigationBar(
                    items = listOf(
                        NavElement(
                            icon = {
                                Icon(
                                    Icons.Outlined.Home,
                                    contentDescription = stringResource(R.string.home)
                                )
                            },
                            label = { Text(stringResource(R.string.home)) },
                            onClick = { viewModel.onSelected(0) },
                            selected = selected == 0,
                        ),
                        NavElement(
                            icon = {
                                Icon(
                                    Icons.Outlined.BarChart,
                                    contentDescription = stringResource(R.string.statistic)
                                )
                            },
                            label = { Text(stringResource(R.string.statistic)) },
                            onClick = { viewModel.onSelected(1) },
                            selected = selected == 1,
                        ),
                        NavElement(
                            icon = {
                                Icon(
                                    Icons.Outlined.Notifications,
                                    contentDescription = stringResource(R.string.notification),
                                )
                            },
                            label = { Text(stringResource(R.string.notification)) },
                            onClick = { viewModel.onSelected(2) },
                            selected = selected == 2,
                        ),
                        NavElement(
                            icon = {
                                Icon(
                                    Icons.Outlined.Person,
                                    contentDescription = stringResource(R.string.profile)
                                )
                            },
                            label = { Text(stringResource(R.string.profile)) },
                            onClick = { viewModel.onSelected(3) },
                            selected = selected == 3,
                        ),
                    ),
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { toast.show() }, modifier = Modifier.offset(y = 40.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.DocumentScanner,
                    contentDescription = stringResource(R.string.scan_qr)
                )
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            AnimatedVisibility(visible = selected == 0) {
                DashboardView()
            }
            AnimatedVisibility(visible = selected == 1) {
                statisticPage()
            }
            AnimatedVisibility(visible = selected != 0 && selected != 1) {
                Box(modifier = Modifier.fillMaxSize())
            }
        }
    }
}
