package com.tc.kmp.tutorial

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform