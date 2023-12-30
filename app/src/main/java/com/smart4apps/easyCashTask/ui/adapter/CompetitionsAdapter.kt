package com.smart4apps.easyCashTask.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smart4apps.easyCashTask.data.model.Competition
import com.smart4apps.easyCashTask.databinding.ItemCompetitonBinding
import javax.inject.Inject

class CompetitionsAdapter @Inject constructor(
) : RecyclerView.Adapter<CompetitionsAdapter.DataViewHolder>() {

    private var competitionsList: ArrayList<Competition> = ArrayList()

   var onItemClickListeners:OnItemClickListeners?=null

    inner class DataViewHolder(private val itemViewBinding: ItemCompetitonBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root) {
        fun bind(mItem: Competition) {
            itemViewBinding.item=mItem
            itemViewBinding.executePendingBindings()
            itemViewBinding.root.setOnClickListener {
                onItemClickListeners?.onCompetitionClicked(mItem)
            }

        }
    }


    interface OnItemClickListeners{
        fun onCompetitionClicked(competition: Competition?)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            ItemCompetitonBinding.inflate(LayoutInflater.from(parent.context))
        )

    override fun getItemCount(): Int = competitionsList.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(competitionsList[position])

    fun addData(competitionsList: List<Competition>) {
        this.competitionsList.apply {
            clear()
            addAll(competitionsList)
            notifyDataSetChanged()
        }
    }

}