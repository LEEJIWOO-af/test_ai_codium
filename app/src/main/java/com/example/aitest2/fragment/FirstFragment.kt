package com.example.aitest2.fragment

import AppInfoAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aitest2.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)

        binding.btnGetInfo.setOnClickListener {

            val context = activity?.applicationContext ?: return@setOnClickListener

            val packageManager = context.packageManager

            val versionName = packageManager.getPackageInfo(context.packageName, 0).versionName
            val versionCode = packageManager.getPackageInfo(context.packageName, 0).versionCode

            val label = packageManager.getApplicationLabel(context.applicationInfo)
            val icon = packageManager.getApplicationIcon(context.applicationInfo)

            val infoList = listOf(
                "Version Name: $versionName",
                "Version Code: $versionCode",
                "Label: $label",
                "Icon: ${icon.toString()}" // Note: Icon is a Drawable, so we convert it to a string
            )
            binding.recyclerView.adapter =  AppInfoAdapter(infoList)
            binding.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        return binding.root
    }
}