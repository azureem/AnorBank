package com.example.anorbank.zed.expendables.home_ex
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.anorbank.R
import com.example.anorbank.presentation.components.TextCompoRed
import com.example.anorbank.presentation.main.cards.item_cards.ItemPrimaryFun
import com.example.anorbank.presentation.main.home.MainContract
import com.example.anorbank.ui.theme.AnorBankTheme
import com.example.anorbank.ui.theme.Anor_grey
import com.example.anorbank.utils.spacers.SpacerHEight
import com.example.anorbank.utils.spacers.SpacerHSixteen
import com.example.anorbank.utils.spacers.SpacerHTwentyFour
import com.example.anorbank.utils.spacers.SpacerWEight


@Composable
fun MyCard2(onEventDispatcher :(MainContract.MyIntent)->Unit,
            uiState: MainContract.UiState) {

    var isExpanded by rememberSaveable {
        mutableStateOf(false)
    }
    var amount = remember{ mutableStateOf(0) }

        Column(modifier = Modifier
            .clip(shape = RoundedCornerShape(18.dp))
            .background(color = Color.White)
            .clickable {
                isExpanded = !isExpanded
            }) {

            SpacerHEight()

            Row(modifier = Modifier.fillMaxWidth()) {
                SpacerWEight()
                Text(
                    text = stringResource(id = R.string.ex_cards),
                    modifier = Modifier
                        .padding(top = 6.dp, start = 12.dp),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.monsbold)),
                    color = Anor_grey
                )
                if (!isExpanded) {
                    Image(
                        modifier = Modifier
                            .size(42.dp)
                            .padding(12.dp),
                        painter = painterResource(id = R.drawable.ic_hamburger),
                        contentDescription = null
                    )
                } else {
                    Image(
                        modifier = Modifier
                            .size(42.dp)
                            .padding(12.dp),
                        painter = painterResource(id = R.drawable.ic_hamburger_bottom),
                        contentDescription = null
                    )
                    Text(
                        text = stringResource(id = R.string.all),
                        modifier = Modifier
                            .padding(top = 11.dp, end = 24.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.End,
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.monsbold)),
                        color = Anor_grey
                    )
                }
            }
            // agar listning sizsiga qarab if da tekshirish kerak, agar size bor bolsa addCard korinishi kerak emas,
            //agar list kerak bosa
            if (uiState is MainContract.UiState.EmptyState){
                AddCards(onEventDispatcher)
            }else if (uiState is MainContract.UiState.CardLists){
                val cardList = (uiState as MainContract.UiState.CardLists).cards
                AnimatedVisibility(visible = isExpanded) {

                    Column(modifier = Modifier.fillMaxWidth()) {
                        var sum = 0
                        for (card in cardList){
                            sum+=card.amount
                            ItemPrimaryFun(name = card.name, pan =card.pan , amount = card.amount)
                        }

                    }
                }
            }
            SpacerHTwentyFour()
     }
}


//@Composable
//@Preview
//fun PrevMyCardssss() {
//    AnorBankTheme {
//        MyCard2()
//    }
//}

@Composable
fun AddCardsss(onEventDispatcher :(MainContract.MyIntent)->Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .clickable {
                    onEventDispatcher.invoke(MainContract.MyIntent.OpenAddCard)
                }
                .align(Alignment.TopCenter)
        ) {
            Image(modifier = Modifier.size(18.dp)
                .clickable {
                    onEventDispatcher.invoke(MainContract.MyIntent.OpenAddCard)
                },
                painter = painterResource(id = R.drawable.ic_add_card),

                contentDescription = null,


                )
            SpacerWEight()
            TextCompoRed(modifier = Modifier
                .clickable {
                onEventDispatcher.invoke(MainContract.MyIntent.OpenAddCard)
            },
                fontSize = 14.sp,
                fontik = FontFamily(Font(R.font.monsbold)),
                text = stringResource(id = R.string.add_cards)
            )
        }
    }
}