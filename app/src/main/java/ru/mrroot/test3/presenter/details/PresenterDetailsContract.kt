package ru.mrroot.test3.presenter.details

import ru.mrroot.test3.presenter.PresenterContract
import ru.mrroot.test3.view.ViewContract
import ru.mrroot.test3.view.details.ViewDetailsContract

internal interface PresenterDetailsContract : PresenterContract<ViewDetailsContract> {
    fun setCounter(count: Int)
    fun onIncrement()
    fun onDecrement()
}
