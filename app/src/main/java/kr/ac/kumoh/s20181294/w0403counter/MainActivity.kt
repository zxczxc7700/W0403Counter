package kr.ac.kumoh.s20181294.w0403counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import kr.ac.kumoh.s20181294.w0403counter.ui.theme.W0403CounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Myapp(content = {Greeting(name = "test")})
            Myapp {
                Counter()
            }
        }
    }
}

@Composable
fun Myapp(content: @Composable () -> Unit) {
    W0403CounterTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}

@Composable
fun Counter() {
    var count by remember { mutableStateOf(0)}

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "$count", fontSize = 50.sp)

        Row() {
            Button(onClick = { count++ }) {
                Text(text = "증가")
            }

            Button(onClick = { count-- }) {
                Text(text = "감소")
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() = Myapp {
    Counter()
}