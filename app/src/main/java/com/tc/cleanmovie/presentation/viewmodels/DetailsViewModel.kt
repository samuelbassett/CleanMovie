package com.tc.cleanmovie.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tc.cleanmovie.framework.data.model.add_favorite.AddFavoriteModel
import com.tc.cleanmovie.framework.data.model.details.DetailsModel
import com.tc.cleanmovie.framework.data.model.favorite.FavoriteBody
import com.tc.cleanmovie.framework.repository.get.RepositoryGetImpl
import com.tc.cleanmovie.framework.repository.post.RepositoryPostImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getService: RepositoryGetImpl,
    private val postService: RepositoryPostImpl
): ViewModel() {
    private val _detailsData = MutableStateFlow(DetailsModel())
    val detailsData: StateFlow<DetailsModel> = _detailsData

    fun getDetails(movieId: Int) {
        viewModelScope.launch {
            val response = getService.getMovieDetails(movieId)
            _detailsData.emit(response)
        }
    }

    fun toggleFavorite(movieId: Int, toggle: Boolean): Boolean {
        val favoriteBody = FavoriteBody(
            media_type = "movie",
            media_id = movieId,
            favorite = toggle
        )
        var response = AddFavoriteModel()
        viewModelScope.launch {
            response = postService.markAsFavorite(favoriteBody)
        }
        return response.statusCode == 1
    }
}