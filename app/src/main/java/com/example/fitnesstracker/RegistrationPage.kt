package com.example.fitnesstracker

import android.content.Context
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fitnesstracker.MVP.RegistrationPresenter
import com.example.fitnesstracker.MVP.RegistrationView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegistrationPage : Fragment(R.layout.fragment_registration_page), RegistrationView  {

    private val presenter = RegistrationPresenter()

    private val sharedPrefs by lazy {
        requireContext().getSharedPreferences("Tokens", Context.MODE_PRIVATE)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.attachView(this)
        presenter.setNavController(findNavController())

        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        view.findViewById<Button>(R.id.registrationButton).setOnClickListener {
            if(view.findViewById<TextInputEditText>(R.id.passwordInput).text.toString() == view.findViewById<TextInputEditText>(R.id.passwordRepeatInput).text.toString()) {
                presenter.onRegistrationClicked(
                    view.findViewById<TextInputEditText>(R.id.loginInput).text.toString(),
                    view.findViewById<TextInputEditText>(R.id.passwordInput).text.toString(),
                    view.findViewById<TextInputEditText>(R.id.nameInput).text.toString(),
                    view.findViewById<RadioGroup>(R.id.genderGroup).checkedRadioButtonId - 1
                )
            }
            else
                showToast("Пароли не совпадают")
        }

        val textView = view.findViewById<TextView>(R.id.agreement)
        val string_agreement = SpannableString("Нажимая на кнопку, вы соглашаетесь с политикой конфиденциальности и обработки персональных данных, а также принимаете пользовательское соглашение")

        val SpanPolitic: ClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                showToast("Политика конфиденциальности")
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
            }
        }

        val SpanAgree: ClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                showToast("Пользовательское соглашение")
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
            }
        }

        string_agreement.setSpan(SpanPolitic, 37, 65, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        string_agreement.setSpan(SpanAgree, 118, 145, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        textView.text = string_agreement
        textView.movementMethod = LinkMovementMethod.getInstance()
    }

    override fun saveToken(token: String) {
        sharedPrefs.edit().putString("Token", token).apply()
    }

    override fun onDestroyView() {
        presenter.detachView()
        super.onDestroyView()
    }

    override fun showLoginError() {
        view?.findViewById<TextInputLayout>(R.id.login)?.error = "Введите логин"
    }

    override fun showNameError() {
        view?.findViewById<TextInputLayout>(R.id.name)?.error = "Введите имя"
    }

    override fun showPasswordError() {
        view?.findViewById<TextInputLayout>(R.id.password)?.error = "Введите пароль"
    }


    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}