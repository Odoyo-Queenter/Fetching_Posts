package dev.queenter.myposts

data class Post(
    var userId: Int,
    var id:Int,
    var title:String,
    var body:String

)
data class Comment(
    var postId: Int,
    var id: Int,
    var name:String,
    var body: String,
    var email: String

)
fun <T> compareObjects(item1:T, item2:T):T{
    //Do something
    return  item1
}

