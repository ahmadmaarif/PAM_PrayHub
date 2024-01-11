package com.example.pam_prayhub.halaman


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pam_prayhub.R
import com.example.pam_prayhub.data.Doa
import com.example.pam_prayhub.model.HomeViewModel
import com.example.pam_prayhub.navigasi.DestinasiNavigasi
import com.example.pam_prayhub.navigasi.DoaTopAppBar


object DestinasiHome : DestinasiNavigasi {
    override val route = "home"
    override val titleRes = R.string.app_name
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoaHomeScreen(
    navigateToItemEntry: () -> Unit,
    modifier: Modifier = Modifier,
    ViewModel: HomeViewModel = viewModel(),
    onDetailClick: (Int) -> Unit= {},
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection), topBar = {
            DoaTopAppBar(
                title = stringResource(id = DestinasiHome.titleRes),
                canNavigateBack = false,
                scrollBehavior = scrollBehavior
            )
        }, floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToItemEntry,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large))
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(id = R.string.entry_doa)
                )
            }
        }
    ) { innerPadding ->
        val uiStateDoa by ViewModel.homeUiState.collectAsState()
        BodyHome(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            itemDoa = uiStateDoa.listDoa,
            onDoaClick =  onDetailClick

        )
    }
}

@Composable
fun BodyHome(
    modifier: Modifier,
    itemDoa: List<Doa>,
    onDoaClick : (Int) -> Unit = {}
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        if (itemDoa.isEmpty()) {
            Text(
                text = stringResource(R.string.deskripsi_no_item),
                textAlign = TextAlign.Center, style = MaterialTheme.typography.titleLarge
            )
        } else {
            ListDoa(
                itemDoa = itemDoa,
                modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_small)),
                onItemClick = {onDoaClick(it.id)}
            )
        }
    }
}

@Composable
fun ListDoa(
    itemDoa: List<Doa>,
    modifier: Modifier = Modifier,
    onItemClick: (Doa) -> Unit
) {
    LazyColumn(modifier = Modifier) {
        items(items = itemDoa, key = { it.id }) { person ->
            DataDoa(
                doa = person,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
                    .clickable { onItemClick(person) }
            )
        }
    }
}

@Composable
fun DataDoa(
    doa: Doa, modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier, elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = doa.isi,
                style = MaterialTheme.typography.titleLarge,
            )
            Spacer(Modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = null
            )
            Text(
                text = doa.isi,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}