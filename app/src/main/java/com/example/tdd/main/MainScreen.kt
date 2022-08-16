package com.example.tdd.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tdd.Router
import com.example.tdd.router.Route

@Composable
fun MainScreen(buttons: Map<String, Route>) {
    LazyColumn {
        item {
            buttons.entries.forEach {
                Button(
                    onClick = { Router.navigate(it.value) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = it.key)
                }
            }
        }
    }
}

@Preview
@Composable
fun MainScreen() {
    MainScreen(
        buttons = mapOf(
            "register" to Route("/register"),
            "login" to Route("/login"),
            "authorize" to Route("/authorize")
        )
    )
}
