package com.fintechhub.custom_controller

import android.content.Context

class AppControlller {
    fun getAppMenus(context: Context): MutableList<AppMenuItem> {
        val appMenuItems = mutableListOf<AppMenuItem>()
        appMenuItems.add(AppMenuItem(context, AppMenuItem.MenuKey.PROFILE))
        appMenuItems.add(AppMenuItem(context, AppMenuItem.MenuKey.ACCOUNTS))
        appMenuItems.add(AppMenuItem(context, AppMenuItem.MenuKey.NAV_PROFILE))
//        appMenuItems.add(AppMenuItem(context, AppMenuItem.MenuKey.OPEN_ACCOUNT))
        return appMenuItems
    }

}