package com.meenotek.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meenotek.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

val GrotesqueFontFamily = FontFamily(
    Font(R.font.galano_grotesque_alt_semi_bold)
)

val backgroundColor = Color(0xFFD2E8D4)
val transparentBlack = Color(0xD9000000)
val darkGreen = Color(0xFF006D3B)
val darkBlue = Color(0xFF073042)
val lightGreen = Color(0xFF30DC80)
val moddedBlack = Color(0xD9140505)

@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally


    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Column(
            Modifier.fillMaxHeight(0.7f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            AndroidLogo()
            Spacer(modifier = Modifier.height(16.dp))
            AboutText(
                name = stringResource(R.string.name),
                about = stringResource(R.string.about),
                description = stringResource(R.string.description)
            )
            Spacer(modifier = Modifier.height(130.dp))
            Contact()
        }
    }
}

@Composable
fun AndroidLogo() {
    Column(
        modifier = Modifier
            .background(darkBlue)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = R.drawable.android),
            contentDescription = stringResource(R.string.android_logo),
            tint = lightGreen
        )
        Text(
            text = stringResource(R.string.android),
            fontFamily = GrotesqueFontFamily,
            fontWeight = FontWeight(400),
            fontSize = 21.sp,
            color = Color.White
        )
    }
}

@Composable
fun AboutText(
    name: String,
    about: String,
    description: String,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = name,
            fontFamily = FontFamily.SansSerif,
            color = transparentBlack,
            fontSize = 48.sp,
            fontWeight = FontWeight.Light,
            )
        Text(
            text = about,
            fontFamily = FontFamily.SansSerif,
            fontSize = 25.sp,
            fontWeight = FontWeight.Light,
            color = moddedBlack,
        )
        Text(
            text = description,
            fontFamily = FontFamily.SansSerif,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = darkGreen,
        )
    }
}

@Composable
fun Contact() {
    Column(
        Modifier
            .wrapContentWidth(),
        verticalArrangement = Arrangement.spacedBy(18.dp, Alignment.Top)
    ) {
        ContactItem(
            icon = painterResource(id = R.drawable.call),
            info = "(+234)-804-0214-419"
        )
        ContactItem(
            icon = painterResource(id = R.drawable.share),
            info = "@lilmeeno"
        )
        ContactItem(
            icon = painterResource(id = R.drawable.email) ,
            info = "shokoya01@gmail.com"
        )
    }
}

@Composable
fun ContactItem(
    icon: Painter,
    info: String,
    iconColor: Color = darkGreen,
    textColor: Color = transparentBlack,
) {
    Row(
        Modifier.wrapContentWidth(),
        horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon,
            tint = iconColor,
            contentDescription = null
        )
        Text(
            text = info,
            color = textColor
        )
    }
}



@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}