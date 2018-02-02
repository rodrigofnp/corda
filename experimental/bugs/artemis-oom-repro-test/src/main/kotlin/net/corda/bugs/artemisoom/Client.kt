package net.corda.bugs.artemisoom

import net.corda.client.rpc.CordaRPCClient
import net.corda.client.rpc.CordaRPCClientConfiguration
import net.corda.core.utilities.NetworkHostAndPort
import net.corda.core.utilities.seconds

fun client(useWrongPort: Boolean) {
    val target = NetworkHostAndPort("localhost", if (useWrongPort) { 16661 } else { 16662 })
    val config = CordaRPCClientConfiguration(
            connectionMaxRetryInterval = 10.seconds
    )
    println("Connecting RPC client ...")
    CordaRPCClient(target, config).use("corda", "S0meS3cretW0rd") {
        println("RPC client connected")
        val client = it.proxy
        val nodeInfo = client.nodeInfo()
        println("Platform Version = ${nodeInfo.platformVersion}")
    }

}