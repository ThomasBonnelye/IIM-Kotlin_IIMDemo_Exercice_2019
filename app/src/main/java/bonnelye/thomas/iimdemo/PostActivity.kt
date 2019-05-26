package bonnelye.thomas.iimdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import bonnelye.thomas.iimdemo.model.Comment
import bonnelye.thomas.iimdemo.model.Post
import bonnelye.thomas.iimdemo.model.User
import com.google.android.material.bottomnavigation.BottomNavigationView

class PostActivity : AppCompatActivity() {

    lateinit var post: Post

    lateinit var comment: Comment

    lateinit var user: User

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_text -> {

                val textFragment = TextFragment()
                val args = Bundle()
                args.putString("text", post.body)
                textFragment.arguments = args
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_layout, textFragment)
                    .commit()

            }
            R.id.navigation_author -> {

                val authorFragment = AuthorFragment()
                val args = Bundle()
                args.putString("text", user.email)
                authorFragment.arguments = args
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_layout, AuthorFragment())
                    .commit()
            }
            R.id.navigation_comment -> {

                val commentsFragment = CommentsFragment()
                val args = Bundle()
                args.putString("text", comment.body)
                commentsFragment.arguments = args
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_layout, CommentsFragment())
                    .commit()
            }
        }
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        post = intent.getSerializableExtra("post") as Post

        setContentView(R.layout.activity_post)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        val textFragment = TextFragment()
        val args = Bundle()
        args.putString("text", post.body)
        textFragment.arguments = args
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_layout, textFragment)
            .commit()

    }

}
