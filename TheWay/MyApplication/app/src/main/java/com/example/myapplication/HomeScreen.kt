@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.myapplication


import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Map
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.ImeAction.Companion.Search
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    var search by remember {
        mutableStateOf( "")
    }

    var active by remember {
        mutableStateOf( false)
    }

    var items = remember {
            mutableStateListOf(
                "Estação Sacomã - Praça Altemar Dutra - Ipiranga, São Paulo - SP, 04203-053",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                "Paço Municipal -SBC, Praça Samuel Sabatini, S/N - Centro, São Bernardo do Campo - SP, 09810-390",
                "Donec erat justo, cursus ut metus non, dignissim tristique quam"
            )
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
            //.background(Color(0xffd7f5f1)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(title = { Text(
            text = "TheWay",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            color = Color( 0xff009fff),
            fontFamily = FontFamily.Serif,
        ) },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xffd7f5f1)))
        
        SearchBar(
            modifier = Modifier.fillMaxWidth(),
            query = search,
            onQueryChange = {
                search = it
            },
            onSearch =  {
                items.add(search)
                active = false
                search = ""
            },
            active = active,
            onActiveChange = {
                active = it
            },
            placeholder = {
                Text(text = "Digite o seu destino", fontStyle = FontStyle.Italic )
            },
            leadingIcon = {
                IconButton(onClick = { navController.navigate(Routes.screenMap) }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
                }

            },
            trailingIcon = {
                if(active) {
                    Icon(
                        modifier = Modifier.clickable {
                            if(search.isNotEmpty()) {
                                search = ""
                                navController.navigate(Routes.screenMap)
                            } else {
                                active = false
                                navController.navigate(Routes.screenMap)
                            }

                        },
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close Icon"
                    )
                }
            }
            ) {
            items.forEach{
                Row(modifier = Modifier.padding(all = 14.dp)) {
                    Icon(
                        modifier = Modifier.padding(end = 10.dp),
                        imageVector = Icons.Default.History,
                        contentDescription = "History Icon"
                    )
                    Text(text = it)
                }

            }
        }

        Scaffold(
            bottomBar = {
                BottomAppBar(modifier = Modifier) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(1.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ){
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                modifier = Modifier
                                    .size(36.dp),
                                imageVector = Icons.Rounded.Home,
                                contentDescription = "History Icon",

                                )
                        }


                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                modifier = Modifier
                                    .size(36.dp),
                                imageVector = Icons.Rounded.Map,
                                contentDescription = "History Icon",
                            )
                        }


                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                modifier = Modifier
                                    .size(36.dp),
                                imageVector = Icons.Rounded.AccountCircle,
                                contentDescription = "History Icon",
                            )
                        }

                    }
                }
            },
        ) { PaddingValues(

        )

        }
    }


}
