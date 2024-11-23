package finance.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import vn.finance.home.presentation.R

@Composable
fun PromoAndDiscountComponent() {
    Column {
        Text(
            stringResource(R.string.promo_and_discount),
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold)
        )
        LazyRow(modifier = Modifier.padding(vertical = 16.dp)) {
            items(items = listOf(1, 2, 3), itemContent = { item ->
                when (item) {
                    1 -> Image(
                        painterResource(R.drawable.promo_one),
                        stringResource(R.string.promo_one),
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )

                    2 -> Image(
                        painterResource(R.drawable.promo_two),
                        stringResource(R.string.promo_two),
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )

                    3 -> Image(
                        painterResource(R.drawable.promo_three),
                        stringResource(R.string.promo_three),
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }
            })
        }
    }
}