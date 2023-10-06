package com.example.User.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.User.data.User

@Composable
fun User(user: User, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(125.dp)
        .padding(vertical = 2.dp, horizontal = 5.dp), ) {
        Row {
            AsyncImage(
                model = user.avatar,
                contentDescription = user.avatar,
                modifier = Modifier.fillMaxHeight()
            )
            Column {
                Text(
                    text = "Nome: ${user.name}",
                    modifier = Modifier
                        .padding(3.dp)
                )
                Text(
                    text = "Url:${user.url}",
                    modifier = Modifier.padding(3.dp),
                )
                Button(onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(user.url))
                    context.startActivity(intent)
                }) {
                    Text(text = "URL page")
                }
            }
        }
    }
}

@Composable
fun UsersList(
    modifier: Modifier = Modifier,
    usersViewModel: UsersViewModel = viewModel()
) {
    val usersState by usersViewModel.usersUiState.collectAsState()
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())) {
        usersState.users?.forEach() { user ->
            User(user = user)
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun UsersScreen(usersViewModel: UsersViewModel) {
    var searchTerm by remember { mutableStateOf("") }
    Column {
        TextField(
            value = searchTerm,
            onValueChange = { newTerm ->
                searchTerm = newTerm
            },
            placeholder = { Text("Pesquisar") },
            keyboardActions = KeyboardActions(
                onSearch = {
                    usersViewModel.searchUsers(searchTerm)
                }
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Search
            ),
            modifier = Modifier.fillMaxWidth()
        )
        UsersList(usersViewModel = usersViewModel)
    }
}




