package com.tc.cleanmovie.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tc.cleanmovie.framework.data.model.movie.MovieItemModel
import com.tc.cleanmovie.framework.repository.get.RepositoryGet
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    val repositoryGet: RepositoryGet
) : ViewModel() {
    private val _movieData = MutableStateFlow<List<MovieItemModel>>(emptyList())
    val movieData: StateFlow<List<MovieItemModel>> = _movieData

    init {
        getMovies()
    }

    fun getMovies() {
        viewModelScope.launch {
            val response = repositoryGet.getMovies()
            _movieData.emit((response.results ?: emptyList()) as List<MovieItemModel>)
        }
    }
}