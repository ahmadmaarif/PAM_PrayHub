package com.example.pam_prayhub.navigasi

object DetailDestination : DestinasiNavigasi {
    override val route = "item_details"
    override val titleRes = R.string.detail_siswa
    const val siswaIdArg = "itemId"
    val routeWithArgs = "$route/{$siswaIdArg}"