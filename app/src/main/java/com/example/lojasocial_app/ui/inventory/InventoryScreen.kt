package com.example.lojasocial_app.ui.inventory

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Mock data class para itens do inventário
data class InventoryItem(
    val id: Int,
    val name: String,
    val stockQuantity: Int,
    val icon: String = "🥫" // Emoji como placeholder para ícone
)

@Composable
fun InventoryScreen() {
    // IPCA Green color
    val ipcaGreen = Color(0xFF1B5E20)
    val lightGreen = Color(0xFFE8F5E9)
    
    // Mock data - depois será substituído por dados da DB
    val inventoryItems = remember {
        listOf(
            InventoryItem(1, "Arroz", 40, "🍚"),
            InventoryItem(2, "Leite", 30, "🥛"),
            InventoryItem(3, "Atum", 25, "🥫"),
            InventoryItem(4, "Massa", 20, "🍝")
        )
    }
    
    var searchQuery by remember { mutableStateOf("") }
    var showFilterDialog by remember { mutableStateOf(false) }
    
    // Filtrar itens baseado na pesquisa
    val filteredItems = remember(searchQuery, inventoryItems) {
        if (searchQuery.isEmpty()) {
            inventoryItems
        } else {
            inventoryItems.filter { 
                it.name.contains(searchQuery, ignoreCase = true)
            }
        }
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* TODO: Abrir dialog para adicionar produto */ },
                containerColor = ipcaGreen,
                contentColor = Color.White
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Adicionar produto"
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
                .padding(paddingValues)
        ) {
            // Header com logo IPCA
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(ipcaGreen)
                    .padding(horizontal = 16.dp, vertical = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "IPCA",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        letterSpacing = 3.sp
                    ),
                    color = Color.White
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Título
                Text(
                    text = "Inventário",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = ipcaGreen
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Barra de pesquisa e botão filtrar
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        modifier = Modifier.weight(1f),
                        placeholder = { Text("Procurar itens") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Pesquisar",
                                tint = Color.Gray
                            )
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = ipcaGreen,
                            unfocusedBorderColor = Color.Gray,
                            cursorColor = ipcaGreen
                        ),
                        singleLine = true,
                        shape = RoundedCornerShape(8.dp)
                    )

                    OutlinedButton(
                        onClick = { showFilterDialog = true },
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = ipcaGreen
                        ),
                        border = androidx.compose.foundation.BorderStroke(1.dp, ipcaGreen),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("Filtrar")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Lista de itens do inventário
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(filteredItems) { item ->
                        InventoryItemCard(item = item)
                    }
                }
            }
        }
    }
}

@Composable
private fun InventoryItemCard(item: InventoryItem) {
    val ipcaGreen = Color(0xFF1B5E20)
    val lightGreen = Color(0xFFE8F5E9)
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* TODO: Abrir detalhes do item */ },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(2.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Ícone do item
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(lightGreen),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = item.icon,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            // Informações do item
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = item.name,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = ipcaGreen
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Em stock: ${item.stockQuantity}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.DarkGray
                )
            }
        }
    }
}