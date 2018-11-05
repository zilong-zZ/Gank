package com.zl.gank.data

data class ToDayBean(
        var category: List<String>,
        var error: Boolean,
        var results: Results
)

data class Results(
        var Android: List<Android>,
        var App: List<App>,
        var iOS: List<IOS>,
        var 休息视频: List<休息视频>,
        var 拓展资源: List<拓展资源>,
        var 瞎推荐: List<瞎推荐>,
        var 福利: List<福利>
)

data class IOS(
        var _id: String,
        var createdAt: String,
        var desc: String,
        var images: List<Any>,
        var publishedAt: String,
        var source: String,
        var type: String,
        var url: String,
        var used: Boolean,
        var who: String
)

data class 瞎推荐(
        var _id: String,
        var createdAt: String,
        var desc: String,
        var publishedAt: String,
        var source: String,
        var type: String,
        var url: String,
        var used: Boolean,
        var who: String
)

data class 拓展资源(
        var _id: String,
        var createdAt: String,
        var desc: String,
        var publishedAt: String,
        var source: String,
        var type: String,
        var url: String,
        var used: Boolean,
        var who: String
)

data class 休息视频(
        var _id: String,
        var createdAt: String,
        var desc: String,
        var publishedAt: String,
        var source: String,
        var type: String,
        var url: String,
        var used: Boolean,
        var who: String
)

data class Android(
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
)

data class App(
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
)

data class 福利(
        var _id: String,
        var createdAt: String,
        var desc: String,
        var publishedAt: String,
        var source: String,
        var type: String,
        var url: String,
        var used: Boolean,
        var who: String
)