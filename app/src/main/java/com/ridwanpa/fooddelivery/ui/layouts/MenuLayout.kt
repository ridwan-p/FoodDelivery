package com.ridwanpa.fooddelivery.ui.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
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
    menuBottom: List<Screen>,
    content: @Composable BoxScope.() -> Unit
) {
    Scaffold(bottomBar = { BottomNavigationBar(navController, menuBottom) }) { padding ->
        Box(Modifier.padding(padding)) {
            Box(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 16.dp),
                content = content
            )
        }
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
        elevation = 16.dp,
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
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
                    navController.navigate(item.route) {
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
