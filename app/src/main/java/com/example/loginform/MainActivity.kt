package com.example.loginform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginform.ui.theme.LoginFormTheme
//class PasswordVisualTransformation(val mask: Char = '\u2022')

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginFormTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginForm()
                }
            }
        }
    }
}

@Composable
fun LoginForm() {
    var usernameInput: String by remember { mutableStateOf("") }
    var passwordInput: String by remember { mutableStateOf("") }
    var showPassword by remember {
        mutableStateOf(false)
    }

    Column (
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Login",
            fontSize = 24.sp,
            color = MaterialTheme.colors.primary,
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp, bottom = 16.dp)
        )
        OutlinedTextField(
            value = usernameInput,
            onValueChange = { usernameInput = it },
            trailingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Email Icon") },
            label = {Text(stringResource(R.string.Username))},
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = passwordInput,
            onValueChange = { passwordInput = it },
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                IconButton(onClick = { showPassword = !showPassword }) {
                    Icon(
                        imageVector = if (showPassword) Icons.Outlined.Lock else Icons.Filled.Lock,
                        contentDescription = if (showPassword) "Show Password" else "Hide Password"
                    )
                }
            },
            //visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            label = {Text(stringResource(R.string.Password))},
            singleLine = true,
            modifier = Modifier.fillMaxWidth()

        )
        Button(
            onClick = {/*TODO*/},
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = stringResource(R.string.Submit))
        }


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginFormTheme {
        LoginForm()
    }
}