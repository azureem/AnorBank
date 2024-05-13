package com.example.anorbank.presentation.profile

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.screen.Screen
import com.example.anorbank.ui.theme.AnorBankTheme


class ProfileScreen: Screen {
    @Composable
    override fun Content() {

    }
}


@ExperimentalAnimationApi
@Composable
fun ProfileFun() {

}




@OptIn(ExperimentalAnimationApi::class)
@Composable
@Preview
fun ProfPrev(){
    AnorBankTheme {
       ProfileFun()
    }
}