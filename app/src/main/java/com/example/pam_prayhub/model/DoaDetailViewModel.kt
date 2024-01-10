package com.example.pam_prayhub.model

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow

class DetailsViewModel (
    savedStateHandle: SavedStateHandle,
    private val repositoriDoa: RepositoriDoa: Rep

): ViewModel() {
    private val DoaID: Int = checkNotNull(savedStateHandle[DetailDestination.siswaIdArg])
    val uiState: StateFlow<ItemDetailsUiState> =
        repositoriDoa.getSiswaStream(DoaID).filterNotNull().map {
            ItemDetailsUiState(detailSiswa = it.toDetailSiswa())
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = ItemDetailsUiState()
        )

    suspend fun deleteItem() {
        repositoriDoa.deleteSiswa(uiState.value.detailSiswa.toSiswa())
    }

    companion object {
        private const val TIMEOUT_MILLIS=5_000L
    }
}
data class ItemDetailsUiState (
    val outOfStock : Boolean = true,
    val detailSiswa : DetailDoa = DetailDoa(),
)