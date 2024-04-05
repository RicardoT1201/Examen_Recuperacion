package com.example.examen_recuperacion.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examen_recuperacion.R
import com.example.examen_recuperacion.model.TipModel

class TipAdapter : RecyclerView.Adapter<TipAdapter.TipViewHolder>() {
    private var tipList: List<TipModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tip, parent, false)
        return TipViewHolder(view)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        val tip = tipList[position]
        holder.bind(tip)
    }

    override fun getItemCount(): Int {
        return tipList.size
    }

    fun setTips(tips: List<TipModel>) {
        tipList = tips
        notifyDataSetChanged()
    }

    inner class TipViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tip: TipModel) {
            itemView.findViewById<TextView>(R.id.txtTipAmount).text = tip.amount.toString()
        }
    }
}
