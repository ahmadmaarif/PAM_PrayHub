package com.example.pam_prayhub.repositori

import com.example.pam_prayhub.data.Doa
import com.example.pam_prayhub.data.DoaDao
import kotlinx.coroutines.flow.Flow

class OfflineRepositoriDoa(private val doaDao: DoaDao):RepositoriDoa{
    override fun getAllADoaStream(): Flow<List<Doa>> {
        return doaDao.getDoa()
    }

    override fun getDoaStream(id: Int): Flow<Doa?> = DoaDao.getDoa(id)

    override suspend fun insertDoa(doa: Doa) {
        DoaDao.insertDoa(doa)
    }

    override suspend fun deleteDoa(doa: Doa) = DoaDao.deleteDoa(doa)

    override suspend fun updateDoa(doa: Doa) = DoaDao.updateDoa(doa)


}
