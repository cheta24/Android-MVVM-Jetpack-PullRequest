package com.chetan.pullRequest.model

data class PullRequest(
    val title: String,
    val user: User,
    val created_at: String,
    val closed_at: String
)