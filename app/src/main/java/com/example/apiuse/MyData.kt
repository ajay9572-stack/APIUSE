package com.example.apiuse

import kotlinx.serialization.Serializable

@Serializable
data class MyData(
    val title: String,
    val link: String,
    val snippet: String,
    val photo_url: String,
    val thumbnail_url: String,
    val published_datetime_utc: String,
    val authors: List<String>,
    val source_url: String,
    val source_name: String,
    val source_logo_url: String? = null,
    val source_favicon_url: String,
    val source_publication_id: String,
    val related_topics: List<RelatedTopic>,
    val sub_articles: List<SubArticle>,
    val story_id: String
)

@Serializable
data class RelatedTopic(
    val topic_id: String,
    val topic_name: String
)

@Serializable
data class SubArticle(
    val title: String,
    val link: String,
    val photo_url: String,
    val thumbnail_url: String,
    val published_datetime_utc: String,
    val authors: List<String>,
    val source_url: String,
    val source_name: String,
    val source_logo_url: String? = null,
    val source_favicon_url: String,
    val source_publication_id: String,
    val related_topics: List<RelatedTopic>
)