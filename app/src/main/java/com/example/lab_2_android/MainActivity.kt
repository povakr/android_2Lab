package com.example.lab_2_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab_2_android.ui.theme.Lab_2_androidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab_2_androidTheme {
                TaskCounter(
                    )
            }
        }
    }
}

@Composable
fun TaskCounter() {
    //Изменяемые части
    var count by remember { mutableIntStateOf(0) }
    val maxTasks = 5

    //UI
    Column(
        modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 12.dp)
        .padding(top = 4.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column(
            modifier = Modifier
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = "Мои задачи")
            Text(textAlign = TextAlign.Center,
                text = "$count из 5",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,  // Общий размер шрифта
                color = Color.Black     // Общий цвет
            )

        }
        Row() {
            Box(
                modifier = Modifier
                .fillMaxWidth()
                .height(8.dp) // Задаем высоту прогресс-бара
                .clip(RoundedCornerShape(4.dp))
                .background(Color.LightGray)

            ){
                Box(
                    modifier = Modifier
                    .fillMaxWidth(fraction = count / 5f) // 👈 Динамическая ширина!
                    .height(8.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color.Blue)
                )
            }
        }

        Column() {
            Row() {
                Box() {
                    Text(text = "Выполнить задачу")
                }

            }
            Row() {
                Box() {
                    Text(text = "Отменить")
                }

            }
            Row() {
                Box() {
                    Text(text = "Все задачи выполнены")
                }

            }
            Row() {
                Box() {
                    Text(text = "Сбросить")
                }

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab_2_androidTheme {
        TaskCounter()
    }
}