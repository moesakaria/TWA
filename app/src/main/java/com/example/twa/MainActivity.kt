package com.example.twa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.twa.ui.theme.TWATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TWATheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WeatherScreen()
                }
            }
        }
    }
}

@Composable
fun WeatherScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Top Bar (Custom)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(R.string.app_name),
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier.align(Alignment.CenterStart)
            )
        }

        // Main Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Row for Temperature & Icon
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Left side: Temperature
                Column {
                    Text(
                        text = stringResource(R.string.temp_value), // e.g. "72°"
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = stringResource(
                            R.string.feels_like_format,
                            stringResource(R.string.feels_like_value)
                        ),
                        fontSize = 16.sp
                    )
                }

                // Right side: Location + Icon
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.location_label), // e.g. "St. Paul, MN"
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Image(
                        painter = painterResource(R.drawable.sunny_twa), // your sun icon
                        contentDescription = stringResource(R.string.cd_sunny_icon),
                        modifier = Modifier.size(60.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Weather Details
            Column {
                Text(
                    text = stringResource(
                        R.string.low_temp_format,
                        stringResource(R.string.low_temp_value)
                    ),
                    fontSize = 16.sp
                )
                Text(
                    text = stringResource(
                        R.string.high_temp_format,
                        stringResource(R.string.high_temp_value)
                    ),
                    fontSize = 16.sp
                )
                Text(
                    text = stringResource(
                        R.string.humidity_format,
                        stringResource(R.string.humidity_value)
                    ),
                    fontSize = 16.sp
                )
                Text(
                    text = stringResource(
                        R.string.pressure_format,
                        stringResource(R.string.pressure_value)
                    ),
                    fontSize = 16.sp
                )
            }
        }
    }
}