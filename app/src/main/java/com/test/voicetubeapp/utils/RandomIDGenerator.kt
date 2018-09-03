package com.test.voicetubeapp.utils

import java.util.*

object RandomIDGenerator {
    fun generated(): String {
        return UUID.randomUUID().toString()
    }
}