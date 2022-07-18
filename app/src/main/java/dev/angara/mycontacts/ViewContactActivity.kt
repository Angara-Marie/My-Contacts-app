package dev.angara.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import dev.angara.mycontacts.databinding.ActivityViewContactBinding

class ViewContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getEtras()
    }
    fun getEtras(){
        val extras = intent.extras
        val name = extras?.getString("NAME", "")
        var email = extras?.getString("EMAIL", "")
        var phoneNumber = extras?.getString("PHONE_NUMBER", "")
        var address = extras?.getString("ADDRESS", "")
        var image=binding.imgContact


        binding.tvContactName.text= name
        binding.tvPhoneNumber2.text=phoneNumber



        Toast.makeText(this, "$name:$email", Toast.LENGTH_LONG).show()
        Picasso.get().load(intent.getStringExtra("Image")).into(image)
    }
}