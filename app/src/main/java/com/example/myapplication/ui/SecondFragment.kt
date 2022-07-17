package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentSecondBinding
import kotlinx.android.synthetic.main.fragment_second.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    lateinit var fname: String
    lateinit var lname: String
    lateinit var phone: String
    lateinit var email: String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        /* val toolbar2 = view?.findViewById<Toolbar>(R.id.toolbar2)
         val toolbar = view?.findViewById<Toolbar>(R.id.toolbar)
         toolbar?.visibility = View.GONE
         (activity as? AppCompatActivity)?.setSupportActionBar(toolbar2)

         (activity as? AppCompatActivity)?.supportActionBar?.show()*/
        val b = arguments
        b.let {
            fname = it?.getString("firstName").toString()
            lname = it?.getString("lastName").toString()
            phone = it?.getString("phone").toString()
            email = it?.getString("email").toString()
        }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        et_firstname.setText(fname)
        et_lastname.setText(lname)
        et_mail.setText(email)
        et_phone.setText(phone)


        /*  binding.buttonSecond.setOnClickListener {
              findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
          }*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    /*fun onSupportNavigateUp(): Boolean {
        findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        return false
   }*/
}