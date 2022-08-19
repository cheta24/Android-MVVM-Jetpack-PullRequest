package com.chetan.pullRequest

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.chetan.pullRequest.model.PullRequest
import com.chetan.pullRequest.model.User

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        print(appContext.packageName)
        assertEquals("com.chetan.pullrequest", appContext.packageName)
    }

    @Test
    fun userModel(){
        val user = User("Csha616","https://avatars.githubusercontent.com/u/111289090?v=4")
        assertEquals(user.login,"Csha616")
        assertEquals(user.avatar_url,"https://avatars.githubusercontent.com/u/111289090?v=4")
    }

    @Test
    fun pullRequestModel(){

        val pullRequest = PullRequest(
            "Added Changes",
            User("Csha616","https://avatars.githubusercontent.com/u/111289090?v=4"),
            "2014-04-25T16:15:05Z",
            "2014-04-25T16:15:05Z"
        )
        assertEquals(pullRequest.title,"Added Changes")
        assertEquals(pullRequest.closed_at,"2014-04-25T16:15:05Z")
        assertEquals(pullRequest.created_at,"2014-04-25T16:15:05Z")
        assertNotNull(pullRequest.user)
    }
}