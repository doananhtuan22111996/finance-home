package finance.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material.icons.filled.MedicalServices
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.material.icons.outlined.ContentPaste
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import vn.finance.home.R

private class PaymentItem(val icon: ImageVector, val text: String)

@Composable
fun PaymentComponent(onPaymentClick: () -> Unit) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Text(
            stringResource(R.string.payment_list),
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold)
        )
        Box(modifier = Modifier.height(16.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .height(216.dp)
                .wrapContentHeight()
        ) {
            itemsIndexed(
                listOf(
                    PaymentItem(
                        icon = Icons.Filled.Bolt, text = context.getString(R.string.electricity)
                    ),
                    PaymentItem(
                        icon = Icons.Filled.Wifi, text = context.getString(R.string.internet)
                    ),
                    PaymentItem(
                        icon = Icons.Filled.ConfirmationNumber,
                        text = context.getString(R.string.voucher)
                    ),
                    PaymentItem(
                        icon = Icons.Filled.MedicalServices,
                        text = context.getString(R.string.assurance)
                    ),
                    PaymentItem(
                        icon = Icons.Filled.ShoppingCart,
                        text = context.getString(R.string.merchant)
                    ),
                    PaymentItem(
                        icon = Icons.Filled.PhoneAndroid,
                        text = context.getString(R.string.mobile_credit)
                    ),
                    PaymentItem(
                        icon = Icons.Outlined.ContentPaste, text = context.getString(R.string.bill)
                    ),
                    PaymentItem(
                        icon = Icons.Filled.MoreHoriz, text = context.getString(R.string.more)
                    ),
                )
            ) { _, item ->
                PaymentItemComponent(item.icon, item.text, onPaymentClick)
            }
        }
    }
}

@Composable
private fun PaymentItemComponent(icon: ImageVector, text: String, onPaymentClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onPaymentClick() }) {
        Box(
            modifier = Modifier
                .width(56.dp)
                .height(56.dp)
                .clip(shape = RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            Icon(
                icon, text, modifier = Modifier.align(Alignment.Center)
            )
        }
        Box(modifier = Modifier.height(8.dp))
        Text(text, textAlign = TextAlign.Center)
    }
}