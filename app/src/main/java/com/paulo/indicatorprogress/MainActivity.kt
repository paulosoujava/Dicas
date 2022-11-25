package com.paulo.indicatorprogress

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.input.pointer.pointerInput

import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.paulo.indicatorprogress.allscreen.ShowScreenSizes
import com.paulo.indicatorprogress.dialog.MainScreen
import com.paulo.indicatorprogress.dialog.MainViewModel
import com.paulo.indicatorprogress.dragDrop.DragableScreen
import com.paulo.indicatorprogress.ui.theme.IndicatorProgressTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()
    private val viewModelDrag = com.paulo.indicatorprogress.dragDrop.MainViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IndicatorProgressTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    /*HexagonSection(
                        backgroundColor =  Color.White,
                        modifier = Modifier.fillMaxSize(0.1f),
                        onScanButtonClick = {},
                        isScanning = true,
                        color = Color.Red
                    )*/

                    //Calendar()

                    //Clock()

                   // ShowBattery()

                    //ShowBarChart()

                    //ShowPieChart()

                    //ShowPicker()

                    //ShowCustomIndicator()

                    //MainScreen(viewModel)

                    /*DragableScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Black.copy(0.8f))
                    ) {
                        com.paulo.indicatorprogress.dragDrop.MainScreen(viewModelDrag)
                    }*/
                    ShowScreenSizes()

                }
            }
        }
    }
}



