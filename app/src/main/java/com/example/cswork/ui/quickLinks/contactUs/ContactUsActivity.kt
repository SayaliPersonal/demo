package com.example.cswork.ui.quickLinks.contactUs

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cswork.R
import com.example.cswork.data.model.ContactUs
import com.example.cswork.data.viewModel.ContactUsViewModel
import com.example.cswork.network.AzureRetrofitService
import com.example.cswork.network.EndPoints
import com.google.gson.Gson
import com.sayali.network.APIClient
import com.sayali.network.APIService
import kotlinx.android.synthetic.main.activity_contact_us.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ContactUsActivity : AppCompatActivity() {

    private lateinit var contactUsViewModel: ContactUsViewModel
    private lateinit var progressBar: ProgressBar
    private lateinit var parentLayout: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_us)

        progressBar = findViewById(R.id.progress_bar)
        parentLayout = findViewById(R.id.parent_layout)
        progressBar.visibility = View.VISIBLE
        parentLayout.visibility = View.GONE

//        contactUsViewModel = ViewModelProvider(this).get(ContactUsViewModel::class.java)
//        contactUsViewModel.getContactUsData()!!.observe(this, Observer { contactUs ->
//               if( contactUs.isValid == true){
//                   cu_contact_no.text =  contactUs.data!!.contactNumber
//                   cu_mail.text = contactUs.data.emailId
//                   cu_add.text = contactUs.data.address
//
//               }else{
//                   val errorMessage = contactUs.errorMsg ?: "Error while loading the data"
//                   Toast.makeText(this@ContactUsActivity, errorMessage.toString(), Toast.LENGTH_LONG).show()
//               }
//        })



        cu_contact_no.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:" + cu_contact_no.text)
            startActivity(intent)
        }

        cu_mail.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("mailto:" + cu_mail.text)
            startActivity(intent)
        }

        onContactUsAPICall()
    }

    fun onBackClick(view: View) {
        onBackPressed()
    }

    private fun onContactUsAPICall() {
        val endPoints: EndPoints = AzureRetrofitService.getClient().create(EndPoints::class.java)
        val contactUsCall: Call<ContactUs>? = endPoints.contactUs()
        contactUsCall!!.enqueue(object : Callback<ContactUs>{
            override fun onResponse(call: Call<ContactUs?>, response: Response<ContactUs?>) {
                if (progressBar.visibility == View.VISIBLE) {
                    progressBar.visibility = View.GONE
                    parentLayout.visibility = View.VISIBLE
                }
                Log.i("D", "onContactUsAPICall")
                if (response.isSuccessful) {
                    Log.i("D", "@@@@@@@@@@@@@@@@@@@@@@")
                    Log.d("D", Gson().toJson(response.body()))
                    if(response.body() != null) {
                        val contactUs = response.body()
                        if (contactUs!!.isValid == true) {
                            cu_contact_no.text = contactUs.data!!.contactNumber
                            cu_mail.text = contactUs.data.emailId
                            cu_add.text = contactUs.data.address

                        } else {
                            val errorMessage = contactUs.errorMsg ?: "Error while loading the data"
                            Toast.makeText(
                                this@ContactUsActivity,
                                errorMessage.toString(),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }

                } else {
                    Log.d("D", " NOT (response.isSuccessful())")
                }
            }

            override fun onFailure(call: Call<ContactUs?>, t: Throwable) {
                if (progressBar.visibility == View.VISIBLE) {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this@ContactUsActivity, "Error while loading", Toast.LENGTH_LONG).show()
                    finish()
                }
                Log.d("Error", "*****************")
                Log.d("Error", t.localizedMessage!!)
            }
        })
    }

//    private fun getData() {
//        val apiService = APIClient.getRetrofitInstance().create(APIService::class.java)
//        try {
//            val model: ContactUsViewModel =
//                ViewModelProvider(this).get(ContactUsViewModel::class.java)
//            model.getContact()!!.observe(this, Observer {
//                if (it!!.body()!!.isValid) {
//                    Toast.makeText(this, it!!.body()!!.data.address, Toast.LENGTH_SHORT).show()
//                    Toast.makeText(this, it!!.body()!!.data.address, Toast.LENGTH_SHORT).show()
//                    Log.e("***getData", it!!.body()!!.data.toString())
//                    val response = it!!.body()!!.data!!
//                    cu_contact_no.text = response.contactNumber
//                    cu_add.text = response.address
//                    cu_mail.text = response.emailId
//                }
////
//            })
//
//        } catch (e: Exception) {
//            Log.e("EXception", e.message.toString())
//        }
//
//
//    }
}