package com.example.pam_prayhub.repositori

import kotlinx.coroutines.flow.Flow

class OfflineRepositoriDoa(private val doaDao: Doa):RepositoriSiswa{
    override fun getAllSiswaStream(): Flow<List<Siswa>> {
        return siswaDao.getAllSiswa()
    }

    override fun getSiswaStream(id: Int): Flow<Siswa?> = siswaDao.getSiswa(id)

    override suspend fun insertSiswa(siswa: Siswa) {
        siswaDao.insertSiswa(siswa)
    }

    override suspend fun deleteSiswa(siswa: Siswa) = siswaDao.deleteSiswa(siswa)

    override suspend fun updateSiswa(siswa: Siswa) = siswaDao.updateSiswa(siswa)


}