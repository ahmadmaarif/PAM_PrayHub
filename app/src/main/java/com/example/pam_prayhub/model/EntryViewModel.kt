package com.example.pam_prayhub.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.pam_prayhub.data.Doa
import com.example.pam_prayhub.repositori.RepositoriDoa

class EntryViewModel(private val repositoriDoa: RepositoriDoa): ViewModel() {
    var uiStateDoa by mutableStateOf(UIStateDoa())
        private set

    private fun validasiInput(uiState: DetailDoa = uiStateDoa.detailDoa ): Boolean {
        return with(uiState) {
            judul.isNotBlank() && isi.isNotBlank() && tanggal.isNotBlank()
        }
    }

    fun updateUiState(detailDoa: DetailDoa) {
        uiStateDoa =
            UIStateDoa(detailDoa = detailDoa, isEntryValid = validasiInput(detailDoa))
    }

    suspend fun saveDoa() {
        if (validasiInput()) {
            repositoriDoa.insertDoa(uiStateDoa.detailDoa.toDoa())
        }
    }
}

data class UIStateDoa(
    val detailDoa: DetailDoa = DetailDoa(),
    val isEntryValid: Boolean = false
)

data class DetailDoa(
    val id: Int = 0,
    val judul: String="",
    val isi: String="",
    val tanggal: String="",


)

fun DetailDoa.toDoa(): Doa = Doa(
    id = id,
    judul = judul,
    isi = isi,
    tanggal= tanggal
)

fun Doa.toUiStateDoa(isEntryValid: Boolean = false): UIStateDoa = UIStateDoa(
    detailDoa = this.toDetailDoa(),
    isEntryValid = isEntryValid
)

fun Doa.toDetailDoa(): DetailDoa = DetailDoa(
    id = id,
    judul = judul,
    isi = isi,
    tanggal = tanggal
)