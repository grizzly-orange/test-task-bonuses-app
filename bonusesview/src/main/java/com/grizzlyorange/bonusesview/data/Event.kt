package com.grizzlyorange.bonusesview.data

open class Event<T>(private val content: T) {
    private var hasBeenHandled: Boolean = false

    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }
}