package com.example.pam_prayhub.model


import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pam_prayhub.AplikasiPrayHub

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiPrayHub().container.repositoriDoa)
        }

        initializer {
            EntryViewModel(aplikasiPrayHub().container.repositoriDoa)
        }

        initializer {
            DoaDetailsViewModel(createSavedStateHandle(), aplikasiPrayHub().container.repositoriDoa)
        }
        initializer {
            DoaDetailsViewModel(
                createSavedStateHandle(),
                aplikasiPrayHub().container.repositoriDoa,
            )
        }

        initializer {
            EditViewModel(
                createSavedStateHandle(),
                aplikasiPrayHub().container.repositoriDoa,
            )
        }
    }
}

fun CreationExtras.aplikasiPrayHub(): AplikasiPrayHub =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiPrayHub)