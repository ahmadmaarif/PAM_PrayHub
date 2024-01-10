package com.example.pam_prayhub.repositori

import com.example.pam_prayhub.data.Doa
import com.example.pam_prayhub.data.DoaDao
import kotlinx.coroutines.flow.Flow

class OfflineRepositoriDoa(private val doaDao: DoaDao):RepositoriDoa{
    override fun getAllDoaStream(): Flow<List<Doa>> {
        return DoaDao.()
    }

    override fun getSiswaStream(id: Int): Flow<Doa?> = DoaDao.getDoa(id)

    override suspend fun insertSiswa(siswa: Doa) {
        DoaDao.insertDoa(siswa)
    }

    override suspend fun deleteSiswa(doa: Doa = DoaDao.deleteDoa(doa)

    override suspend fun updateSiswa(siswa: Siswa) = siswaDao.updateSiswa(siswa)


}