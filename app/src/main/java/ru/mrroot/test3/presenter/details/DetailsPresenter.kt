package ru.mrroot.test3.presenter.details

import ru.mrroot.test3.view.details.ViewDetailsContract

internal class DetailsPresenter internal constructor(private var count: Int = 0) :
    PresenterDetailsContract {

    var viewContract: ViewDetailsContract? = null
        private set

    override fun setCounter(count: Int) {
        this.count = count
    }

    override fun onIncrement() {
        count++
        viewContract?.setCount(count)
    }

    override fun onDecrement() {
        count--
        viewContract?.setCount(count)
    }

    override fun onAttach(view: ViewDetailsContract) {
        viewContract = view
    }

    override fun onDetach() {
        viewContract = null
    }
}
