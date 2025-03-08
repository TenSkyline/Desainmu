package com.example.desainmu.presentation.ui.addOrder


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AddOrderViewModel(
//    private val dao: ItemDao
): ViewModel() {
    private var addOrderState by mutableStateOf(AddOrderState())

    val uiState get() = _uiState.asStateFlow()
    private val _uiState = MutableStateFlow(AddOrderState())

    val uiEffect get() = _uiEffect.asSharedFlow()
    private val _uiEffect = MutableSharedFlow<AddOrderEffect>()

    fun handleEvent(event: AddOrderEvent) {
        when (event) {
            AddOrderEvent.NavigateUp -> emit(AddOrderEffect.NavigateUp)
            is AddOrderEvent.ToMeasurement -> emit(
                AddOrderEffect.ToMeasurement(
                    design = event.design
                )
            )

            is AddOrderEvent.SetTitle -> _uiState.update {
                AddOrderState(addOrderDetails = it.addOrderDetails.copy(title = event.title))
            }

            is AddOrderEvent.SetDescription -> _uiState.update {
                AddOrderState(addOrderDetails = it.addOrderDetails.copy(description = event.description))
            }

            is AddOrderEvent.SetSelectedDate -> _uiState.update {
                it.copy(selectedDate = event.selectedDate)
            }

            is AddOrderEvent.SetSelectedDesign -> _uiState.update {
                it.copy(selectedDesign = event.design)
            }

//            is AddOrderEvent.SaveOrder -> {
//                val title = uiState.value.addOrderDetails.title
//                val description = uiState.value.addOrderDetails.description
//
//                if (title.isBlank() || description.isBlank()){
//                    return
//                }
//
//                val item = Item(
//                    title = title,
//                    description = description
//                )
//                viewModelScope.launch {
//                    dao.upsertItem(item)
//                }
//            }
        }
    }

//    private fun validateInput(uiState: AddOrderDetails = addOrderState.addOrderDetails): Boolean {
//        return with(uiState){
//            title.isNotBlank() && description.isNotBlank()
//        }
//    }
//
//    private suspend fun saveItem() {
//        if (validateInput()) {
//            itemsRepository.insertItem(addOrderState.addOrderDetails.toItem())
//        }
//    }

    private fun emit(effect: AddOrderEffect) = viewModelScope.launch {
        _uiEffect.emit(effect)
    }
}