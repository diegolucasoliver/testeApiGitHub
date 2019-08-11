package com.diego.testeapigithub.response

data class GistBodyResponse(
    val files: Map<String, FilesResponse>,
    val owner: OwnerResponse
)