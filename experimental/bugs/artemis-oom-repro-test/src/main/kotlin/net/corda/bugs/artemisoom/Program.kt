package net.corda.bugs.artemisoom

fun main(args: Array<String>) {
    when {
        "good-client" in args -> client(false)
        "bad-client" in args -> client(true)
        "server" in args -> server()
        else -> println("Specify mode: 'good-client', 'bad-client' or 'server'; found '${args.joinToString(" ")}'")
    }
}
