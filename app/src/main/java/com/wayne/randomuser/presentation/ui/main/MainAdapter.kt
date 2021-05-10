package com.wayne.randomuser.presentation.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wayne.library.ext.whenNotNullNorEmpty
import com.wayne.randomuser.databinding.ItemUserBinding
import com.wayne.randomuser.presentation.model.UserPresentation


class MainAdapter(private val onItemClick: (UserPresentation) -> Unit) :
    RecyclerView.Adapter<MainAdapter.MainVH>() {

    val items: MutableList<UserPresentation> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainVH {
        return MainVH(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            binding.root.setOnClickListener { binding.item?.let(onItemClick) }
        }
    }

    override fun onBindViewHolder(holder: MainVH, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = items.size

    inner class MainVH(val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            binding.item = items[bindingAdapterPosition]
        }
    }
}

@BindingAdapter("addUserList")
fun RecyclerView.bindAddUserList(items: List<UserPresentation>?) {
    items.whenNotNullNorEmpty { userList ->
        (adapter as? MainAdapter)?.let { adapter ->
            adapter.items.addAll(userList.toList())
            adapter.notifyItemRangeChanged(adapter.itemCount - userList.size, userList.size)
        }
    }
}