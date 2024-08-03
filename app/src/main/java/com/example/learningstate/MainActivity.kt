package com.example.learningstate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learningstate.ui.theme.LearningStateTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val scaffoldState= rememberScaffoldState()
            var textFieldState by remember {
                mutableStateOf("")
            }
            val scope = rememberCoroutineScope()

            Scaffold (
                scaffoldState = scaffoldState,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp)
            ){
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp)
                ){
                    TextField(
                        value = textFieldState,
                        label = { Text(text = "Enter Your Name")},
                        onValueChange = {
                            textFieldState=it
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()

                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = {
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar("hello ${textFieldState}","hello",SnackbarDuration.Short)
                        }

                    }) {
                        Text(text = "Pls Greet me")
                }

                    }

            }
        }
    }
}
