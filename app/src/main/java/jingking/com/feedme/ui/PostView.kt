package jingking.com.feedme.ui

import android.support.annotation.StringRes
import jingking.com.feedme.base.BaseView
import jingking.com.feedme.model.Post

/**
 * Created by Duncan Lim on 2/7/2018.
 */
interface PostView:BaseView{

    fun updatePosts(posts: List<Post>)

    fun showError(error:String)

    fun showError(@StringRes errorResId:Int)
    {
        this.showError(getContext().getString(errorResId))
    }

    fun showLoading()

    fun hideLoading()

}