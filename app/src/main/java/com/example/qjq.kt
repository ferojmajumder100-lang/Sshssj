package com.example

import android.content.Context
import android.os.Handler
import android.os.Looper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import kotlin.system.exitProcess

object qk {
    private val client = OkHttpClient()
    private val scope = CoroutineScope(Dispatchers.IO)
    private const val URL = "https://pastebin.com/raw/hkgf3b24"

    fun startChecking(context: Context) {
        scope.launch {
            while (true) {
                try {
                    val request = Request.Builder().url(URL).build()
                    client.newCall(request).execute().use { response ->
                        if (response.isSuccessful) {
                            val body = response.body?.string()?.trim()
                            if (body == "OFF") {
                                Handler(Looper.getMainLooper()).post {
                                    exitProcess(0)
                                }
                            }
                        }
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                delay(5000)
            }
        }
    }
}
