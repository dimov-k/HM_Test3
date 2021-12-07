package ru.mrroot.test3.presenter.search

import ru.mrroot.test3.presenter.PresenterContract
import ru.mrroot.test3.view.search.ViewSearchContract

internal interface PresenterSearchContract : PresenterContract<ViewSearchContract> {
    fun searchGitHub(searchQuery: String)
}
