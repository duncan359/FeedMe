package jingking.com.feedme.base

import jingking.com.feedme.injection.component.DaggerPresenterInjector
import jingking.com.feedme.injection.component.PresenterInjector
import jingking.com.feedme.module.ContextModule
import jingking.com.feedme.module.NetworkModule
import jingking.com.feedme.ui.PostPresenter

/**
 * Created by Duncan Lim on 2/7/2018.
 */

abstract class BasePresenter<out V: BaseView>(protected val view:V){

    private val injector: PresenterInjector = DaggerPresenterInjector
            .builder()
            .baseView(view)
            .contextModule(ContextModule)
            .networkModule(NetworkModule)
            .build()


    init {
        inject()
    }


    open fun onViewCreated(){}


    open fun onViewDestroyed(){}


    private fun inject() {
        when (this) {
            is PostPresenter -> injector.inject(this)
        }
    }
}