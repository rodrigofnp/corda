package net.corda.nodeapi.internal.serialization.amqp

import net.corda.core.serialization.SerializedBytes
import net.corda.testing.common.internal.ProjectStructure.projectRootDir
import org.junit.Test
import java.io.File
import java.net.URI
import kotlin.test.assertEquals

class SecurityTests {
    @Suppress("UNUSED")
    var localPath = projectRootDir.toUri().resolve(
            "node-api/src/test/resources/net/corda/nodeapi/internal/serialization/amqp")

    @Test
    fun swapProperty() {
        val sf = testDefaultFactory()
        val resource = "SecurityTests.swapProperty"


        // Original version of the class for the serialised version of this class
        data class C (val a: Int, val b: Int)
        File(URI("$localPath/$resource")).writeBytes(SerializationOutput(sf).serialize(C(100, 200)).bytes)

        /*
        // new version of the class, in this case the order of the parameters has been swapped
        data class C(val b: Int, val a: Int)

        val path = EvolvabilityTests::class.java.getResource(resource)
        val f = File(path.toURI())

        val sc2 = f.readBytes()
        val deserializedC = DeserializationInput(sf).deserialize(SerializedBytes<C>(sc2))

        assertEquals(A, deserializedC.a)
        assertEquals(B, deserializedC.b)
        */
    }
}