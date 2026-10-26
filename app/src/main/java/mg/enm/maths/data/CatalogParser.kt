package mg.enm.maths.data

import org.json.JSONObject

object CatalogParser {
    fun parse(json: String): List<Track> {
        val root = JSONObject(json)
        val array = root.getJSONArray("tracks")
        val tracks = ArrayList<Track>()
        for (i in 0 until array.length()) {
            val o = array.getJSONObject(i)
            val chaptersJson = o.getJSONArray("chapters")
            val chapters = ArrayList<String>()
            for (j in 0 until chaptersJson.length()) {
                chapters.add(chaptersJson.getString(j))
            }
            tracks.add(
                Track(
                    id = o.getString("id"),
                    title = o.getString("title"),
                    exam = o.getString("exam"),
                    verified = o.optBoolean("verified", false),
                    chapters = chapters
                )
            )
        }
        return tracks
    }
}
