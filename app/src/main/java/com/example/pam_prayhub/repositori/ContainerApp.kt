package com.example.pam_prayhub.repositori

import android.content.Context
import com.example.pam_prayhub.data.DatabasePrayHub

interface ContainerApp {
    val repositoriDoa: RepositoriDoa
    val repositoriPengguna: RepositoriPengguna
}

class ContainerDataApp(private val context: Context) : ContainerApp {
    override val repositoriDoa: RepositoriDoa by lazy {
        OfflineRepositoriDoa(DatabasePrayHub.getDatabase(context).DoaDao())
    }

    override val repositoriPengguna: RepositoriPengguna by lazy {
        OfflineRepositoriPengguna(
            DatabasePrayHub.getDatabase(context).PenggunaDao()
        )
    }
}

