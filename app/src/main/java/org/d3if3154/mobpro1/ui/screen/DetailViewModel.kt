package org.d3if3154.mobpro1.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3154.mobpro1.database.GuitarinDao
import org.d3if3154.mobpro1.model.Guitarin


class DetailViewModel(private val dao: GuitarinDao) : ViewModel() {

    fun insert(nama: String, merk: String, jenis: String) {
        val mahasiswa = Guitarin(
            nama = nama,
            merk = merk ,
            jenis = jenis
        )
        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(mahasiswa)
        }
    }

    suspend fun getGuitarin(id: Long): Guitarin? {
        return dao.getGuitarinById(id)
    }

    fun update(id: Long, nama: String, merk: String, jenis: String) {
        val guitarin = Guitarin(
            id = id,
            nama = nama,
            merk = merk,
            jenis = jenis
        )
        viewModelScope.launch(Dispatchers.IO) {
            dao.update(guitarin)
        }
    }

    fun delete(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteById(id)
        }
    }
}