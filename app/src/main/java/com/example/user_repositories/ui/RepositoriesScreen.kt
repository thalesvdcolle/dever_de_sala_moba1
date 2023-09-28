package com.example.user_repositories.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.user_repositories.data.Repository

@Composable
fun Repository(repository: Repository, modifier: Modifier = Modifier) {
    Column {
        Row {
            AsyncImage(model = repository.name, contentDescription = null)
            Text(
                text = repository.name,
                modifier = modifier
            )
            Text(
                text = repository.name,
                modifier = modifier
            )
            Text(
                text = repository.name,
                modifier = modifier
            )
        }
    }
}

@Composable
fun RepositoriesList(
    modifier: Modifier = Modifier,
    repositoriesViewModel: RepositoriesViewModel = viewModel()
) {
    val repositoriesState by repositoriesViewModel.repositoriesUiState.collectAsState()
    Column {
        repositoriesState.repositories.forEach { repository ->
            Repository(repository = repository)
        }
    }
}