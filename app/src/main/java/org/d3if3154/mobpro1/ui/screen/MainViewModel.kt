package org.d3if3154.mobpro1.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.d3if3154.mobpro1.database.GuitarinDao
import org.d3if3154.mobpro1.model.Guitarin

class MainViewModel(dao: GuitarinDao) : ViewModel() {
    val data: StateFlow<List<Guitarin>> = dao.getGuitarin().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )
}