package com.smkcoding.projectsatu

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_profil.*

class ProfilActivity : AppCompatActivity() {

    companion object{
        val REQUEST_CODE = 100
    }

    private fun navigasiKeEditNama(){
        val intent = Intent(this, EditNameActivity::class.java)
        val namaUser = txtName.text.toString()
        intent.putExtra("nama", namaUser)
        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE)
            if(resultCode == Activity.RESULT_OK) {
                val result = data?.getStringExtra("nama")
                txtName.text = result
            }else{
                Toast.makeText(this, "Edit Failed", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        ambilData()

        btnEditName.setOnClickListener { navigasiKeEditNama() }

    }

    private fun ambilData(){
        val bundle = intent.extras

        val nama = bundle?.getString("nama")
        val gender = bundle?.getString("gender")
        val umur = bundle?.getString("umur")
        val email = bundle?.getString("email")
        val telp = bundle?.getString("telp")
        val alamat = bundle?.getString("alamat")

        txtName.text=nama
        txtGender.text=gender
        txtAge.text=umur
        txtEmail.text=email
        txtTelp.text=telp
        txtAddress.text=alamat

    }
}

