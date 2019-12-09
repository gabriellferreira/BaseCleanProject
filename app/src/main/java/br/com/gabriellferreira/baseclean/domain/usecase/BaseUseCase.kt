package br.com.gabriellferreira.baseclean.domain.usecase

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

abstract class BaseUseCase {

    protected val subscribeScheduler: Scheduler = Schedulers.io()

    protected val observeScheduler: Scheduler = AndroidSchedulers.mainThread()
}