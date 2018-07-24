package jingking.com.feedme.ui

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import jingking.com.feedme.R
import jingking.com.feedme.base.BasePresenter
import jingking.com.feedme.network.PostApi
import javax.inject.Inject

/**
 * Created by Duncan Lim on 2/7/2018.
 */
class PostPresenter(postView: PostView):BasePresenter<PostView>(postView)
{
    @Inject
    lateinit var postApi:PostApi

    private var subscription: Disposable?=null


    override fun onViewCreated() {
        loadPosts()
    }
    override fun onViewDestroyed() {
        subscription?.dispose()
    }
    fun loadPosts(){
        view.showLoading()
        subscription = postApi.getPosts().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).doOnTerminate{
            view.hideLoading()
        }.subscribe(
                {
                    postList -> view.updatePosts(postList)
                },
                {
                    view.showError(R.string.unknown_error)
                }
        )
    }
}