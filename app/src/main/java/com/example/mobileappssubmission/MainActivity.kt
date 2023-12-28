package com.example.mobileappssubmission

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person

import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person

import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem



import androidx.compose.material3.Scaffold

import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf

import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip


import androidx.compose.ui.graphics.vector.ImageVector

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


import com.example.mobileappssubmission.ui.theme.MobileappsSubmissionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileappsSubmissionTheme {
                MyApp()
                }
            }
        }
    }

data class NavItemState(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasBadge: Boolean,
    val badgeNumber: Int,
    val promptText: String,
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(modifier: Modifier = Modifier) {

val items = listOf(
    NavItemState(
        title = "Overview",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        hasBadge = false,
        badgeNumber = 0,
        promptText = "Here are you assignments"
    ),

    NavItemState(
        title = "Calendar",
        selectedIcon = Icons.Filled.DateRange,
        unselectedIcon = Icons.Outlined.DateRange,
        hasBadge = false,
        badgeNumber = 0,
        promptText = "Here are you assignments shown on a calendar"
    ),

    NavItemState(
        title = "New",
        selectedIcon = Icons.Filled.Add,
        unselectedIcon = Icons.Outlined.Add,
        hasBadge = false,
        badgeNumber = 0,
        promptText = "Add a new assignment here"

    ),

    NavItemState(
        title = "Profile",
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person,
        hasBadge = false,
        badgeNumber = 1,
        promptText = "Edit your profile, sign in, or sign out"
    ),

    NavItemState(
        title = "Settings",
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = Icons.Outlined.Settings,
        hasBadge = false,
        badgeNumber = 0,
        promptText = "Change settings, general appearance, or accessibility options"
    )
)
    var bottomNavItemState by rememberSaveable {
        mutableIntStateOf(0)
    }

    Scaffold(

        bottomBar = {
            Row {
                NavigationBar(
                    modifier
                        .padding(
                            start = 20.dp,
                            end = 20.dp,
                            bottom = 15.dp
                        )
                        .clip(RoundedCornerShape(30.dp)),
                ) {
                    items.forEachIndexed { index, item ->

                        NavigationBarItem(selected = bottomNavItemState == index,
                            onClick = { bottomNavItemState = index },
                            icon = {
                                BadgedBox(badge = {
                                    if (item.hasBadge) Badge {}
                                    if (item.badgeNumber != 0) Badge {
                                        Text(text = item.badgeNumber.toString())
                                    }
                                }) {
                                    Icon(
                                        imageVector =
                                        if (bottomNavItemState == index)
                                            item.selectedIcon

                                        else
                                            item.unselectedIcon,
                                        contentDescription = item.title
                                    )
                                }
                            }
                        )
                    }
            }



            }
        }
    ) {
        Column(
            modifier
                .padding(start = 20.dp, top = 40.dp, end = 20.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = items[bottomNavItemState].title,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 50.sp
            )
            Text(
                text = items[bottomNavItemState].promptText,
                fontWeight = FontWeight.Light,
                fontSize = 15.sp
            )
        }

        Column(
            modifier
            .fillMaxSize()
        ) {


        }
    }
}


@Preview(showBackground = true)
@Composable
fun AppPreview() {
    MobileappsSubmissionTheme {
        MyApp()
    }
}




