//package com.example.anorbank.presentation.auth.register.phone
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowRowScopeInstance.weight
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.windowInsetsEndWidth
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.Button
//import androidx.compose.material.Card
//import androidx.compose.material.Icon
//import androidx.compose.material.IconButton
//import androidx.compose.material.Scaffold
//import androidx.compose.material.Text
//import androidx.compose.material.TopAppBar
//import androidx.compose.material.icons.Icons
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.font.Font
//import androidx.compose.ui.text.font.FontFamily
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.example.anorbank.R
//import com.example.anorbank.presentation.auth.register.reg.StringInputField
//import com.example.anorbank.presentation.components.PhoneField
//import com.example.anorbank.ui.theme.Anor_dark
//import com.example.anorbank.ui.theme.Anor_light_grey
//import com.example.anorbank.presentation.components.PhoneField
//import com.example.anorbank.utils.spacers.SpacerHFourtyEight
//
//import com.example.anorbank.utils.spacers.SpacerHSixteen
//import com.example.anorbank.utils.spacers.SpacerHTwentyFour
//
//@Composable
//fun exxx() {
//    var cardNumber by rememberSaveable { mutableStateOf("") }
//    var expire by rememberSaveable { mutableStateOf("") }
//    var nameCard by rememberSaveable { mutableStateOf("") }
//    var isButtonEnabled = cardNumber.length == 16 &&
//            expire.length == 5 && nameCard.length > 2
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text("My App Title") },
//                navigationIcon = {
//                    IconButton(onClick = { /* Navigate back */ }) {
//                        Icon(painter = painterResource(id = R.drawable.ic_back_left), contentDescription = "Back")
//                    }
//                }
//            )
//        },
//        content = {
//
//
//            Box(modifier = Modifier.weight(1f))
//
//            Box(modifier = Modifier
//
//                .padding(it)
//                .fillMaxSize()
//                .background(color = Color.White)) {
//
//
//
//                Card(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(horizontal = 24.dp)
//                        .clip(shape = RoundedCornerShape(24.dp))
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .background(color = Anor_dark)
//                            .fillMaxSize()
//
//                    ) {
//                        SpacerHSixteen()
//
//                        Column(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(56.dp)
//                                .padding(horizontal = 24.dp)
//                                .background(
//                                    color = Anor_light_grey,
//                                    shape = RoundedCornerShape(16.dp)
//                                ),
//                        ) {
//
//
//
//                            PhoneField(cardNumber,
//                                modifier = Modifier.padding(start= 14.dp, end = 8.dp),
//                                mask = "0000 0000 0000 0000",
//                                maskNumber = '0',
//                                fontik = FontFamily(Font(R.font.monsbold)),
//                                onPhoneChanged = { cardNumber = it },
//                                hint = stringResource(id = R.string.add_card_number))
//
//                        }
//
//                        SpacerHSixteen()
//
//                        Column(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(56.dp)
//                                .padding(horizontal = 24.dp)
//                                .background(
//                                    color = Anor_light_grey,
//                                    shape = RoundedCornerShape(16.dp)
//                                ),
//                        ) {
//                            StringInputField(
//                                hint = stringResource(id = R.string.add_card_expire),
//                                text = nameCard,
//                                onValueChanged = { newText ->
//                                    nameCard = newText
//                                }
//                            )
//                            SpacerHTwentyFour()
//
//
//                        }
//
//                        SpacerHSixteen()
//
//                        Column(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(56.dp)
//                                .padding(horizontal = 24.dp)
//                                .background(
//                                    color = Anor_light_grey,
//                                    shape = RoundedCornerShape(16.dp)
//                                ),
//                        ) {
//                            StringInputField(
//                                hint = stringResource(id = R.string.add_card_name),
//                                text = nameCard,
//                                onValueChanged = { newText ->
//                                    nameCard = newText
//                                }
//                            )
//                            Spacer(
//                                modifier = Modifier
//                                    .height(24.dp)
//                                    .background(color = Anor_light_grey)
//                            )
//
//
//                        }
//
//                        Spacer(modifier = Modifier.height(16.dp))
//
//                        Button(modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(top = 16.dp)
//                            .height(48.dp)
//                            .padding(horizontal = 24.dp),
//                            enabled = isButtonEnabled,
//                            shape = RoundedCornerShape(16.dp),
//                            onClick = {
//
//                            }) {
//                            Text(
//                                modifier = Modifier.background(color = Color.Transparent),
//                                text = stringResource(id = R.string.btn_continue)
//                            )
//
//                        }
//
//
//                    }
//
//
//                }
//
//            }
//        }
//    )
//}
//
//@Preview
//@Composable
//fun exxprev() {
//    exxx()
//}