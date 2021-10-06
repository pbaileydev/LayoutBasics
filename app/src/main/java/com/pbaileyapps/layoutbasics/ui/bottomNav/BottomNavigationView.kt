package com.pbaileyapps.layoutbasics.ui.bottomNav

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pbaileyapps.layoutbasics.ui.theme.LayoutBasicsTheme


@ExperimentalFoundationApi
@Composable
fun BottomNavigationView() {

    Scaffold(
        topBar = {
            TopAppBar(
                { SearchBar() }, backgroundColor = Color.Transparent
            )
        }, bottomBar = { BottomNavigationBar() }
    ) {
        NavigationHost()
    }
}

@Composable
fun BottomNavigationBar(
    navController: NavController = rememberNavController(),
    items: List<BottomNavItems> = navItems
) {

    BottomNavigation {

        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination

        items.forEach { navItem ->

            BottomNavigationItem(
                label = {
                    Text(navItem.name)
                },
                selected = currentRoute?.hierarchy?.any {
                    navItem.route == it.route
                } == true,
                alwaysShowLabel = true,
                icon = {
                    Icon(
                        painterResource(id = navItem.icon),
                        contentDescription = navItem.name,
                    )
                },
                onClick = {
                    navController.navigate(navItem.route) {
                        launchSingleTop = true
                        restoreState = true
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                    }
                }
            )
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun NavigationHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItems.Contacts.route
    ) {
        composable(BottomNavItems.Favorites.route) {
            FavoriteContactsScreen()
        }

        composable(BottomNavItems.Contacts.route) {
            ContactsScreen()
        }

        composable(BottomNavItems.Recent.route) {
            RecentContactsScreen()
        }
    }
}

@ExperimentalFoundationApi
@Preview(widthDp = 360, heightDp = 64)
@Composable
fun BottomNavViewPreview() {
    LayoutBasicsTheme(darkTheme = true) {
        BottomNavigationBar()
    }
}