package jingking.com.feedme.base

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by Duncan Lim on 2/7/2018.
 */
abstract class BaseActivity<P:BasePresenter<BaseView>>:BaseView,AppCompatActivity(){
    protected lateinit var presenter:P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter=instantiatePresenter()
    }

    protected abstract fun instantiatePresenter(): P

    override fun getContext(): Context {
        return this
    }

}