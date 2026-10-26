package mg.enm.maths

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private data class Entry(val id: String, val label: String)

    private val entries = listOf(
        Entry("bepc", "BEPC — Mathématiques"),
        Entry("bac_a", "Baccalauréat série A"),
        Entry("bac_c", "Baccalauréat série C"),
        Entry("bac_d", "Baccalauréat série D"),
        Entry("sujets", "Sujets d’examens"),
        Entry("exercices", "Exercices corrigés"),
        Entry("qcm", "QCM et entraînements"),
        Entry("resultats", "Mes résultats"),
        Entry("favoris", "Favoris"),
        Entry("apropos", "À propos")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val container = findViewById<LinearLayout>(R.id.container)
        val density = resources.displayMetrics.density

        for (entry in entries) {
            val button = MaterialButton(this)
            button.text = entry.label
            button.isAllCaps = false
            button.minimumHeight = (56 * density).toInt()
            val params = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            params.topMargin = (8 * density).toInt()
            button.layoutParams = params
            button.setOnClickListener {
                val intent = Intent(this, SectionActivity::class.java)
                    .putExtra(SectionActivity.EXTRA_ID, entry.id)
                    .putExtra(SectionActivity.EXTRA_TITLE, entry.label)
                startActivity(intent)
            }
            container.addView(button)
        }
    }
}
