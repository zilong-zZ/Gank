package com.zl.gank.data

data class ClassificationBean(
        var error: Boolean,
        var results: List<Result>
) {

    data class Result(
            var _id: String,
            var createdAt: String,
            var desc: String,
            var images: List<String>,
            var publishedAt: String,
            var source: String,
            var type: String,
            var url: String,
            var used: Boolean,
            var who: String
    ) {
        /*  "_id": "5bc780089d21220315c663de",
          "createdAt": "2018-10-17T18:31:36.591Z",
          "desc": "小红书系列--标签--支持多分辨率渲染下标签位置渲染（-口-）!!!",
          "images": [
          "https://ww1.sinaimg.cn/large/0073sXn7gy1fwh047va9tg30bw0l8u0z"
          ],
          "publishedAt": "2018-10-22T00:00:00.0Z",
          "source": "web",
          "type": "Android",
          "url": "https://github.com/GIVEWAYTO/TagImageView",
          "used": true,
          "who": "GIVEWAYTO"*/
    }

}
