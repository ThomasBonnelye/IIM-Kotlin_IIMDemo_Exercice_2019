package bonnelye.thomas.iimdemo

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bonnelye.thomas.iimdemo.model.Post
import bonnelye.thomas.iimdemo.model.User
import kotlinx.android.synthetic.main.cell.view.*

class PostsAdapter : RecyclerView.Adapter<PostsAdapter.ViewHolder>(){
    var list: List<Post> = emptyList()
    var userList: List<User> = emptyList()

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.cell, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: Post = list[position]
        holder.itemView.cellName.text = item.title
        holder.itemView.cellName2.text = userList.first{it.id == item.userId} .name

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, PostActivity::class.java)
            intent.putExtra("post", item)
            holder.itemView.context.startActivity(intent)

        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}