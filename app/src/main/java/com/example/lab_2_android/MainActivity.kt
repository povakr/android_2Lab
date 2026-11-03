package com.example.lab_2_android


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
                text = "Мои задачи",
                fontWeight = FontWeight.Bold,  // Общий размер шрифта
                color = Color.Black)     // Общий цвет
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
                .height(8.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(Color.LightGray) //серая подложка

            ){
                Box(
                    modifier = Modifier
                    .fillMaxWidth(fraction = count / 5f)
                    .height(8.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color.Blue) // прогресс бар
                )
            }
        }

        // Кнопки управления
        Button(
            onClick = { if (count < maxTasks) count++ },
            modifier = Modifier.fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(4.dp),
            enabled = count < maxTasks,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,      // Цвет фона кнопки
                contentColor = Color.White        // Цвет текста/иконки внутри
            )
        ) { Text("Выполнить задачу") }

        Button(
            onClick = { if (count > 0) count-- },
            modifier = Modifier.fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(4.dp),
            enabled = count > 0,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray,      // Цвет фона кнопки
                contentColor = Color.Black        // Цвет текста/иконки внутри
            )

        ) { Text("Отменить") }

        // Сообщение о завершении
        if (count == maxTasks) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color(0xFFD3F5E0)), // прогресс бар
                contentAlignment = Alignment.Center // 👈 Центрируем текст внутри Box

            ) {Text("Все задачи выполнены", color = Color(0xFF006400) , fontWeight = FontWeight.Bold)}
        }

        // Кнопка сброса
        Button(onClick = { count = 0 },
            modifier = Modifier.fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray,      // Цвет фона кнопки
                contentColor = Color.Black        // Цвет текста/иконки внутри
            )
        ) {
            Text("Сбросить")

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