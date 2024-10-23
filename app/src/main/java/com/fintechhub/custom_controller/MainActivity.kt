package com.fintechhub.custom_controller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fintechhub.custom_controller.ui.theme.Custom_controllerTheme

class MainActivity : ComponentActivity() {
    private var mAppMenuItems: List<AppMenuItem>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Assuming getAppMenus returns a list of AppMenuItems
        mAppMenuItems = AppControlller().getAppMenus(context = this)

        setContent {
            Custom_controllerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Pass the list of AppMenuItems to the composable function
                    mAppMenuItems?.let { menuItems ->
                        MenuList(menuItems = menuItems, modifier = Modifier.padding(innerPadding))
                    } ?: Text(text = "No Menu Items Found", modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MenuList(menuItems: List<AppMenuItem>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(menuItems) { menuItem ->
            MenuItemView(menuItem)
        }
    }
}

@Composable
fun MenuItemView(menuItem: AppMenuItem) {
    Text(text = "Menu Item: ${menuItem.key.name}")
}

