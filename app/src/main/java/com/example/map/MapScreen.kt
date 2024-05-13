package com.example.map
import android.os.Parcel
import android.os.Parcelable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.example.anorbank.R
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
class MapScreen : Screen {
    @Composable
    override fun Content() {
        MapDefault()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MapDefault() {
    val zoom = remember { mutableStateOf(15f) }
    val markerState = rememberMarkerState(position = LatLng(40.43583579731076, 71.76760348734709), key = "Ferghana")
    val list = remember {
        listOf(
            MapingInfo(position = LatLng(40.62639916254996, 71.0268272111014), "AnorBank", "+998950170069", R.drawable.ic_chat)
        )
    }

    val selectedMarker = remember { mutableStateOf<MapingInfo?>(null) }

    Box(modifier = Modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = rememberCameraPositionState(),
            properties = MapProperties(isMyLocationEnabled = true),
            uiSettings = MapUiSettings(zoomControlsEnabled = true)
        ) {
            list.forEach { markerInfo ->
                val myMarkerState = rememberMarkerState(position = markerInfo.position)

                Marker(
                    myMarkerState,
                    onClick = {
                        selectedMarker.value = markerInfo
                        true
                    }
                )
            }
        }

        selectedMarker.value?.let { markerInfo ->
            ModalBottomSheetLayout(
                sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Expanded),
                sheetContent = {
                    BottomSheetContent(
                        modifier = Modifier.fillMaxWidth(),
                        markerInfo = markerInfo,
                        onClose = { selectedMarker.value = null }
                    )
                },
                content = { }
            )
        }
    }
}

@Composable
fun BottomSheetContent(
    modifier: Modifier,
    markerInfo: MapingInfo,
    onClose: () -> Unit
) {
    Card(
        modifier = modifier.padding(16.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Name: ${markerInfo.name}",
                style = MaterialTheme.typography.subtitle1
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Phone: ${markerInfo.phone}",
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = onClose,
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = "Close")
            }
        }
    }
}

@Preview
@Composable
fun prevMap() {
    MapDefault()
}

data class MapingInfo(
    val position: LatLng, val name: String, val phone: String, val img: Int
)