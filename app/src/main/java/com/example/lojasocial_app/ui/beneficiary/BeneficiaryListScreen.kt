package com.example.lojasocial_app.ui.beneficiary

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
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

// Mock data class para beneficiários
data class Beneficiary(
    val id: Int,
    val name: String,
    val supportType: String
)

@Composable
fun BeneficiaryListScreen() {
    // IPCA Green color
    val ipcaGreen = Color(0xFF1B5E20)
    
    // Mock data - depois será substituído por dados da DB
    val beneficiaries = remember {
        listOf(
            Beneficiary(1, "Maria Ferreira", "Apoio financeiro para estudos"),
            Beneficiary(2, "João Silva", "Despesas médicas"),
            Beneficiary(3, "Ana Santos", "Habitação temporária"),
            Beneficiary(4, "Rui Costa", "Aquisição de alimentos")
        )
    }
    
    var searchQuery by remember { mutableStateOf("") }
    var showSearchBar by remember { mutableStateOf(false) }
    
    // Filtrar beneficiários baseado na pesquisa
    val filteredBeneficiaries = remember(searchQuery, beneficiaries) {
        if (searchQuery.isEmpty()) {
            beneficiaries
        } else {
            beneficiaries.filter { 
                it.name.contains(searchQuery, ignoreCase = true) ||
                it.supportType.contains(searchQuery, ignoreCase = true)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
        // Header com logo IPCA e ícone de pesquisa
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(ipcaGreen)
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            Text(
                text = "IPCA",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    letterSpacing = 3.sp
                ),
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterStart)
            )
            
            IconButton(
                onClick = { showSearchBar = !showSearchBar },
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Pesquisar",
                    tint = Color.White
                )
            }
        }
        
        // Barra de pesquisa (aparece quando clica na lupa)
        if (showSearchBar) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                placeholder = { Text("Pesquisar beneficiário...") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Pesquisar",
                        tint = ipcaGreen
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = ipcaGreen,
                    unfocusedBorderColor = Color.Gray,
                    cursorColor = ipcaGreen
                ),
                singleLine = true
            )
        }

        // Título
        Text(
            text = "Beneficiários",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontWeight = FontWeight.Bold
            ),
            color = ipcaGreen,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
        )

        // Lista de beneficiários
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(filteredBeneficiaries) { beneficiary ->
                BeneficiaryItem(
                    beneficiary = beneficiary,
                    onClick = { /* TODO: Navegar para detalhes */ }
                )
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
private fun BeneficiaryItem(
    beneficiary: Beneficiary,
    onClick: () -> Unit
) {
    val ipcaGreen = Color(0xFF1B5E20)
    
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .clickable { onClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Ícone circular de pessoa
        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
                .background(ipcaGreen),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Beneficiário",
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )
        }
        
        Spacer(modifier = Modifier.width(16.dp))
        
        // Informações do beneficiário
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = beneficiary.name,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.SemiBold
                ),
                color = ipcaGreen
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = beneficiary.supportType,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.DarkGray
            )
        }
    }
}
