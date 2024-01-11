package com.example.pam_prayhub.halaman

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.madoora.R
import com.example.pam_prayhub.model.EditViewModel
import com.example.pam_prayhub.model.PenyediaViewModel
import com.example.pam_prayhub.navigasi.DestinasiNavigasi
import com.example.pam_prayhub.navigasi.DoaTopAppBar
import kotlinx.coroutines.launch

object PenggunaItemEditDestination : DestinasiNavigasi {
    override val route = "item_edit"
    override val titleRes = R.string.edit_doa
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PenggunaItemEditScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () ->Unit,
    modifier: Modifier = Modifier,
    viewModel: EditViewModel = viewModel(factory = PenyediaViewModel.Factory)
){
    val coroutineScope = rememberCoroutineScope()
    Scaffold (
        topBar = {
            DoaTopAppBar(
                title = stringResource(PenggunaItemEditDestination.titleRes),
                canNavigateBack =  true,
                navigateUp = onNavigateUp
            )
        },
        modifier = modifier
    ){ innerPadding ->
        EntryDoaBody(
            uiStateDoa = viewModel.doaUiState,
            onDoaValueChange = viewModel::updateUiState,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.updateDoa()
                    navigateBack()
                }
            },
            modifier = Modifier.padding(innerPadding)
        )
    }
}