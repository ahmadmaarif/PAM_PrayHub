package com.example.pam_prayhub.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pam_prayhub.halaman.DoaItemEditDestination

import com.example.pam_prayhub.repositori.RepositoriDoa
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EditViewModel (
    savedStateHandle: SavedStateHandle,
    private val repositoriDoa: RepositoriDoa
) : ViewModel(){

    var doaUiState by mutableStateOf(UIStateDoa())
        private set

    private val itemId: Int = checkNotNull(savedStateHandle[DoaItemEditDestination.itemIdArg])

    init {
        viewModelScope.launch {
            doaUiState = repositoriDoa.getDoaStream(itemId)
                .filterNotNull()
                .first()
                .toUiStateDoa(true)
        }
    }

    suspend fun updateDoa(){
        if (validasiInput(doaUiState.detailDoa)){
            repositoriDoa.updateDoa(doaUiState.detailDoa.toDoa())
        }
        else {
            println("Data tidak valid")
        }
    }

    fun updateUiState(detailDoa: DetailDoa){
        doaUiState =
            UIStateDoa(detailDoa = detailDoa, isEntryValid = validasiInput(detailDoa))
    }

    private fun validasiInput(uiState: DetailDoa = doaUiState.detailDoa): Boolean {
        return with(uiState){
            judul.isNotBlank() && isi.isNotBlank() && tanggal.isNotBlank()
        }
    }
}