package com.example.myapplication.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Model.Contact
import com.example.myapplication.R

class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var name: TextView = view.findViewById(R.id.txt_name)

}

class MainRecyclerViewAdapter(
    private var contact: List<Contact>,
    private val onClickListener: OnClickListener
) : RecyclerView.Adapter<ContactViewHolder>() {

    fun loadData(newContacts: List<Contact>) {
        contact = newContacts
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.contact_adapter, parent, false)
        return ContactViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contact[position]

        holder.name.text = contact.firstName + contact.lastName
        holder.itemView.setOnClickListener {
            onClickListener.onClick(contact)
        }

    }

    override fun getItemCount(): Int {
        return contact.size
    }

    class OnClickListener(val clickListener: (contact: Contact) -> Unit) {
        fun onClick(contact: Contact) = clickListener(contact)
    }
}
