package com.example.lojasocial_app.ui.delivery

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
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

// Mock data class para entregas
data class Delivery(
    val id: Int,
    val recipientName: String,
    val deliveryDate: String
)

@Composable
fun DeliveryListScreen() {
    // IPCA Green color
    val ipcaGreen = Color(0xFF1B5E20)
    
    // Mock data - depois será substituído por dados da DB
    val deliveries = remember {
        listOf(
            Delivery(1, "Ana Sousa", "08/04/2024"),
            Delivery(2, "José Ferreira", "05/04/2024"),
            Delivery(3, "Maria Oliveira", "05/04/2024"),
            Delivery(4, "Rui Martins", "02/04/2024")
        )
    }
    
    var searchQuery by remember { mutableStateOf("") }
    var showFilterDialog by remember { mutableStateOf(false) }
    
    // Filtrar entregas baseado na pesquisa
    val filteredDeliveries = remember(searchQuery, deliveries) {
        if (searchQuery.isEmpty()) {
            deliveries
        } else {
            deliveries.filter { 
                it.recipientName.contains(searchQuery, ignoreCase = true) ||
                it.deliveryDate.contains(searchQuery, ignoreCase = true)
            }
        }
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* TODO: Abrir dialog para adicionar entrega */ },
                containerColor = ipcaGreen,
                contentColor = Color.White
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Adicionar entrega"
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
                    text = "Entregas",
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
                        placeholder = { Text("Procurar entregas") },
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

                // Lista de entregas
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(filteredDeliveries) { delivery ->
                        DeliveryItemCard(delivery = delivery)
                    }
                }
            }
        }
    }
}

@Composable
private fun DeliveryItemCard(delivery: Delivery) {
    val ipcaGreen = Color(0xFF1B5E20)
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* TODO: Abrir detalhes da entrega */ },
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
            // Ícone circular com calendário/entrega
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(ipcaGreen),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "Entrega",
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            // Informações da entrega
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = delivery.recipientName,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = ipcaGreen
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Data de entrega: ${delivery.deliveryDate}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.DarkGray
                )
            }
        }
    }
}
