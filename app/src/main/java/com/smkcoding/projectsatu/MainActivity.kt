package com.smkcoding.projectsatu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var nameInput : String =  ""
    private var genderInput : String =  ""
    private var ageInput : String =  ""
    private var emailInput : String =  ""
    private var telpInput : String =  ""
    private var addressInput : String =  ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setDataSpinnerGender()

        btnSave.setOnClickListener {validasiInput() }
    }

    private fun setDataSpinnerGender() {
        val adapter = ArrayAdapter.createFromResource(this,R.array.jenis_kelamin, android.R.layout.simple_spinner_dropdown_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerGender.adapter=adapter
    }

    private fun validasiInput(){
        nameInput=edtName.text.toString()
        genderInput=spinnerGender.selectedItem.toString()
        ageInput=edtAge.text.toString()
        emailInput=edtEmail.text.toString()
        telpInput=edtTelp.text.toString()
        addressInput=edtAddress.text.toString()

        when{
            nameInput.isEmpty() -> edtName.error="Nama tidak boleh kosong"
            genderInput.equals("Pilih Jenis Kelamin", ignoreCase = true) -> tampilToast("Jenis Kelamin harus dipilih")
            ageInput.isEmpty() -> edtAge.error="Umur tidak boleh kosong"
            emailInput.isEmpty() -> edtEmail.error="Email tidak boleh kosong"
            telpInput.isEmpty() -> edtTelp.error="Telepon tidak boleh kosong"
            addressInput.isEmpty() -> edtAddress.error="Alamat tidak boleh kosong"

            else -> {
                tampilToast("Navigasi ke halaman profil")
                goToProfilActivity()
            }
        }
    }

    private fun tampilToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun goToProfilActivity(){
        val intent = Intent(this, ProfilActivity::class.java)

        val bundle = Bundle()
        bundle.putString("nama", nameInput)
        bundle.putString("gender", genderInput)
        bundle.putString("umur", ageInput)
        bundle.putString("email", emailInput)
        bundle.putString("telp", telpInput)
        bundle.putString("alamat", addressInput)

        intent.putExtras(bundle)
        startActivity(intent)
    }
}
