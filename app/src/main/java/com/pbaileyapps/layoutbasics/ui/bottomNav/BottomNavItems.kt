package com.pbaileyapps.layoutbasics.ui.bottomNav

import com.pbaileyapps.layoutbasics.R

sealed class BottomNavItems(
    val route: String,
    val name: String,
    val icon: Int
) {
    object Contacts : BottomNavItems("contacts", "Contacts", R.drawable.contacts)
    object Recent : BottomNavItems("recent", "Recent", R.drawable.recent)
    object Favorites : BottomNavItems("account", "Favorites", R.drawable.account)
}

val navItems = listOf(
    BottomNavItems.Contacts,
    BottomNavItems.Recent,
    BottomNavItems.Favorites
)