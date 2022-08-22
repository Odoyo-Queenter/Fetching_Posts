package dev.queenter.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev.queenter.myposts.databinding.ActivityCommentsBinding
import dev.queenter.myposts.databinding.PostListItemBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsActivity : AppCompatActivity() {
    var postId = 0
    lateinit var binding: ActivityCommentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPostId()
        fetchPostById()
        setupToolBar()
        fetchpostbyIdcomments()
//        setContentView(R.layout.activity_comments)

    }
    fun obtainPostId(){
        postId = intent.extras?.getInt("POST_ID")?:0
    }

    fun fetchPostById(){
        val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getPostById(postId)
        request.enqueue(object : Callback<Post> {

            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful){
                    var post = response.body()
                    binding.tvPostTitle.text =post?.title
                    binding.tvTextBody.text = post?.body
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(baseContext,t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
    fun setupToolBar(){
        setSupportActionBar(binding.toolbarComments)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }
    fun fetchpostbyIdcomments(){
        var retro=ApiClient.buildApiClient((ApiInterface::class.java))
        var request=retro.getComments()
        request.enqueue(object :Callback<List<Comment>>{
            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                if(response.isSuccessful){
                    var commentss=response.body()?: emptyList()
                    displayComments(commentss)

                }
            }

            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }

        })
    }
    fun displayComments(commentList:List<Comment>){
        val commentsAdapter=displayCommentsRvAdapter(commentList)
        binding.rvComments.layoutManager=LinearLayoutManager(this)
        binding.rvComments.adapter=commentsAdapter
    }
}