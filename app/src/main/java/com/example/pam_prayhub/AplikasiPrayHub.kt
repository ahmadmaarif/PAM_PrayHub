package com.example.pam_prayhub

import android.app.Application
import com.example.pam_prayhub.repositori.ContainerApp
import com.example.pam_prayhub.repositori.ContainerDataApp


class AplikasiPrayHub : Application() {
    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}