package com.asifddlks.samplelocalization

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.asifddlks.samplelocalization.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onStart() {
        initListener()
        super.onStart()
    }

    private fun initListener() {
        binding.buttonChangeLanguage.setOnClickListener {
            showChangeLang()
        }

        binding.aboutMyselfButton.setOnClickListener {
            findNavController().navigate(R.id.detailsFragment)
        }

        binding.buttonNextActivity.setOnClickListener {
            startActivity(Intent(requireActivity(), SimpleActivity2::class.java))
        }
    }


    private fun showChangeLang() {
        val langItem = arrayOf("اردو", "हिंदी", "বাংলা", "ENGLISH")

        val builder = AlertDialog.Builder(context)
        builder.setTitle("Change Language")
        builder.setSingleChoiceItems(langItem, -1) { dialog, which ->
            if (which == 0) {
                Utils.changeLanguage(requireContext(), "ur")
            } else if (which == 1) {
                Utils.changeLanguage(requireContext(), "hi")
            } else if (which == 2) {
                Utils.changeLanguage(requireContext(), "bn")
            } else if (which == 3) {
                Utils.changeLanguage(requireContext(), "en")
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