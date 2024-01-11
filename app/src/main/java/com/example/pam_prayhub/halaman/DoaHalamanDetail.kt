package com.example.pam_prayhub.halaman

import com.example.madoora.R
import com.example.pam_prayhub.navigasi.DestinasiNavigasi

object DetailDestination : DestinasiNavigasi {
    override val route = "item_details"
    override val titleRes = R.string.detail_doa
    const val doaIdArg = "itemId"
    val routeWithArgs = "$route/{${doaIdArg}"
}