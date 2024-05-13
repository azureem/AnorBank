package com.example.anorbank.presentation.main.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.example.anorbank.R
import com.example.anorbank.presentation.main.home.components.ItemData
import com.example.anorbank.presentation.main.home.components.LazyInTop
import com.example.anorbank.presentation.main.home.components.Tops
import com.example.anorbank.presentation.main.home.components.TxtSimpleWhite
import com.example.anorbank.ui.theme.Anor_grey
import com.example.anorbank.utils.spacers.SpacerHSixteen
import com.example.anorbank.utils.spacers.SpacerHThirtyTwo
import com.example.anorbank.zed.expendables.home_ex.CashBack
import com.example.anorbank.zed.expendables.home_ex.Credits
import com.example.anorbank.zed.expendables.home_ex.Homchik
import com.example.anorbank.zed.expendables.home_ex.MyCards
import com.example.anorbank.zed.expendables.home_ex.MyHome
import com.example.anorbank.zed.expendables.home_ex.Podskazki
import com.example.anorbank.zed.expendables.home_ex.Rassrochki
import com.example.anorbank.zed.expendables.home_ex.Saves
import com.example.anorbank.zed.expendables.home_ex.Valyuta
import com.example.anorbank.zed.expendables.home_ex.Vkladi

class MainScreen : Screen {
    @RequiresApi(Build.VERSION_CODES.Q)
    @Composable
    override fun Content() {
        MainsFun()
    }
}


@OptIn(ExperimentalAnimationApi::class)
@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun MainsFun() {
    val resources = LocalContext.current.resources
    val itemList = listOf(
        ItemData(img = R.drawable.item_1, text = resources.getString(R.string.home_item1)),
        ItemData(R.drawable.item_2, text = resources.getString(R.string.home_item2)),
        ItemData(R.drawable.item_3, text = resources.getString(R.string.home_item3)),
        ItemData(R.drawable.item_4, text = resources.getString(R.string.home_item4)),
        ItemData(R.drawable.item_4, text = resources.getString(R.string.home_item5)),
        ItemData(R.drawable.item_4, text = resources.getString(R.string.home_item6)),
        ItemData(R.drawable.item_4, text = resources.getString(R.string.home_item7)),
        ItemData(R.drawable.item_4, text = resources.getString(R.string.home_item8)),
        ItemData(R.drawable.item_4, text = resources.getString(R.string.home_item9)),
        ItemData(R.drawable.item_4, text = resources.getString(R.string.home_item1)),
        ItemData(R.drawable.item_4, text = resources.getString(R.string.home_item1)),
        ItemData(R.drawable.item_4, text = resources.getString(R.string.home_item1))
    )
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            Tops()
        }) {
        LazyColumn(modifier = Modifier.padding(it)) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(240.dp)
                        .clip(shape = RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                ) {
                    Image(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .fillMaxSize(),
                        painter = painterResource(id = R.drawable.ic_backgound),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                    Column (modifier = Modifier.fillMaxSize()){

                        SpacerHSixteen()
                        TxtSimpleWhite(modifier = Modifier.padding(start =24.dp),
                            text = stringResource(id = R.string.home_balance),
                            fontSize = 16.sp ,
                            fontik = FontFamily(Font(R.font.monsbold))
                        )
                        SpacerHSixteen()

                        TxtSimpleWhite(modifier = Modifier.padding(start =24.dp),
                            text = stringResource(id = R.string.home_balance),
                            fontSize = 16.sp ,
                            fontik = FontFamily(Font(R.font.monsbold))
                        )

                        LazyInTop(data = itemList)
                        SpacerHThirtyTwo()

                    }
                }
            }
            item {
                ClientItem()
            }
            item {
                CashBack()
            }


            item {
                Podskazki()
            }

            item {
                MyCards()
            }

            item {
                Saves()
            }

            item {
                Rassrochki()
            }

            item {
                Credits()
            }

            item {
                Vkladi()
            }

            item {
                MyHome()
            }

            item {
                Valyuta()
            }

        }

    }


}

@RequiresApi(Build.VERSION_CODES.Q)
@Preview
@Composable
fun PrevMains() {
    MainsFun()
}


@Composable
fun ClientItem() {

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(18.dp)
        .height(102.dp)
        .clip(shape = RoundedCornerShape(16.dp))){
        Image(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxSize(),
            painter = painterResource(id = R.drawable.ic_become_client),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )


      //  Row (modifier = Modifier.fillMaxSize().align(Alignment.Center)){

//            Image(modifier = Modifier.weight(1f),painter = painterResource(id = R.drawable.ic_become_client),
//                contentDescription =null )

            Text(modifier = Modifier.align(Alignment.Center),
                text = stringResource(id = R.string.client), fontSize = 16.sp,
                color = Anor_grey,
                fontFamily = FontFamily(Font(R.font.monsbold)) )

//            Image(modifier = Modifier.weight(1f),
//                painter = painterResource(id = R.drawable.ic_hamburger),
//                contentDescription =null )
      //  }
    }
    
}