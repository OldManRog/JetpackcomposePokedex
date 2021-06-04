package com.plcoding.jetpackcomposepokedex.data.models



data class Comment(
    var id: String,
    var username: String,
    var content: String,
    var timestamp: String,
    var postId: String
) {
    //val time = Timestamp.valueOf(timestamp)
}

data class Comments(
    var items: List<Comment>,
    var offset: Int,
    var hasNext: Boolean,
    var totalCount: Int
)

data class AllComments(
    val pageSize: Int,
    val items: List<Comment>,
    val offset: Int,
    val hasNext: Boolean,
    val totalCount: Int
)
