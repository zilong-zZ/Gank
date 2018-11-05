package com.tt.lvruheng.eyepetizer.network

import com.zl.gank.data.ClassificationBean
import com.zl.gank.data.ToDayBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Created by zilongsong on 18-11-05.
 */
interface ApiService {
    companion object {
        val BASE_URL: String
            get() = "http://gank.io"
    }


    //获取最新一天的干货
    @GET("/api/today")
    fun getToDay(): Observable<ToDayBean>


    //获取分类数据: http://gank.io/api/data/数据类型/请求个数/第几页
    @GET("/api/data/{type}/{size}/{page}")
    fun getHomeMoreData(@Path("type") type: String, @Path("size") size: Int,
                        @Path("page") page: Int): Observable<ClassificationBean>
}