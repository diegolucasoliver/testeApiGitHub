package com.diego.testeapigithub.response

data class GistBodyResponse(
    val files: FilesResponse,
    val owner: OwnerResponse
)