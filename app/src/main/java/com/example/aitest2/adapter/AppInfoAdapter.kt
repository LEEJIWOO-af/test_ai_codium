import android.health.connect.datatypes.AppInfo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.aitest2.R
import com.example.aitest2.databinding.ItemAppInfoBinding

class AppInfoAdapter(private val appInfoList: List<String>) :
    RecyclerView.Adapter<AppInfoAdapter.AppInfoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppInfoViewHolder {
        val binding = DataBindingUtil.inflate<ItemAppInfoBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_app_info,
            parent,
            false
        )
        return AppInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AppInfoViewHolder, position: Int) {
        val appInfo = appInfoList[position]
        holder.bind(appInfo)
    }

    override fun getItemCount() = appInfoList.size

    inner class AppInfoViewHolder(private val binding: ItemAppInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(appInfo: String) {
            binding.textView.text = appInfo // or whatever text you want to display
        }
    }
}