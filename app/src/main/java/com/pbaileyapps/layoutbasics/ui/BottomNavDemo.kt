package com.pbaileyapps.bottomnavcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pbaileyapps.bottomnavcompose.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainView()
        }
    }
}
@Composable
fun MainView(){
    val navController = rememberNavController()
    Scaffold(topBar = {TopAppBar(
        title = { Text(text = "BottomNavDemo") },
    )},bottomBar = {BottomNav(navController = navController)}){
    NavigationHost(navController = navController)
    }
}
@Composable
fun BottomNav(navController: NavController) {
    val items = listOf(NavItem.contacts, NavItem.account)
    BottomNavigation() {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.value?.destination
        items.forEach({screen ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = screen.icon), contentDescription = screen.name) },
                label={Text(screen.name)},
                selected = currentRoute?.hierarchy?.any { screen.route == it.route } == true,
                alwaysShowLabel = true,
                onClick = {
                    navController.navigate(screen.route) {

                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }

                        launchSingleTop = true

                        restoreState = true
                    }

                })
        })
    }
}
@Composable
fun NavigationHost(navController:NavHostController) {
    NavHost(navController, startDestination = NavItem.contacts.route) {
        composable(NavItem.account.route) {
            AccountScreen()
        }

        composable(NavItem.contacts.route) {
            var names = ArrayList<String>()
            names.add("Jake")
            names.add("Kayla")
            names.add("Maria")
            names.add("Peter")
            names.add("Tyler")

            ContactsScreen(names)
        }

    }
}


@Composable
fun AccountScreen() {

    Column(modifier = Modifier
        .fillMaxSize()
        .background(grey900),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(30.dp)) {
             Image(painter= painterResource(id = R.drawable.account),contentDescription = "Profile Image",
             modifier= Modifier
                 .height(60.dp)
                 .width(60.dp))
            Text("Name: John Doe",color = Color.White,style=MaterialTheme.typography.h4)
        Row(modifier= Modifier
            .fillMaxWidth()
            .height(60.dp),horizontalArrangement = Arrangement.SpaceEvenly){
            Image(painter= painterResource(id = R.drawable.phone),contentDescription = "Phone",
                modifier= Modifier
                    .padding(5.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(grey700)
                    .height(70.dp)
                    .width(60.dp))
            Image(painter= painterResource(id = R.drawable.message),contentDescription = "Message",
                modifier= Modifier
                    .padding(5.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(grey700)
                    .height(70.dp)
                    .width(60.dp))
            Image(painter= painterResource(id = R.drawable.email),contentDescription = "Email",
                modifier= Modifier
                    .padding(5.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(grey700)
                    .height(70.dp)
                    .width(60.dp))
            Image(painter= painterResource(id = R.drawable.video_chat),contentDescription = "Video Chat",
                modifier= Modifier
                    .padding(5.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(grey700)
                    .height(70.dp)
                    .width(60.dp))
        }
             Text("Phone: (123) 456-7890",
                 color = Color.White,
                 style=MaterialTheme.typography.h5,
                 modifier = Modifier
                     .padding(8.dp)
                     .clip(
                         RoundedCornerShape(8.dp)
                     )
                     .height(40.dp)
                     .fillMaxWidth()
                     .background(grey700))
        Column(
            modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .height(110.dp)
                .background(grey700)
        ) {
            Spacer(modifier=Modifier.width(4.dp))
            Text("Notes",color=Color.White,style = MaterialTheme.typography.h5)
        }
    }
}



@Composable
fun ContactsScreen(names:ArrayList<String>) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(grey900)) {
        Text("All Contacts",color=Color.White,style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(8.dp))
        for(name in names) {
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .background(grey700)
            ) {
                Spacer(modifier=Modifier.width(4.dp))
                Text(name,color=Color.White,style = MaterialTheme.typography.h4)
            }
        }

    }

}

@Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        BottomNavComposeTheme {
            var names = ArrayList<String>()
            names.add("Jake")
            names.add("Kayla")
            names.add("Maria")
            names.add("Peter")
            names.add("Tyler")

            //ContactsScreen(names)
            AccountScreen()
        }
    }