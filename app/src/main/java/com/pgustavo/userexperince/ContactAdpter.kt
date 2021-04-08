package com.pgustavo.userexperince

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ContactAdpter (var listener: ClickItemContactListener):
     RecyclerView.Adapter<ContactAdpter.ContactAdapterViewholder>() {

    private val list: MutableList<Contact> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactAdapterViewholder(view, list, listener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ContactAdapterViewholder, position: Int) {
        holder.bind(list[position])
    }

    fun updateList (list1: List<Contact>) {
            this.list.clear()
            this.list.addAll(list1)
            notifyDataSetChanged()
    }

    class ContactAdapterViewholder(intemView: View, var list: List<Contact>, var listener: ClickItemContactListener):
        RecyclerView.ViewHolder(intemView) {
        private val tvName: TextView = intemView.findViewById(R.id.tv_name)
        private val tvPhone: TextView = intemView.findViewById(R.id.tv_Phone)
        private val ivPhotograph: ImageView = intemView.findViewById(R.id.IV_photograph)

        init {
            intemView.setOnClickListener{
                listener.clickItemContact(list[adapterPosition])
            }
        }

        fun bind(contact: Contact) {
            tvName.text = contact.name
            tvPhone.text = contact.phone

        }
    }
}