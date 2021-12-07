package ru.mrroot.test3.view.search

import ru.mrroot.test3.model.SearchResult
import ru.mrroot.test3.view.ViewContract

internal interface ViewSearchContract : ViewContract {
    fun displaySearchResults(
        searchResults: List<SearchResult>,
        totalCount: Int
    )

    fun displayError()
    fun displayError(error: String)
    fun displayLoading(show: Boolean)
}
