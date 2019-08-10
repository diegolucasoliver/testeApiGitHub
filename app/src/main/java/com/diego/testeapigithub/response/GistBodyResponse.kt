package com.diego.testeapigithub.response

data class GistBodyResponse(
    val files: List<FilesResponse>,
    val owner: OwnerResponse
)