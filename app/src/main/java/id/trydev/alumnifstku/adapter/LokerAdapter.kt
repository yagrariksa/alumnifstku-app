package id.trydev.alumnifstku.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import id.trydev.alumnifstku.R
import id.trydev.alumnifstku.databinding.ItemLokerBinding
import id.trydev.alumnifstku.model.Loker
import id.trydev.alumnifstku.utils.GlideApp
import java.text.SimpleDateFormat
import java.util.*

class LokerAdapter(private val context: Context, val onClick: (Loker)->Unit): RecyclerView.Adapter<LokerAdapter.ViewHolder>() {

    private val listLoker = mutableListOf<Loker>()
    fun populateItem(listLoker: List<Loker>) {
        this.listLoker.clear()
        this.listLoker.addAll(listLoker)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =ItemLokerBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listLoker[position])
    }

    override fun getItemCount(): Int = this.listLoker.size

    inner class ViewHolder(private val binding: ItemLokerBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Loker) {
            binding.tvLokerCompany.text = item.perusahaan
            binding.tvLokerPosition.text = item.jabatan
            if (item.poster!=null) {
                GlideApp.with(context)
                        .asBitmap()
                        .centerCrop()
                        .fallback(ContextCompat.getDrawable(context, R.color.grey))
                        .load(item.poster)
                        .into(binding.ivLoker)
            } else {
                binding.ivLoker.setImageResource(R.color.grey)
            }
            val formatter = SimpleDateFormat("EEE, dd MMM yyyy", Locale("in", "ID"))
            val strToDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale("in", "ID"))
                    .parse(item.updatedAt.toString())
            binding.tvLokerUpdate.text = formatter.format(strToDate)
            binding.itemBody.setOnClickListener{ onClick(item) }
        }

    }
}