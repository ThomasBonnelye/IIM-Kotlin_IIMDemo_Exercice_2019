package bonnelye.thomas.iimdemo

import bonnelye.thomas.iimdemo.model.Comment
import bonnelye.thomas.iimdemo.model.Post
import bonnelye.thomas.iimdemo.model.User
import retrofit2.Call
import retrofit2.http.GET

interface API {

    @GET("/posts")
    fun getPosts(): Call<List<Post>>

    @GET("/users")
    fun getUsers(): Call<List<User>>

    @GET("/comments")
    fun getComments(): Call<List<Comment>>

}