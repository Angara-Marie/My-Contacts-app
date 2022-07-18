package dev.angara.mycontacts

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import dev.angara.mycontacts.databinding.ContactListItemBinding
import kotlin.coroutines.coroutineContext

class ContactRvAdapter(var contactList: List<Contact>) :
    RecyclerView.Adapter<ContactsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        var binding = ContactListItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        var contactsViewHolder = ContactsViewHolder(binding)
        return contactsViewHolder
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        var currentContact = contactList.get(position)
        var contactBinding=holder.binding
        contactBinding.tvName.text=currentContact.name
        contactBinding.tvNumber.text=currentContact.phoneNumber
        contactBinding.tvEmail.text=currentContact.email
        contactBinding.tvAddress.text=currentContact.address

        Picasso.get()
            .load(currentContact.image)
            .placeholder(R.drawable.ic_baseline_person_24)
            .error(R.drawable.ic_baseline_error_outline_24)
            .resize(300,300)
            .centerCrop()
            .into(holder.binding.ivContact)
        val context = holder.itemView.context
        holder.binding.ivContact.setOnClickListener {
            Toast.makeText(context,"You have clicked on ${currentContact.name} the image", Toast.LENGTH_SHORT).show()
        }


      contactBinding.cvContact.setOnClickListener {
          val intent=Intent(context,ViewContactActivity::class.java)
          intent.putExtra("NAME",currentContact.name)
          intent.putExtra("PHONE_NUMBER",currentContact.phoneNumber)
          intent.putExtra("EMAIL",currentContact.email)
          intent.putExtra("ADDRESS",currentContact.address)
          intent.putExtra("IMAGE",currentContact.image)

      }

    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}

class ContactsViewHolder(var binding:ContactListItemBinding) : RecyclerView.ViewHolder(binding.root)

