package org.d3if3154.mobpro1.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.d3if3154.mobpro1.model.Guitarin

@Dao
interface GuitarinDao {
    @Insert
    suspend fun insert(guitarin: Guitarin)

    @Update
    suspend fun update(guitarin: Guitarin)

    @Query("SELECT * FROM guitarin ORDER BY merk DESC")
    fun getGuitarin(): Flow<List<Guitarin>>

    @Query("SELECT * FROM guitarin WHERE id = :id")
    suspend fun getGuitarinById(id: Long): Guitarin?

    @Query("DELETE FROM guitarin WHERE id = :id")
    suspend fun deleteById(id: Long)
}