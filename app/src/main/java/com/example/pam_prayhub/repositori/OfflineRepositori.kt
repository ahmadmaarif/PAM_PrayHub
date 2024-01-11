package com.example.pam_prayhub.repositori

import com.example.pam_prayhub.data.Doa
import com.example.pam_prayhub.data.DoaDao
import kotlinx.coroutines.flow.Flow


class OfflineRepositoriDoa(private val doaDao: DoaDao):RepositoriDoa{
    override fun getAllDoaStream(): Flow<List<Doa>> {
        return doaDao.getAllDoa()    }

    override fun getDoaStream(id: Int): Flow<Doa?> = doaDao.getDoa(id)

    override suspend fun insertDoa(doa: Doa) {
        doaDao.insertDoa(doa)
    }

    override suspend fun deleteDoa(doa: Doa) = doaDao.deleteDoa(doa  )

    override suspend fun updateDoa(doa: Doa) = doaDao.updateDoa(doa)

}
