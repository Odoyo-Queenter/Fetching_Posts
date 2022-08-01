package dev.queenter.myposts

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.queenter.myposts.databinding.PostListItemBinding
import retrofit2.Retrofit

class displayPostsRvAdapter (var context: Context, var displayPost: List<Post>):RecyclerView.Adapter<RetrofitViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
        var binding =PostListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RetrofitViewHolder(binding)

    }

    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        var Currentposts = displayPost.get(position)
        with(holder.binding){
            tvUserId.text=Currentposts.userId.toString()
            tvId.text=Currentposts.id.toString()
            tvTitle.text=Currentposts.title
            tvBody.text=Currentposts.body

        }

    }

    override fun getItemCount(): Int {
        return displayPost.size
    }
}

class RetrofitViewHolder(val binding: PostListItemBinding):RecyclerView.ViewHolder(binding.root)