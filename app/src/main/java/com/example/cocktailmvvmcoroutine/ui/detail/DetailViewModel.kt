package com.example.cocktailmvvmcoroutine.ui.detail

import androidx.lifecycle.*
import com.example.cocktailmvvmcoroutine.data.model.DetailUiModel
import com.example.cocktailmvvmcoroutine.data.model.ResultOf
import com.example.cocktailmvvmcoroutine.data.repository.DetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val detailRepository: DetailRepository
) : ViewModel() {
    private var _detailUiModel: MutableLiveData<ResultOf<DetailUiModel>> = MutableLiveData()

    val detailUiModel: LiveData<ResultOf<DetailUiModel>>
        get() = _detailUiModel

    fun getDetailUiModel(idDrink: Long) = viewModelScope.launch {
        detailRepository.getDetailUiModel(idDrink)
            .flowOn(Dispatchers.IO)
            .catch { exception -> _detailUiModel.value = ResultOf.Error(exception) }
            .collect {
            _detailUiModel.value = it
        }
    }
}
