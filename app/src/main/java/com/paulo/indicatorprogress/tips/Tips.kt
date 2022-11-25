package com.paulo.indicatorprogress.tips

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.BackdropScaffoldState
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

//para não ter que ter vários remembers pela classe tido:
@Composable
fun BoringExample() {
    val scaffoldState = rememberScaffoldState()
    val scrollState = rememberScrollState()
    var shoudShowConfirmButton by remember {
        mutableStateOf(false)
    }
    /*
    MORE OTHERS REMEMBERS.....
     */
}

//FACA ISSO
class ExampleState(
    val scaffoldState: ScaffoldState,
    val scrollState: ScrollState
) {
    var counter by mutableStateOf(0)

    val shouldShowConfirmButton: Boolean
        get() = counter > 5

    suspend fun showSnackbar(message: String) {
        scaffoldState.snackbarHostState.showSnackbar(message)
    }
}

@Composable
fun rememberExampleState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    scrollState: ScrollState = rememberScrollState()
) = remember {
    ExampleState(scaffoldState, scrollState)
}

@Composable
fun NiceExample() {
    val exampleState = rememberExampleState()

    LaunchedEffect(key1 = exampleState.shouldShowConfirmButton) {
        if (exampleState.shouldShowConfirmButton) {
            exampleState.showSnackbar("This is very cool to state")
        }

    }
}