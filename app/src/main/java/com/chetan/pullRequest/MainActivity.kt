package com.chetan.pullRequest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.chetan.pullRequest.model.PullRequest
import com.chetan.pullRequest.model.User
import com.chetan.pullRequest.ui.theme.RetrofitAPIInJetpackComposeTheme
import com.chetan.pullRequest.view.PullRequestItem
import com.chetan.pullRequest.viewModel.PullrequestViewModel

class MainActivity : ComponentActivity() {

    val pullRequestViewModel by viewModels<PullrequestViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitAPIInJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MovieList(pullRequestList = pullRequestViewModel.pullRequestListResponse)
                    pullRequestViewModel.getPullRequestList()

                }
            }
        }
    }
}

@Composable
fun MovieList(pullRequestList: List<PullRequest>) {
    LazyColumn {
        itemsIndexed(items = pullRequestList) { index, item ->
            PullRequestItem(pullRequest = item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RetrofitAPIInJetpackComposeTheme {
            val pullRequest = PullRequest(
                "Added Changes",
                User("Csha616","https://avatars.githubusercontent.com/u/111289090?v=4"),
                "2014-04-25T16:15:05Z",
                "2014-04-25T16:15:05Z"
            )

            PullRequestItem(pullRequest = pullRequest )

    }
}