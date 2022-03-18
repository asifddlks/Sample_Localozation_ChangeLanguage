package com.asifddlks.samplelocalization

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.changelanguage.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }


    override fun onStart() {
        initListener()
        super.onStart()
    }

    private fun initListener() {
        buttonChangeLanguage.setOnClickListener {
            showChangeLang()
        }

        aboutMyselfButton.setOnClickListener {
            findNavController().navigate(R.id.detailsFragment)
        }

        buttonNextActivity.setOnClickListener {
            startActivity(Intent(requireActivity(), SimpleActivity2::class.java))
        }
    }


    private fun showChangeLang() {
        val langItem = arrayOf("اردو", "हिंदी", "বাংলা", "ENGLISH")

        val builder = AlertDialog.Builder(context)
        builder.setTitle("Change Language")
        builder.setSingleChoiceItems(langItem, -1) { dialog, which ->
            if (which == 0) {
                Utils.changeLanguage("ur", context)
            } else if (which == 1) {
                Utils.changeLanguage("hi", context)
            } else if (which == 2) {
                Utils.changeLanguage("bn", context)
            } else if (which == 3) {
                Utils.changeLanguage("en", context)
            }
            refresh()
            dialog.dismiss()
        }

        val dialog = builder.create()

        dialog.show()
    }


    private fun refresh() {
        findNavController().popBackStack()
        findNavController().navigate(R.id.loginFragment)
    }

}