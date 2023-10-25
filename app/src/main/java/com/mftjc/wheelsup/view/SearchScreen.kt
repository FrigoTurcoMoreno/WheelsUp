package com.mftjc.wheelsup.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(padding: PaddingValues) {
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ){
        SearchBar(
            modifier = Modifier
                .fillMaxWidth(),
            active = false,
            onActiveChange = {

            },
            onQueryChange = {
                text = it
            },
            onSearch = {

            },
            query = text,
            leadingIcon = {
                Icon(Icons.Default.Search, "search")
            },
            trailingIcon = {
                Icon(Icons.Default.Clear, "clear search bar")
            },
            placeholder = {
                Text("Search")
            }
        ){
        }
    }
}