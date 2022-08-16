package com.example.tdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.tdd.authorize.AuthorizeFragment
import com.example.tdd.login.LoginFragment
import com.example.tdd.main.MainFragment
import com.example.tdd.register.RegisterFragment
import com.example.tdd.router.Route
import com.example.tdd.router.Router

lateinit var Router: Router

class MainActivity : AppCompatActivity(), Router {

    private val mainFragment = MainFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.fragment_container_view, mainFragment)
            .commit()

        Router = this
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
        }
    }

    private val routerTable: Map<String, Class<out Fragment>> = mapOf(
        "/register" to RegisterFragment::class.java,
        "/login" to LoginFragment::class.java,
        "/authorize" to AuthorizeFragment::class.java,
    )

    override fun navigate(route: Route): Boolean {
        val targetFragment = getPathFragment(route) ?: return false

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, targetFragment)
            .addToBackStack("")
            .commit()
        return true
    }

    private fun getPathFragment(route: Route): Fragment? {
        return routerTable[route.path]?.newInstance()
    }

}
