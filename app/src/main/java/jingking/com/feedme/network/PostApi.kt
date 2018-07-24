package jingking.com.feedme.network

import jingking.com.feedme.model.Post
import retrofit2.http.GET
import io.reactivex.Observable

/**
 * Created by Duncan Lim on 2/7/2018.
 */
interface PostApi{
    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}