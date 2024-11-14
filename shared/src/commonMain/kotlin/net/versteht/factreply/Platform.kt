package net.versteht.factreply

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform