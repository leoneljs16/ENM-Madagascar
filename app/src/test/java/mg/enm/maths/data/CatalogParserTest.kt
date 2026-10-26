package mg.enm.maths.data

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test

class CatalogParserTest {

    @Test
    fun parseUnParcoursAvecChapitres() {
        val json = """
            {"tracks":[{"id":"bepc","title":"BEPC","exam":"BEPC",
            "verified":false,"chapters":["Pythagore","Thalès"]}]}
        """.trimIndent()

        val tracks = CatalogParser.parse(json)

        assertEquals(1, tracks.size)
        assertEquals("bepc", tracks[0].id)
        assertFalse(tracks[0].verified)
        assertEquals(listOf("Pythagore", "Thalès"), tracks[0].chapters)
    }
}
