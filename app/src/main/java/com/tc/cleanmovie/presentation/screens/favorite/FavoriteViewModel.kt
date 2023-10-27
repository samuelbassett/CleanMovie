package com.tc.cleanmovie.presentation.screens.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tc.cleanmovie.framework.data.model.favorite.FavoriteItemModel
import com.tc.cleanmovie.framework.repository.get.RepositoryGetImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val service: RepositoryGetImpl
): ViewModel() {
    private val _favData = MutableStateFlow<List<FavoriteItemModel>>(emptyList())
    val favData: StateFlow<List<FavoriteItemModel>> = _favData

    init {
        getFavorites()
    }

    fun getFavorites() {
        viewModelScope.launch {
            val response = service.getFavorites()
            _favData.emit((response.results ?: emptyList()) as List<FavoriteItemModel>)
        }
    }
}