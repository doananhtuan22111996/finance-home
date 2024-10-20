package finance.home.presentation.home.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import vn.core.domain.ResultModel
import vn.finance.home.business.domain.model.AvailableBalanceModel
import vn.finance.home.business.domain.usecase.AvailableBalanceUseCase
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(private val availableBalanceUseCase: AvailableBalanceUseCase) :
    ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()
    private val _data = MutableStateFlow<AvailableBalanceModel?>(null)
    val data = _data.asStateFlow()
    private val _appException = MutableStateFlow<ResultModel.AppException?>(null)
    val appException = _appException.asStateFlow()

    init {
        onAvailableBalance()
    }

    private fun onAvailableBalance() {
        viewModelScope.launch {
            availableBalanceUseCase.execute().collect {
                when (it) {
                    is ResultModel.Success -> {
                        _data.value = it.data
                    }

                    is ResultModel.AppException -> {
                        _appException.value = it
                    }

                    is ResultModel.Loading -> {
                        _isLoading.value = true
                    }

                    else -> _isLoading.value = false
                }
            }
        }
    }

    fun onAppExceptionDismiss() {
        _appException.value = null
    }
}