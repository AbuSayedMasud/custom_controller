package com.fintechhub.custom_controller.repository

import android.content.Context
import com.fintechhub.custom_controller.di.AppMenuItem
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AppController @Inject constructor(@ApplicationContext context: Context) {
    fun getAppMenus(context: Context): MutableList<AppMenuItem> {
        val appMenuItems = mutableListOf<AppMenuItem>()
        appMenuItems.add(AppMenuItem(AppMenuItem.MenuKey.PROFILE))
        appMenuItems.add(AppMenuItem(AppMenuItem.MenuKey.ACCOUNTS))
//        appMenuItems.add(AppMenuItem(AppMenuItem.MenuKey.NAV_PROFILE))
        appMenuItems.add(AppMenuItem(AppMenuItem.MenuKey.OPEN_ACCOUNT))
        return appMenuItems
    }
}