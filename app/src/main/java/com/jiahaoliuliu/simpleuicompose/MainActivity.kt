package com.jiahaoliuliu.simpleuicompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jiahaoliuliu.simpleuicompose.theme.ComposeTutorialTheme

data class Message(val author: String, val body: String)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            MessageCard(Message("Android", "Jetpack Compose"))
            ComposeTutorialTheme {
                MessageCard(Message("Android", "Jetpack Compose"))
            }
        }
    }

    @Composable
    fun MessageCard(msg: Message) {
//        Row {
//            Image(
//                painter = painterResource(id = R.drawable.photo),
//                contentDescription = "Contact profile picture"
//            )
//        }

        // Add padding around our message
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.photo),
                contentDescription = "Contact profile picture",
                modifier = Modifier
                    // Set image size to 40dp
                    .size(40.dp)
                    // Clip image to be shaped as a circle
                    .clip(CircleShape)
            )

            // Add a horizontal space between the image and the column
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = msg.author)
                // Add a vertical space between the author and message texts
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = msg.body)
            }
        }
    }

    @Preview
    @Composable
    fun PreviewMessageCard() {
        ComposeTutorialTheme {
            MessageCard(
                msg = Message("Colleague", "Hey, take a look at Jetpack Compose, it's great")
            )
        }
    }
}