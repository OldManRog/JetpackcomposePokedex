package com.applejuice.pixelgram.dataclasses

import java.sql.Timestamp

data class Post(
    var id: String,
    var username: String,
    var description: String,
    var timestamp: String,
    var likes: Int,
    var imageId: String
) {
   // val time = Timestamp.valueOf(timestamp)
}

data class PostItem(
    val post: Post,
    val user: User,
    val comments: Comments
)

data class AllPosts(
    val pageSize: Int,
    val items: List<PostItem>,
    val offset: Int,
    val hasNext: Boolean,
    val totalCount: Int
)
