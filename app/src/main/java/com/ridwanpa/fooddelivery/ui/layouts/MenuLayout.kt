package com.ridwanpa.fooddelivery.ui.layouts

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ridwanpa.fooddelivery.routes.Screen
import com.ridwanpa.fooddelivery.ui.theme.Gray100
import com.ridwanpa.fooddelivery.ui.theme.Gray400
import com.ridwanpa.fooddelivery.ui.theme.Primary

@Composable
fun MainLayout(
    navController: NavController,
    topBar: @Composable () -> Unit = {},
    content: @Composable BoxScope.() -> Unit
) {
    val menuBottom = listOf(
        Screen.HomeScreen,
        Screen.OrderScreen,
        Screen.MyListScreen,
        Screen.AccountScreen
    )

    Scaffold(
        topBar = topBar,
        bottomBar = { BottomNavigationBar(navController, menuBottom) },
    ) { padding ->
        Box(Modifier.padding(padding)) {
            Box(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(vertical = 16.dp),
                content = content
            )
        }
    }
}

fun NavController.backToHome(route: String) {
    val navController = this
    navController.navigate(route) {
        // Pop up to the start destination of the graph to
        // avoid building up a large stack of destinations
        // on the back stack as users select items
        navController.graph.findNode(Screen.HomeScreen.route)?.let {
            popUpTo(it.id) {
                saveState = true
            }
        }
        // Avoid multiple copies of the same destination when
        // reselecting the same item
        launchSingleTop = true
        // Restore state when reselecting a previously selected item
        restoreState = true
    }
}


@Composable
fun BottomNavigationBar(
    navController: NavController,
    items: List<Screen>
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Gray100,
        elevation = 16.dp
    ) {
        items.forEach { item ->
            val selected =
                currentDestination?.hierarchy?.any { item.route == it.route } == true
            BottomNavigationItem(
                selected = selected,
                icon = {
                    item.icon?.let {
                        Icon(
                            painter = painterResource(id = it),
                            contentDescription = "menu",
                            tint = if (selected) Primary else Gray400,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                },
                label = {
                    item.label?.let {
                        Text(
                            text = it,
                            style = MaterialTheme.typography.body2,
                            color = if (selected) Primary else Gray400
                        )
                    }
                },
                onClick = {
                    navController.backToHome(item.route)
                }
            )
        }
    }
}


@Composable
fun BottomNavigation(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
    elevation: Dp = BottomNavigationDefaults.Elevation,
    shape: Shape = MaterialTheme.shapes.medium,
    content: @Composable RowScope.() -> Unit
) {
    Surface(
        color = backgroundColor,
        contentColor = contentColor,
        elevation = elevation,
        shape = shape,
        modifier = modifier
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(BottomNavigationHeight)
                .selectableGroup(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            content = content
        )
    }
}

/**
 * Height of a [BottomNavigation] component
 */
private val BottomNavigationHeight = 60.dp

@Composable
fun TobBar(
    title: String,
    isBack: Boolean = true,
    navController: NavController,
) {
    TopAppBar(
        title = {
            Text(
                title,
                style = MaterialTheme.typography.h3,
                textAlign = TextAlign.Center,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth()
            )
        },
        actions = { Spacer(modifier = Modifier.width(68.dp)) },
        navigationIcon = {
            if (isBack) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Default.ArrowBack, "back")
                }
            }
        },
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onBackground,
        elevation = 0.dp,
        modifier = Modifier.padding(horizontal = 16.dp)
    )
}
