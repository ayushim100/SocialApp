package com.example.stackoverflow.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.stackoverflow.R
import com.example.stackoverflow.activity.ui.theme.StackOverFlowTheme
import com.example.stackoverflow.models.User
import com.example.stackoverflow.network.ServerCallManager

class LoginActivity : ComponentActivity() {

    lateinit var serverCallManager: ServerCallManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        serverCallManager = ServerCallManager()
        setContent {
            StackOverFlowTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen{ email, password ->
                        onClickLoginBtn(email, password)
                    }

                }
            }
        }
    }

    private fun onClickLoginBtn(email: String, password: String) {
        val user = User("username",email, password)
        serverCallManager.createUser(user)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(onClickBtn: (String, String) -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(28.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            //logo
            //email
            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            OutlinedTextField(
                value = email,
                leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },
                //trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
                onValueChange = {
                    email = it
                },
                label = { Text(text = "Email") },
                placeholder = { Text(text = "Email") },
                modifier = Modifier.fillMaxWidth()
            )
            //password
            OutlinedTextField(
                value = password,
                leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "lockIcon") },
                //trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
                onValueChange = {
                    password = it
                },
                label = { Text(text = "Password") },
                placeholder = { Text(text = "Password") },
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.forgot_password)
            )
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onClickBtn(email, password) }) {
                Text(text = "Login")
            }
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Don't have an account yet?"
            )
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(labelValue: String, painterResource: Painter) {
    var text by remember { mutableStateOf("") }
    return OutlinedTextField(
        value = text,
        leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },
        //trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
        onValueChange = {
            text = it
        },
        label = { Text(text = labelValue) },
        placeholder = { Text(text = labelValue) },
        modifier = Modifier.fillMaxWidth()
    )
}
