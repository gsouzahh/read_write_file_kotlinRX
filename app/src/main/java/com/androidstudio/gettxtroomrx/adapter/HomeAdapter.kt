package com.androidstudio.gettxtroomrx.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidstudio.gettxtroomrx.databinding.ItemListBinding
import com.androidstudio.gettxtroomrx.network.FuncEntity

class HomeAdapter(
    var listas: List<FuncEntity>,
    private val clickList: (FuncEntity) -> Unit
    ) :
    RecyclerView.Adapter<HomeAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val allBinding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(allBinding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) = holder.bindView(listas[position], clickList)

    override fun getItemCount(): Int = listas.size

    fun getUsers(list: List<FuncEntity>) {
        listas = list
        notifyDataSetChanged()
    }

    class UserViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bindView(func: FuncEntity, click: (FuncEntity) -> Unit) {
            binding.txtNome.text = func.descFunc
            binding.txtCargo.text = "Cargo: ${func.complemento}"
            binding.body.setOnClickListener { click(func) }
        }
    }

    fun updateListener(func: List<FuncEntity>){
        listas = func
        notifyDataSetChanged()
    }
}