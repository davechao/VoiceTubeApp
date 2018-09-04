package com.test.voicetubeapp.ui.setting

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import com.test.voicetubeapp.R
import com.test.voicetubeapp.repository.model.SettingItem

class SettingAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_SETTING_HEADER = 0
        const val VIEW_TYPE_SETTING = 1
    }

    private lateinit var context: Context

    private var settingList: MutableList<Any> = arrayListOf()
    var settingMap: MutableMap<String, Boolean> = hashMapOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        var holder: RecyclerView.ViewHolder
        when(viewType) {
            VIEW_TYPE_SETTING_HEADER -> {
                val mView = LayoutInflater.from(parent.context).inflate(R.layout.item_setting_header, parent, false)
                holder = SettingHeaderViewHolder(mView)
            } else -> {
                val mView = LayoutInflater.from(parent.context).inflate(R.layout.item_setting, parent, false)
                holder = SettingViewHolder(mView)
            }
        }
        return holder
    }

    override fun getItemViewType(position: Int): Int {
        val item = settingList[position]
        return if(item is String) {
            VIEW_TYPE_SETTING_HEADER
        } else {
            VIEW_TYPE_SETTING
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = settingList[position]

        if (holder is SettingHeaderViewHolder) {
            item as String
            holder.settingHeaderText.text = item
        } else if(holder is SettingViewHolder) {
            item as SettingItem
            holder.settingTitleText.text = item.name
            holder.settingSwitch.isChecked = item.isOpen
            holder.settingSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
                settingMap[item.name] = isChecked
            }
        }
    }

    override fun getItemCount() = settingList.size

    fun setData(map: MutableMap<String, Boolean>, list: MutableList<Any>) {
        settingMap = map
        settingList = list
        notifyDataSetChanged()
    }

    class SettingHeaderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val settingHeaderText = itemView.findViewById<TextView>(R.id.settingHeaderText)
    }

    class SettingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val settingTitleText = itemView.findViewById<TextView>(R.id.settingTitleText)
        val settingSwitch = itemView.findViewById<Switch>(R.id.settingSwitch)
    }

}