package mg.enm.maths

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import mg.enm.maths.data.CatalogRepository

class SectionActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "section_id"
        const val EXTRA_TITLE = "section_title"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_section)

        val id = intent.getStringExtra(EXTRA_ID).orEmpty()
        val title = intent.getStringExtra(EXTRA_TITLE).orEmpty()

        findViewById<TextView>(R.id.section_title).text = title
        val note = findViewById<TextView>(R.id.section_note)
        val list = findViewById<ListView>(R.id.section_list)

        val track = CatalogRepository(this).tracks().firstOrNull { it.id == id }
        when {
            track != null -> {
                note.text = if (track.verified) "" else getString(R.string.programme_non_verifie)
                list.adapter = ArrayAdapter(
                    this,
                    android.R.layout.simple_list_item_1,
                    track.chapters
                )
            }
            id == "apropos" -> note.text = getString(R.string.a_propos_texte)
            else -> note.text = getString(R.string.bientot)
        }
    }
}
