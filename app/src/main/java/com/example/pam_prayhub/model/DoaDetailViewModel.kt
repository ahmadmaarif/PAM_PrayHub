package com.example.pam_prayhub.model

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pam_prayhub.halaman.DoaDetailDestination
import com.example.pam_prayhub.repositori.RepositoriDoa
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DoaDetailsViewModel (
    savedStateHandle: SavedStateHandle,
    private val repositoriDoa: RepositoriDoa
): ViewModel() {
    private val DoaID: Int = checkNotNull(savedStateHandle[DoaDetailDestination.doaIdArg])
    val uiState: StateFlow<ItemDetailsUiState> =
        repositoriDoa.getDoaStream(DoaID).filterNotNull().map {
            ItemDetailsUiState(detailDoa = it.toDetailDoa())
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = ItemDetailsUiState()
        )

    suspend fun deleteDoa() {
        repositoriDoa.deleteDoa(uiState.value.detailDoa.toDoa())
    }

    companion object {
        private const val TIMEOUT_MILLIS=5_000L
    }
}
data class ItemDetailsUiState (
    val outOfStock : Boolean = true,
    val detailDoa : DetailDoa = DetailDoa(),
)