package dev.angara.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dev.angara.mycontacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
     lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayContacts()
    }
    fun displayContacts(){
        var contact1 = Contact("Tessa", "0716507709", "angaramarie@gmail.com", "616 KOrongo road", "https://images.unsplash.com/photo-1583994009785-37ec30bf9342?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTh8fGJsYWNrJTIwcGVvcGxlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60")
        var contact2 = Contact("Marie", "0116507709", "angaramarie1@gmail.com", "SouthC", "https://images.unsplash.com/photo-1531384441138-2736e62e0919?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTN8fGJsYWNrJTIwcGVvcGxlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60")
        var contact3 = Contact("Angara", "0216507709", "angaramarie2@gmail.com", "Umoja Innercore", "https://images.unsplash.com/photo-1502685104226-ee32379fefbe?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjB8fGJsYWNrJTIwcGVvcGxlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60")
        var contact4 = Contact("Quinn", "0316507709", "angaramarie3@gmail.com", "Zimmerman", "https://media.istockphoto.com/photos/shot-of-a-confident-young-businessman-looking-thoughtfully-out-of-a-picture-id1347777964?b=1&k=20&m=1347777964&s=170667a&w=0&h=JFxwpbb64jAEMGp_lJEkIXgwudjPeyJCF4MxD0hd4ms=")
        var contactsList = listOf(contact1,contact2,contact3,contact4)
        var contactsAdapter= ContactRvAdapter(contactsList)
        binding.rvContacts.layoutManager = LinearLayoutManager(this,)
        binding.rvContacts.adapter = contactsAdapter
    }
}