package finance.home.presentation.home.dashboard

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import finance.home.presentation.components.AlertExceptionDialogComponent
import finance.home.presentation.components.FullScreenLoadingDialogComponent
import finance.home.presentation.components.PaymentComponent
import finance.home.presentation.components.PromoAndDiscountComponent
import finance.home.presentation.components.ServiceComponent
import finance.home.presentation.components.YourAccountComponent
import vn.finance.home.presentation.R

@Composable
fun DashboardView() {
    val viewModel: DashboardViewModel = hiltViewModel()
    val data by viewModel.data.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val appException by viewModel.appException.collectAsStateWithLifecycle()
    val toast = Toast.makeText(
        LocalContext.current, stringResource(R.string.coming_soon), Toast.LENGTH_SHORT
    )

    Column(modifier = Modifier.fillMaxSize()) {
        YourAccountComponent(
            name = data?.name ?: stringResource(R.string.finance), money = data?.money ?: 0
        )
        Box(modifier = Modifier.padding(vertical = 24.dp)) {
            ServiceComponent()
        }
        PaymentComponent(onPaymentClick = { toast.show() })
        Box(modifier = Modifier.height(8.dp))
        PromoAndDiscountComponent()

        if (isLoading) {
            FullScreenLoadingDialogComponent()
        }

        if (appException != null) {
            AlertExceptionDialogComponent(message = stringResource(R.string.failed_to_fetch_available_balance),
                onDismissRequest = { viewModel.onAppExceptionDismiss() })
        }
    }
}