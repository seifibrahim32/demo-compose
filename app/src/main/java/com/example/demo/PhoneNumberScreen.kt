package com.example.demo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PhoneNumberScreen(
    modifier : Modifier = Modifier
) {
    var phone by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(false) }

    val countries = listOf(
        Country("United Kingdom", "🇬🇧", "+44"),
        Country("United States", "🇺🇸", "+1"),
        Country("Egypt", "🇪🇬", "+20"),
        Country("Germany", "🇩🇪", "+49"),
    )

    var selectedCountry by remember { mutableStateOf(countries.first()) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier.height(32.dp))

        Text(
            text = "One last step",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(Modifier.height(8.dp))

        Text(
            text = buildAnnotatedString {
                append("Please login or signup for a ")
                withStyle(style = SpanStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color(0xFF010507))) {
                    append("free ")
                }
                append("account to continue")
            },
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = Color.Black.copy(alpha = 0.7f),
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(Modifier.height(32.dp))

        PhoneInputField(
            phoneNumber = phone,
            onPhoneNumberChange = { phone = it },
            selectedCountry = selectedCountry,
            onCountryChange = { selectedCountry = it },
            countries = countries
        )

        Spacer(Modifier.height(8.dp))

        Text(
            text = "We will use this to verify your account",
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(Modifier.height(24.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFF6A1B9A) // purple shade
                )
            )
            Text(
                buildAnnotatedString {
                    append("I agree and comply to the ")
                    withStyle(style = SpanStyle(color = Color(0xFF0288D1))) {
                        append("community guidelines")
                    }
                },
                fontSize = 14.sp
            )
        }

        Spacer(Modifier.height(32.dp))

        Button(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            enabled = checked,
            shape = RoundedCornerShape(28.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6A1B9A),     // enabled color
                disabledContainerColor = Color(0xFFBDBDBD), // gray when disabled
                contentColor = Color.White,
                disabledContentColor = Color.White.copy(alpha = 0.6f)
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Continue", color = Color.White, fontWeight = FontWeight.Bold)
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }
}