package id.trydev.alumnifstku.ui.dashboard

import android.content.Intent
import id.trydev.alumnifstku.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import id.trydev.alumnifstku.ui.kelas.KelasListActivity
import id.trydev.alumnifstku.ui.tracelist.TraceListActivity
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        img_tracing.setOnClickListener(this)
        img_loker.setOnClickListener(this)
        img_sharing.setOnClickListener(this)
        img_kelas.setOnClickListener(this)
        img_news.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        when(v.id){

            // Tracing Alumni
            R.id.img_tracing -> {
                // panggang("Tracing Alumni")
                intent = Intent(this, TraceListActivity::class.java)
                startActivity(intent)
            }

            // Info Loker
            R.id.img_loker -> {
                panggang("Info Loker")
            }

            // Sharing Memory
            R.id.img_sharing -> {
                panggang("Sharing Memory")
            }

            // Kelas Alumni
            R.id.img_kelas -> {
                // panggang("Kelas Alumni")
                intent = Intent(this, KelasListActivity::class.java)
                startActivity(intent)
            }

            // FST NEWS
            R.id.img_news -> {
                panggang("FST News")
            }
        }


    }

    fun panggang(string: String){
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
    }
}