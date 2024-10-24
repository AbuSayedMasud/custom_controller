package com.fintechhub.custom_controller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.fintechhub.custom_controller.di.AppMenuItem
import com.fintechhub.custom_controller.screen.AccountScreen
import com.fintechhub.custom_controller.screen.NavProfile
import com.fintechhub.custom_controller.screen.OpenAccount
import com.fintechhub.custom_controller.screen.ProfileScreen
import com.fintechhub.custom_controller.ui.theme.Custom_controllerTheme
import com.fintechhub.custom_controller.viewModel.MenuViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Custom_controllerTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Custom Controller", color = Color.Black)
                            },
                        )
                    }
                ) {
                    Box(modifier = Modifier.padding(it)) {
                        App()
                    }
                }
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "menu"){
        composable(route = "menu"){
            MenuScreen(navController)
        }
        composable(route = "profile"){
            ProfileScreen(navController)
        }
        composable(route = "accounts"){
            AccountScreen(navController)
        }
        composable(route = "nav_profile"){
            NavProfile(navController)
        }
        composable(route = "open_account"){
            OpenAccount(navController)
        }
    }
}
@Composable
fun MenuScreen(navController: NavHostController) {
    val context = LocalContext.current
    val menuViewModel: MenuViewModel = hiltViewModel()
    val appMenus by menuViewModel.appMenus.observeAsState(emptyList())
    LaunchedEffect(Unit) {
        menuViewModel.loadAppMenus(context)
    }

    LazyColumn {
        items(appMenus) { menuItem ->
            MenuItemView(menuItem) {
                navController.navigate(context.getString(menuItem.key.navigation))
            }
        }
    }
}

@Composable
fun MenuItemView(menuItem: AppMenuItem, onClick: () -> Unit = {}) {
    val context = LocalContext.current
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = menuItem.key.iconDrawableId),
            contentDescription = "test",
            Modifier
                .size(30.dp)
                .padding(start = 10.dp),
            contentScale = ContentScale.Crop, colorFilter = ColorFilter.tint(Color.Blue)
        )
        Text(
            text = context.getString(menuItem.key.titleStringId),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable(onClick = onClick)
        )

    }

}



