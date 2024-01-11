package com.example.pam_prayhub.navigasi

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pam_prayhub.R
import com.example.pam_prayhub.halaman.DestinasiEntry
import com.example.pam_prayhub.halaman.DestinasiHome
import com.example.pam_prayhub.halaman.DoaDetailDestination
import com.example.pam_prayhub.halaman.DoaDetailScreen
import com.example.pam_prayhub.halaman.DoaEntryScreen
import com.example.pam_prayhub.halaman.DoaHomeScreen
import com.example.pam_prayhub.halaman.DoaItemEditDestination
import com.example.pam_prayhub.halaman.DoaItemEditScreen

@Composable
fun PrayHubApp(navController: NavHostController = rememberNavController()) {
    HostNavigasi(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoaTopAppBar(
    title: String,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigateUp: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        title = { Text(title) },
        modifier = modifier, scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack, contentDescription = stringResource(
                            id = R.string.back
                        )
                    )
                }
            }
        }
    )
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier
    ) {
        composable(DestinasiHome.route) {
            DoaHomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                onDetailClick = { itemId ->
                    navController.navigate("${DoaDetailDestination.route}/$itemId")
                },
            )
        }
        composable(DestinasiEntry.route) {
            DoaEntryScreen(navigateBack = { navController.popBackStack() })
        }

        composable(
            DoaDetailDestination.routeWithArgs,
            arguments = listOf(navArgument(DoaDetailDestination.doaIdArg) {
                type = NavType.IntType
            })
        ) { backStackEntry ->
            val itemId = backStackEntry.arguments?.getInt(DoaDetailDestination.doaIdArg)
            itemId?.let {
                DoaDetailScreen(
                    navigateBack = { navController.popBackStack() },
                    navigateToEditItem = { navController.navigate("${DoaItemEditDestination.route}/$it") }
                )
            }
        }

        composable(
            DoaItemEditDestination.routeWithArgs,
            arguments = listOf(navArgument(DoaItemEditDestination.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            DoaItemEditScreen(navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() })
        }


    }
}