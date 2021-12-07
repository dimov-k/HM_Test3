package ru.mrroot.test3.presenter

import ru.mrroot.test3.view.ViewContract

internal interface PresenterContract<T:ViewContract> {
    fun onAttach(view: T)
    fun onDetach()
}
