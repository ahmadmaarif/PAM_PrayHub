package com.example.pam_prayhub.halaman

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.madoora.R
import com.example.pam_prayhub.model.DetailsViewModel
import com.example.pam_prayhub.model.PenyediaViewModel
import com.example.pam_prayhub.navigasi.DestinasiNavigasi


object PenggunaDetailDestination : DestinasiNavigasi {
    override val route = "item_details"
    override val titleRes = R.string.detail_pengguna
    const val penggunaIdArg = "itemId"
    val routeWithArgs = "$route/{$penggunaIdArg}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    navigateToEditItem: (Int) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailsViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {

}

@Composable
private fun DeleteConfirmDialog(
    onDeleteConfirm: () -> Unit,
    onDeleteCancel: () -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        onDismissRequest = {  },
        title = { Text(stringResource(id = R.string.attention)) },
        text = { Text(stringResource(id = R.string.delete)) },
        modifier = modifier,
        dismissButton = {
            TextButton(onClick = onDeleteCancel) {
                Text(text = stringResource(id = R.string.no))
            }
        },
        confirmButton = {
            TextButton(onClick = onDeleteConfirm) {
                Text(text = stringResource(id = R.string.yes))

            }

        })
}