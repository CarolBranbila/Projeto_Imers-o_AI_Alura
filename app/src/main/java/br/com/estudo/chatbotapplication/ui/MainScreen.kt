@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package br.com.estudo.chatbotapplication.ui

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.estudo.chatbotapplication.presentation.ViewEvent
import br.com.estudo.chatbotapplication.presentation.ViewState
import br.com.estudo.chatbotapplication.theme.ChatbotApplicationTheme

@Composable
fun MainScreen(
    viewState: ViewState,
    onViewEvent: (ViewEvent) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        text = "Chatbot",
                    )
                }
            )
        },
    ) { innerPadding ->
        MainScreenContent(
            modifier = Modifier
                .fillMaxHeight()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            viewState = viewState,
            onViewEvent = onViewEvent
        )
    }
}

@Composable
@Preview(name = "Light theme", showBackground = true)
private fun MainScreenPreview() {
    ChatbotApplicationTheme {
        MainScreen(
            viewState = viewStatePreviewMock(),
            onViewEvent = {}
        )
    }
}