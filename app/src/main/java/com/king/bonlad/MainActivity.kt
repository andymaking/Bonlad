package com.king.bonlad

import android.content.res.AssetManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.king.bonlad.ui.theme.BonladTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BonladTheme {
                    Boniad("Android")
        }
    }
}


@Composable
fun Boniad() {
    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.backdrop), contentDescription = "BACK", Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds)
    }
    Column(modifier = Modifier.fillMaxSize()){
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = { /*TODO*/ }, modifier = Modifier
                .clip(RectangleShape)
                .height(50.dp)
                .width(50.dp), colors = ButtonDefaults.buttonColors(Color.Transparent), elevation = ButtonDefaults.elevation(0.dp)) {
                Icon(painter = painterResource(id = R.drawable.left), contentDescription = "", tint = Color.White, modifier = Modifier.height(60.dp).width(60.dp))
            }
            Text(text = "Log in", modifier = Modifier
                .weight(1.0F)
                .padding(0.dp, 15.dp, 20.dp, 0.dp), textAlign = TextAlign.End, color = Color.White)
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .height(250.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "Boniad", fontSize = 50.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
        TextFieldView()
        Spacer(modifier = Modifier.height(100.dp))
        Buttun()
        Spacer(modifier = Modifier.height(20.dp))
        Account()
    }
}

@Composable
fun TextFieldView(){
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
        val textState = remember { mutableStateOf(TextFieldValue()) }
        OutlinedTextField(value = textState.value, onValueChange = { textState.value = it },
            Modifier.fillMaxWidth(0.9F),
            label = { Text(text = "User Name", fontSize = 20.sp, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, color = Color.White)},
            leadingIcon = { Image(painter = painterResource(id = R.drawable.person), contentDescription = "")},
            trailingIcon = { },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,autoCorrect = true, keyboardType = KeyboardType.Text, imeAction = ImeAction.Done
            ),
            maxLines = 1
        )
    }

    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
        val passwordState = remember { mutableStateOf(TextFieldValue()) }
        val passwordVisibility = remember { mutableStateOf(true) }
        OutlinedTextField(value = passwordState.value, onValueChange = { passwordState.value = it },
            Modifier.fillMaxWidth(0.9F),
            label = { Text(text = "Password", fontSize = 20.sp, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, color = Color.White)},
            leadingIcon = { Image(painter = painterResource(id = R.drawable.ic_baseline_vpn_key_24), contentDescription = "")},
            trailingIcon = { },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,autoCorrect = false, keyboardType = KeyboardType.Password, imeAction = ImeAction.Done
            ),
            maxLines = 1,
            singleLine = true,
            visualTransformation = if (passwordVisibility.value) PasswordVisualTransformation() else VisualTransformation.None

        )
    }
}

@Composable
fun Buttun(){
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
        Button(onClick = { /*TODO*/ }, modifier = Modifier
            .clip(CircleShape)
            .height(30.dp)
            .width(120.dp), colors =ButtonDefaults.buttonColors(Color(159, 166, 179)), elevation = ButtonDefaults.elevation(25.dp)) {
            Icon(painter = painterResource(id = R.drawable.ic_baseline_login_24), contentDescription ="", tint = Color.White )
        }
    }
}

@Composable
fun Account(){
    Row(Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center) {
        Text(text = "You don't have an account? ", color = Color.White)
        Text(text = "SignUp!", fontWeight = FontWeight.Bold, modifier = Modifier.clickable(enabled = true, onClick = {}), color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BonladTheme {
        Boniad("Android")
    }

}}