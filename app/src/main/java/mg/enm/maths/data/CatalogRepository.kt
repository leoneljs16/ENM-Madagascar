package mg.enm.maths.data

import android.content.Context

class CatalogRepository(private val context: Context) {
    fun tracks(): List<Track> {
        val text = context.assets.open("content/catalog.json")
            .bufferedReader(Charsets.UTF_8)
            .use { it.readText() }
        return CatalogParser.parse(text)
    }
}
