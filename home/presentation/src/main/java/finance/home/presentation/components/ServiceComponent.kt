package finance.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.CompareArrows
import androidx.compose.material.icons.filled.AddCard
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import vn.finance.home.presentation.R

@Composable
fun ServiceComponent() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surfaceContainer),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Column(
            modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(Icons.AutoMirrored.Filled.CompareArrows, stringResource(R.string.transfer))
            Box(Modifier.height(8.dp))
            Text(stringResource(R.string.transfer))
        }
        Box(
            modifier = Modifier
                .width(1.dp)
                .height(30.dp)
                .background(MaterialTheme.colorScheme.onSurface)
        )
        Column(
            modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(Icons.Filled.AddCard, stringResource(R.string.top_up))
            Box(Modifier.height(8.dp))
            Text(stringResource(R.string.top_up))
        }
        Box(
            modifier = Modifier
                .width(1.dp)
                .height(30.dp)
                .background(MaterialTheme.colorScheme.onSurface)
        )
        Column(
            modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(Icons.Filled.History, stringResource(R.string.history))
            Box(Modifier.height(8.dp))
            Text(stringResource(R.string.history))
        }
    }
}