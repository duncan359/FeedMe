package jingking.com.feedme.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import jingking.com.feedme.R
import jingking.com.feedme.base.BaseActivity
import jingking.com.feedme.databinding.ActivityPostBinding
import jingking.com.feedme.model.Post
import jingking.com.feedme.ui.post.PostAdapter

/**
 * Created by Duncan Lim on 3/7/2018.
 */
class PostActivity : BaseActivity<PostPresenter>(),PostView{
    private lateinit var binding:ActivityPostBinding
    private val postAdapter = PostAdapter(this)
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post)
        binding.adapter = postAdapter
        binding.layoutManager = LinearLayoutManager(this)
        binding.dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun updatePosts(posts: List<Post>)
    {
        postAdapter.updatePosts(posts)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        binding.progressVisibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressVisibility = View.GONE
    }

    override fun instantiatePresenter(): PostPresenter {
        return PostPresenter(this)
    }
}