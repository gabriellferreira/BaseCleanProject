package br.com.gabrielferreira.baseclean.presentation.util.extension

import android.support.v7.app.AppCompatActivity

fun AppCompatActivity.replaceFragmentAllowingStateLoss(container: Int, fragment: android.support.v4.app.Fragment) {
    val fragmentTransaction = supportFragmentManager.beginTransaction()
    fragmentTransaction.replace(container, fragment)
    fragmentTransaction.addToBackStack(null)
    fragmentTransaction.commitAllowingStateLoss()
}