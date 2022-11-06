package com.arysugiarto.jetcoffe.ui.component

import android.view.Menu
import android.view.MenuItem
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arysugiarto.jetcoffe.model.Category


@Composable
fun MenuItem(
    menu: com.arysugiarto.jetcoffe.model.Menu,
    modifier: Modifier = Modifier
){
        Card (
            modifier = modifier.width(140.dp),
            shape = RoundedCornerShape(8.dp)
            ){
            Column() {
                Image(painter = painterResource(menu.image), contentDescription =null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .clip(RoundedCornerShape(8.dp))
                )
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(text = menu.title, maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.ExtraBold
                    ) ,
                        
                    )
                    Text(text = menu.price,
                    style = MaterialTheme.typography.titleMedium)
                }
            }
        }
}

@Composable
@Preview(showBackground = true)
fun MenuItemPreview() {
    MaterialTheme {
        MenuItem(
            menu = com.arysugiarto.jetcoffe.model.Menu(
                com.arysugiarto.jetcoffe.R.drawable.menu2, "Hot Pumpkin Spice Latte Premium", "Rp 18.000"),
            modifier = Modifier.padding(8.dp)
        )

    }
}
