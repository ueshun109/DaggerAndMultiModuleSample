package com.example.android.core

sealed class GithubError(val title: String, override val message: String): Exception() {
    object UnAuthorized: GithubError("認証エラー", "GitHubのサービスへの認証ができませんでした")
    object Forbidden: GithubError("権限エラー", "Githubのサービスへアクセスするための権限がありません")
    object InternalServerError: GithubError("サーバーエラー", "サーバーの内部で不明なエラーが発生しました")
    object UnknownError: GithubError("不明なエラー", "不明なエラーが発生しました")
}