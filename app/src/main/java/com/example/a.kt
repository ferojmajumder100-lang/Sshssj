package com.example

import android.content.Context
import android.util.Base64
import kotlin.system.exitProcess

object a {
    fun b1(): String = String(Base64.decode("aHR0cHM6Ly9saW1pdGVkLmZhY2Vib29rLmNvbS8=", Base64.DEFAULT))
    
    fun p(): String = String(Base64.decode("ZmIudG9vLnByby54", Base64.DEFAULT)) 
    
    fun n(): String = String(Base64.decode("RkIgVE9PTCBQUk8=", Base64.DEFAULT)) 

    fun c(context: Context) {
        if (context.packageName != p() || context.getString(R.string.app_name) != n()) {
            exitProcess(0)
        }
    }
}
