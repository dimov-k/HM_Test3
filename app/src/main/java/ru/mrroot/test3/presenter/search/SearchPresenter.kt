package ru.mrroot.test3.presenter.search

import ru.mrroot.test3.model.SearchResponse
import ru.mrroot.test3.repository.GitHubRepository
import ru.mrroot.test3.repository.GitHubRepository.GitHubRepositoryCallback
import ru.mrroot.test3.view.search.ViewSearchContract
import retrofit2.Response

internal class SearchPresenter internal constructor(private val repository: GitHubRepository) :
    PresenterSearchContract, GitHubRepositoryCallback {

    var viewContract: ViewSearchContract? = null
        private set

    override fun searchGitHub(searchQuery: String) {
        viewContract?.displayLoading(true)
        repository.searchGithub(searchQuery, this)
    }

    override fun handleGitHubResponse(response: Response<SearchResponse?>?) {
        viewContract?.displayLoading(false)
        if (response != null && response.isSuccessful) {
            val searchResponse = response.body()
            val searchResults = searchResponse?.searchResults
            val totalCount = searchResponse?.totalCount
            if (searchResults != null && totalCount != null) {
                viewContract?.displaySearchResults(
                    searchResults,
                    totalCount
                )
            } else {
                viewContract?.displayError("Search results or total count are null")
            }
        } else {
            viewContract?.displayError("Response is null or unsuccessful")
        }
    }

    override fun handleGitHubError() {
        viewContract?.displayLoading(false)
        viewContract?.displayError()
    }

    override fun onAttach(view: ViewSearchContract) {
        viewContract = view
    }

    override fun onDetach() {
        viewContract = null
    }
}
