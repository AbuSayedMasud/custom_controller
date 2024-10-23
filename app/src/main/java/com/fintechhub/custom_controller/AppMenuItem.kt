package com.fintechhub.custom_controller

import android.content.Context

class AppMenuItem(context: Context, val key: MenuKey) {
    val isSecured: Boolean
        get() = this.key.secured

    val iconId: Int
        get() = this.key.iconDrawableId

    val nav: Int
        get() = this.key.navigation

    val title: Int
        get() = this.key.titleStringId


    enum class MenuKey(
        val titleStringId: Int,
        val iconDrawableId: Int,
        val navigation: Int,
        val secured: Boolean
    ) {
        OPEN_ACCOUNT(
            R.string.menu_title_profile,
            R.drawable.ic_launcher_background,
            R.string.open_account,
            true
        ),
        PROFILE(
            R.string.menu_title_profile,
            R.drawable.ic_launcher_background,
            R.string.profile,
            true
        ),
        NAV_PROFILE(
            R.string.menu_title_profile,
            R.drawable.ic_launcher_background,
            R.string.nav_profile,
            true
        ),
        ACCOUNTS(
            R.string.menu_title_accounts,
            R.drawable.ic_launcher_background,
            R.string.accounts,
            true
        );

    }
}