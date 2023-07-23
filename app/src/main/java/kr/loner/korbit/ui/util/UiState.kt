package kr.loner.korbit.ui.util

sealed class UiState<out R> {

    data class Success<out T>(val data: T) : UiState<T>()
    data class Error(val exception: Exception) : UiState<Nothing>()
    object Loading : UiState<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            Loading -> "Loading"
        }
    }
}
val <T> UiState<T>.data: T?
    get() = (this as? UiState.Success)?.data

