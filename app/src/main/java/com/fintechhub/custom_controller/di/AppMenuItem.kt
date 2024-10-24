package com.fintechhub.custom_controller.di

import com.fintechhub.custom_controller.R
import javax.inject.Inject

class AppMenuItem @Inject constructor(val key: MenuKey) {
    enum class MenuKey(
        val titleStringId: Int,
        val iconDrawableId: Int,
        val navigation: Int,
        val secured: Boolean
    ) {
        OPEN_ACCOUNT(
            R.string.Open ,
            R.drawable.baseline_offline_pin_24,
            R.string.open_account,
            true
        ),
        PROFILE(
            R.string.menu_title_profile,
            R.drawable.baseline_person_24,
            R.string.profile,
            true
        ),
        NAV_PROFILE(
            R.string.menu_title_profile,
            R.drawable.baseline_offline_pin_24,
            R.string.nav_profile,
            true
        ),
        ACCOUNTS(
            R.string.menu_title_accounts,
            R.drawable.baseline_home_24,
            R.string.accounts,
            true
        );

    }

}
