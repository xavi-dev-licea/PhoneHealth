package com.xavidev.phonehealth.utils

sealed class Response<out T> {
    object Loading : Response<Nothing>()
    data class Success<out R>(val value: R) : Response<R>()
    data class Error(
        val error: String?,
        val throwable: Throwable?
    ) : Response<Nothing>()
}