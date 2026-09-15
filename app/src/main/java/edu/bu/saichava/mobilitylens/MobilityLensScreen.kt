package edu.bu.saichava.mobilitylens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun MobilityLensScreen(modifier: Modifier = Modifier) {
    var currentIndex by remember { mutableIntStateOf(0) }
    val currentDimension = mobilityDimensions[currentIndex]

    var appName by remember { mutableStateOf("") }
    var feedbackMessage by remember { mutableStateOf("") }

    val currentDimensionTitle = stringResource(id = currentDimension.titleResId)
    val blankFieldWarning = stringResource(id = R.string.feedback_blank_input)
    val successfulFeedback = stringResource(
        id = R.string.feedback_success,
        appName.trim(),
        currentDimensionTitle
    )

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .imePadding()
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = stringResource(id = R.string.app_introduction),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 4.dp, bottom = 16.dp)
        )

        Text(
            text = currentDimensionTitle,
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = stringResource(id = currentDimension.descriptionResId),
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = stringResource(id = currentDimension.implicationResId),
            style = MaterialTheme.typography.bodyMedium
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { currentIndex-- },
                enabled = currentIndex > 0
            ) {
                Text(text = stringResource(id = R.string.button_previous))
            }

            Button(
                onClick = { currentIndex++ },
                enabled = currentIndex < mobilityDimensions.lastIndex
            ) {
                Text(text = stringResource(id = R.string.button_next))
            }
        }

        OutlinedTextField(
            value = appName,
            onValueChange = { appName = it },
            label = { Text(text = stringResource(id = R.string.label_app_name)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        )

        Button(
            onClick = {
                feedbackMessage = if (appName.isBlank()) {
                    blankFieldWarning
                } else {
                    successfulFeedback
                }
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(text = stringResource(id = R.string.button_check))
        }

        if (feedbackMessage.isNotEmpty()) {
            Text(
                text = feedbackMessage,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}
