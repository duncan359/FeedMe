package jingking.com.feedme.injection.component

import dagger.BindsInstance
import dagger.Component
import jingking.com.feedme.base.BaseView
import jingking.com.feedme.module.ContextModule
import jingking.com.feedme.module.NetworkModule
import jingking.com.feedme.ui.PostPresenter
import javax.inject.Singleton

/**
 * Created by Duncan Lim on 2/7/2018.
 */
@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresenterInjector {
    /**
     * Injects required dependencies into the specified PostPresenter.
     * @param postPresenter PostPresenter in which to inject the dependencies
     */
    fun inject(postPresenter: PostPresenter)

    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}