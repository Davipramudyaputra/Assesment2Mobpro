package org.d3if3154.mobpro1.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if3154.mobpro1.database.GuitarinDao
import org.d3if3154.mobpro1.ui.screen.DetailViewModel
import org.d3if3154.mobpro1.ui.screen.MainViewModel

class ViewModelFactory(
    private val dao: GuitarinDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(dao) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}