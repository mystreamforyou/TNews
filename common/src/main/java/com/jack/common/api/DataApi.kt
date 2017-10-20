package com.jack.common.api

import com.jack.common.bean.Data
import com.jack.common.bean.Response
import com.jack.common.rest.RestUtils
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Description: News
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/10/16
 **/

interface DataApi {

    companion object {
        val IMPL: DataApi = RestUtils.retrofitInstance!!.create(DataApi::class.java)
    }

    @FormUrlEncoded
    @POST("?category=essay_joke&refer=1&count=20&min_behot_time=1508134722&last_refresh_sub_entrance_interval=1513664478&loc_mode=0&tt_from=tab&lac=4316&cid=19380&cp=5fa13f8baafdeq1&plugin_enable=3&\n" +
            "iid=15950685707&device_id=34657283722&ac=wifi&channel=update&aid=13&app_name=news_article&version_code=637&version_name=6.3.7&device_platform=android&ab_client=a1%2Cc4%2Ce1%2Cf2%2Cg2%2Cf7&ab_feature=102749%2C94563&abflag=3&ssmix=a&device_type=SM-N9006&device_brand=samsung&language=zh&os_api=21&os_version=5.0&uuid=357784057095067&\n" +
            "openudid=3adb68a60e783b8d&manifest_version_code=637&resolution=1080*1920&dpi=480&update_version_code=6377&_rticket=1513664478208&plugin=2431")
    fun getDuanzis(@Field("default") de: Int): Observable<Response<Data>>

    @FormUrlEncoded
    @POST("?category=image_funny")
    fun getQutus(@Field("count") count: Int, @Field("pageNum") pageNum: Int): Observable<Response<Data>>
}