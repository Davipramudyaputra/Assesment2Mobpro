package org.d3if3154.mobpro1.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "guitarin")
data class Guitarin(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val nama: String,
    val merk: String,
    val jenis: String
)
