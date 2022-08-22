package dev.queenter.myposts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.queenter.myposts.databinding.CommentsListItemsBinding

class displayCommentsRvAdapter  (var commentList:List<Comment>): RecyclerView.Adapter<CommentsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        var binding =CommentsListItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CommentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentComment = commentList.get(position)
        with(holder.binding) {
            tvNameComment.text = currentComment.name
            tvBodyComment.text = currentComment.body
            tvEmailComment.text = currentComment.email
        }
    }

    override fun getItemCount(): Int {
        return commentList.size
    }

}
class CommentsViewHolder(val binding: CommentsListItemsBinding):RecyclerView.ViewHolder(binding.root)








