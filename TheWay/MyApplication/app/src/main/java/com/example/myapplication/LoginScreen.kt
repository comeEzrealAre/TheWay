package com.example.myapplication

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController){

    var email by remember {
        mutableStateOf( "")
    }

    var password by remember {
        mutableStateOf( "")
    }

    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xffd7f5f1)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){

        Spacer(modifier = Modifier.height(36.dp))

        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Login image",
            modifier = Modifier.size(260.dp))

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Bem-vindo!", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(4.dp))

        Text(text = "Entre na sua conta")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = email, onValueChange = {
           email = it
        }, label = {
            Text(text = "Endereço de E-mail")
        })

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = password, onValueChange = {
            password = it},
            label = {
            Text(text = "Senha")
        }, visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate(Routes.screenHome) }) {
            Text(text = "Entrar")
        }

        Spacer(modifier = Modifier.height(14.dp))

        TextButton(onClick = {
            Log.i("Credential", "Email : $email Password : $password")
        }) {
            Text(text = "Esqueceu a senha?")
        }

        Spacer(modifier = Modifier.height(6.dp))

        Text(text = "Ou cria sua conta com")

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(35.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Image(painter = painterResource(id = R.drawable.google),
                contentDescription = "Google",
                modifier = Modifier
                    .size(60.dp)
                    .clickable {
                        //Google clicked
                    }
            )

            Image(painter = painterResource(id = R.drawable.fb),
                contentDescription = "Facebook",
                modifier = Modifier
                    .size(60.dp)
                    .clickable {
                        //Facebook clicked
                    }
            )

            Image(painter = painterResource(id = R.drawable.x),
                contentDescription = "XTwitter",
                modifier = Modifier
                    .size(60.dp)
                    .clickable {
                        //XTwitter clicked
                    }
            )
        }
    }
}