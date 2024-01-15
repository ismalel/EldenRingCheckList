package com.ismalel.eldenringchecklist.presentation

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ismalel.eldenringchecklist.data.model.BossData
import com.ismalel.eldenringchecklist.domain.GetBossesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getBossesUseCase: GetBossesUseCase) : ViewModel() {
    val bossesUseCase: MutableState<List<BossData>?> = mutableStateOf(null)

    fun getBosses() {
        viewModelScope.launch {
            getBossesUseCase.invoke(Unit).onEach {
                bossesUseCase.value = it
                Log.d("MainViewModel", "getBosses: $it")
            }.launchIn(viewModelScope)
        }
    }
}