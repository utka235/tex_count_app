package com.example.texcount

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TexCountApp()
        }
    }
}

@Composable
fun TexCountApp() {
    var priceInput by remember { mutableStateOf("") }
    val items = remember { mutableStateListOf<Double>() }

    val total = items.sum()
    val taxedTotal = total * 1.13

    Scaffold(
        topBar = {
            SmallTopAppBar(title = { Text("Tax Counter") })
        }
    ) { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .padding(16.dp)) {
            OutlinedTextField(
                value = priceInput,
                onValueChange = { priceInput = it },
                label = { Text("Product Price") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    priceInput.toDoubleOrNull()?.let {
                        if (items.size < 999) {
                            items.add(it)
                            priceInput = ""
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Add Product")
            }
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(modifier = Modifier.weight(1f, fill = false)) {
                itemsIndexed(items) { index, item ->
                    Text(text = "Item ${'$'}{index + 1}: ${'$'}item")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Total before tax: ${'$'}total")
            Text(text = "Total with 13% tax: ${'$'}taxedTotal")
        }
    }
}

