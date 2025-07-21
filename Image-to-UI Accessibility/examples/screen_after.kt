package com.lucaseox.generatedappsfigmatemplates.generatedscreens.refactored.v1.refactoredbca// Required imports

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucaseox.generatedappsfigmatemplates.R // Replace with your actual package name

@Composable
fun TransferCompleteScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White)
    ) {
        HeaderSection()
        ConfirmationSection()
        TransactionDetailsSection()
        ActionButtonsSection()
    }
}

@Composable
private fun HeaderSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFF1746A2))
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = "Hello,",
                color = Color.White,
                fontSize = 14.sp
            )
            Text(
                text = "Andhika Putra",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Text(
                text = "Account ID: 9087890908", // Unique content description
                color = Color.White,
                fontSize = 12.sp
            )
        }

        Row(
            modifier = Modifier.align(Alignment.TopEnd),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(
                imageVector = Icons.Default.AddCircle,
                contentDescription = "Status indicator",
                tint = Color(0xFF00C853), // Bright green
                modifier = Modifier.size(16.dp)
            )
            Icon(
                imageVector = Icons.Default.AddCircle,
                contentDescription = "Notification bell icon",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(color = Color(0xFF5F8DF7), shape = CircleShape)
            )
        }
    }
}

@Composable
private fun ConfirmationSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Transfer Completed",
            color = Color(0xFF1746A2),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Text(
            text = "Congratulation!",
            color = Color(0xFF1746A2),
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(24.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_placeholder),
            contentDescription = "Success checkmark icon",
            modifier = Modifier.size(160.dp)
        )
    }
}

@Composable
private fun TransactionDetailsSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Wesley Putra",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1746A2),
                    fontSize = 16.sp
                )
                Text(
                    text = "Account ID: 9087890908", // Unique content
                    fontSize = 12.sp,
                    color = Color(0xFF444444) // Darker gray for better contrast
                )
            }
            Text(
                text = "Rp. 1.320.000",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color(0xFF1746A2)
            )
        }
        Divider(thickness = 1.dp, color = Color(0xFFDDDDDD))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "8689550487548   15/12 18:34:54",
                fontSize = 10.sp,
                color = Color(0xFF444444) // Dark gray
            )
            Text(
                text = "Yesterday's Dinner",
                fontSize = 10.sp,
                color = Color(0xFF444444)
            )
        }
    }
}

@Composable
private fun ActionButtonsSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedButton(
            onClick = { /* Handle download */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF1746A2))
        ) {
            Text(
                text = "Download",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
        Button(
            onClick = { /* Handle finish */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1746A2))
        ) {
            Text(
                text = "Finish",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
        }
    }
}
