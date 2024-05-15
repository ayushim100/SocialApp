package com.example.stackoverflow.activity.ui.views

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stackoverflow.R
import com.example.stackoverflow.activity.ui.util.DummyData
import com.example.stackoverflow.activity.ui.util.Reel

val verticalPadding = 12.dp
val horizontalPadding = 10.dp

@Composable
fun ReelsView() {

}

@Composable
fun ReelsHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = horizontalPadding,
                vertical = verticalPadding
            ),
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Text("Reels", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 21.sp)
        Icon(
            bitmap = ImageBitmap.imageResource(id = R.drawable.outline_camera_alt_24),
            tint = Color.White,
            modifier = Modifier.size(24.dp),
            contentDescription = null
        )
    }
}

@Composable
fun ReelsList() {
    var dummyData = DummyData.reels
    LazyColumn{

    }
}

@Composable
fun ReelFooter() {
    Row {

    }
}

@Composable
fun FooterUserAction() {
    Column {

    }
}


@Composable
fun UserAction(
    @DrawableRes drawableRes: Int,
) {
    Icon(
        bitmap = ImageBitmap.imageResource(id=drawableRes),
        tint = Color.White,
        modifier = Modifier.size(28.dp),
        contentDescription = null
    )
}

@Composable
fun UserActionWithText(
    @DrawableRes drawableRes: Int,
    text: String
) {
    Icon(
        bitmap = ImageBitmap.imageResource(id=drawableRes),
        tint = Color.White,
        modifier = Modifier.size(28.dp),
        contentDescription = null
    )
    Spacer(modifier = Modifier.height(6.dp))
    Text(
        text = text,
        color = Color.White,
        fontWeight = FontWeight.SemiBold,
        fontSize = 13.sp
    )
}

@Composable
fun FooterUserData(
    reel: Reel
) {
    // Audio

    Row {

    }
}