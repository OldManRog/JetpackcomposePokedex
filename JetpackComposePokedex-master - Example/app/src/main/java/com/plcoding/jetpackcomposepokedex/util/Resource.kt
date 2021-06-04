package com.plcoding.jetpackcomposepokedex.util


/** Generic Sealed class **/
sealed class Resource<T>(val data: T? = null, val message:String? = null){

    /** Success response always has data attached to it**/
    class Success<T>(data: T) : Resource<T>(data)
    /** Error response always has a message but may not have data **/
    class Error<T>(message:String,data: T? = null) : Resource<T>(data, message)
    /** Progress Dialog with data **/
    class Loading<T>(data: T? = null) : Resource<T>(data)

}
