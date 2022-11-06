package com.arysugiarto.jetcoffe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arysugiarto.jetcoffe.model.Menu
import com.arysugiarto.jetcoffe.model.dummyBestSellerMenu
import com.arysugiarto.jetcoffe.model.dummyCategory
import com.arysugiarto.jetcoffe.model.dummyMenu
import com.arysugiarto.jetcoffe.ui.component.CategoryItem
import com.arysugiarto.jetcoffe.ui.component.HomeSection
import com.arysugiarto.jetcoffe.ui.component.MenuItem
import com.arysugiarto.jetcoffe.ui.component.SearchBar
import com.arysugiarto.jetcoffe.ui.theme.JetcoffeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetcoffeTheme {
                JetCoffeeApp()
            }
        }
    }
}


@Composable
fun JetCoffeeApp() {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Banner()
            HomeSection(
                title = stringResource(R.string.section_category),
                    content = { CategoryRow() }
            )
            HomeSection(stringResource(R.string.section_best_seller_menu), Modifier) {
                MenuRow(dummyMenu)
            }
            HomeSection(stringResource(R.string.section_best_seller_menu)) {
                MenuRow(dummyBestSellerMenu)
            }
        }
}

@Composable
fun Banner(
    modifier: Modifier = Modifier,
){
    Box(modifier = Modifier) {
        Image(painter = painterResource(R.drawable.banner), contentDescription = "Banner Coffe",
        contentScale = ContentScale.Crop,
        modifier = Modifier.height(160.dp)
        )
        SearchBar()
    }
}

@Composable
fun CategoryRow(
    modifier: Modifier = Modifier
){
    LazyRow(
        modifier = modifier.padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(dummyCategory, key = { it.textCategory }) { category ->
            CategoryItem(category)
        }
    }
}

@Composable
fun MenuRow(
    listMenu: List<Menu>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(listMenu, key = { it.title }) { menu ->
            MenuItem(menu)
        }
    }
}



@Composable
@Preview(showBackground = true)
fun CategoryRowPreview() {
    JetcoffeTheme {
        CategoryRow()
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun JetCoffeeAppPreview() {
    JetcoffeTheme {
        JetCoffeeApp()
    }
}