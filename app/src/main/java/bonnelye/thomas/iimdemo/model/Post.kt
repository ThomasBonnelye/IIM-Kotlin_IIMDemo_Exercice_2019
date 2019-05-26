package bonnelye.thomas.iimdemo.model

import java.io.Serializable

class Post(
    var userId : Int,
    var id: Int,
    var title : String,
    var body : String
): Serializable