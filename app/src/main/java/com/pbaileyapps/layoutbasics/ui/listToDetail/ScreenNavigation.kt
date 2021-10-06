package com.pbaileyapps.layoutbasics.ui.listToDetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pbaileyapps.layoutbasics.ui.listToDetail.CatsDestinations.CAT_DETAIL_ID_KEY

/**
 * Destinations used in the App.
 */
private object CatsDestinations {
    const val CATS_ROUTE = "cats"
    const val CAT_DETAIL_ROUTE = "cat"
    const val CAT_DETAIL_ID_KEY = "catId"
}

@Composable
fun CatsNavigation(
    startDestination: String = CatsDestinations.CATS_ROUTE
) {
    val navController = rememberNavController()
    val actions = remember(navController) { AppActions(navController) }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(
            CatsDestinations.CATS_ROUTE
        ) {
            CatsList(selectedCat = actions.selectedCat)
        }
        composable(
            "${CatsDestinations.CAT_DETAIL_ROUTE}/{$CAT_DETAIL_ID_KEY}",
            arguments = listOf(
                navArgument(CAT_DETAIL_ID_KEY) {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            CatDetails(
                catId = arguments.getInt(CAT_DETAIL_ID_KEY),
                navigateUp = actions.navigateUp
            )
        }
    }
}

private class AppActions(
    navController: NavHostController
) {
    val selectedCat: (Int) -> Unit = { catId: Int ->
        navController.navigate("${CatsDestinations.CAT_DETAIL_ROUTE}/$catId")
    }
    val navigateUp: () -> Unit = {
        navController.navigateUp()
    }
}