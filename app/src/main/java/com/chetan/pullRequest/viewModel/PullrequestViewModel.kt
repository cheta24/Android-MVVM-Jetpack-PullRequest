package com.chetan.pullRequest.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chetan.pullRequest.model.PullRequest
import com.chetan.pullRequest.network.ApiService
import kotlinx.coroutines.launch

class PullrequestViewModel : ViewModel() {

    var pullRequestListResponse:List<PullRequest> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    fun getPullRequestList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val pullRequestList = apiService.getPullRequests()
                pullRequestListResponse = pullRequestList
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}