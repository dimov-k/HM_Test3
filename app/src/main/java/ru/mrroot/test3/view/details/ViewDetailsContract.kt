package ru.mrroot.test3.view.details

import ru.mrroot.test3.view.ViewContract

internal interface ViewDetailsContract : ViewContract {
    fun setCount(count: Int)
}
