package finance.home.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _selected = MutableStateFlow<Int>(0)
    val selected = _selected.asStateFlow()

    fun onSelected(index: Int) {
        viewModelScope.launch {
            _selected.value = index
        }
    }
}
