package com.husain.mykotlin.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Color constants
private object ProfileColors {
    val Background = Color.Black
    val CardBackground = Color(0xFF1A1A1A)
    val AccentGreen = Color(0xFF00C4B4)
    val TextGray = Color(0xFF666666)
    val DividerColor = Color(0xFF333333)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back */ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    Text(
                        text = "support",
                        color = Color.White,
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .clickable { /* Handle support */ }
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = ProfileColors.Background,
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        },
        containerColor = ProfileColors.Background
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Profile Section
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .background(ProfileColors.CardBackground),
                        colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.White)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "andaz kumar",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "member since Dec, 2020",
                            color = ProfileColors.TextGray,
                            fontSize = 14.sp
                        )
                    }
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            // CRED Garage Card
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { /* Handle click */ },
                    colors = CardDefaults.cardColors(containerColor = ProfileColors.CardBackground),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Car Icon",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "get to know your vehicles, inside out",
                                color = ProfileColors.TextGray,
                                fontSize = 12.sp
                            )
                            Text(
                                text = "CRED garage",
                                color = Color.White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "Arrow",
                            tint = Color.White,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }

            // Credit Score, Lifetime Cashback, Bank Balance
            item {
                Column {
                    ProfileItem(
                        icon = Icons.Default.Info,
                        title = "credit score",
                        subtitle = "REFRESH AVAILABLE",
                        subtitleColor = ProfileColors.AccentGreen,
                        value = "757"
                    )
                    Divider(color = ProfileColors.DividerColor)
                    ProfileItem(
                        icon = Icons.Default.Star,
                        title = "lifetime cashback",
                        value = "₹3"
                    )
                    Divider(color = ProfileColors.DividerColor)
                    ProfileItem(
                        icon = Icons.Default.AccountBox,
                        title = "bank balance",
                        value = "check"
                    )
                }
            }

            // Your Rewards & Benefits Section
            item {
                Column {
                    Text(
                        text = "YOUR REWARDS & BENEFITS",
                        color = ProfileColors.TextGray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    ProfileItem(
                        icon = Icons.Default.Check,
                        title = "cashback balance",
                        value = "₹0"
                    )
                    Divider(color = ProfileColors.DividerColor)
                    ProfileItem(
                        icon = Icons.Default.Star,
                        title = "coins",
                        value = "26,46,583"
                    )
                    Divider(color = ProfileColors.DividerColor)
                    ProfileItem(
                        icon = Icons.Default.Person,
                        title = "win upto Rs 1000",
                        value = "refer and earn"
                    )
                }
            }

            // Transactions & Support Section
            item {
                Column {
                    Text(
                        text = "TRANSACTIONS & SUPPORT",
                        color = ProfileColors.TextGray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    ProfileItem(
                        icon = Icons.Default.List,
                        title = "all transactions",
                        value = ""
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileItem(
    icon: ImageVector,
    title: String,
    subtitle: String? = null,
    subtitleColor: Color = Color.White,
    value: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Handle click */ }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Row {
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 16.sp
                )
                if (subtitle != null) {
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "• $subtitle",
                        color = subtitleColor,
                        fontSize = 12.sp
                    )
                }
            }
        }
        if (value.isNotEmpty()) {
            Text(
                text = value,
                color = Color.White,
                fontSize = 16.sp
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "Arrow",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}