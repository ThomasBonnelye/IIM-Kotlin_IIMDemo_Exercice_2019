package bonnelye.thomas.iimdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import bonnelye.thomas.iimdemo.model.Post
import bonnelye.thomas.iimdemo.model.User
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = PostsAdapter()
        recyclerView.adapter = adapter

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create<API>()

        api.getPosts().enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.e("DL", "Download failed : ${t.message}")
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val posts = response.body()!!
                api.getUsers().enqueue(object : Callback<List<User>> {
                    override fun onFailure(call: Call<List<User>>, t: Throwable) {
                        Log.e("DL", "Download failed : ${t.message}")
                    }

                    override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                        val users = response.body()!!
                        adapter.list = posts
                        adapter.userList = users
                        adapter.notifyDataSetChanged()
                    }
                })
            }
        })

    }
}