@file:Suppress("unused")

package br.com.gabriellferreira.baseclean.presentation.util.extension

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.replaceFragmentAllowingStateLoss(container: Int, fragment: Fragment) {
    val fragmentTransaction = supportFragmentManager.beginTransaction()
    fragmentTransaction.replace(container, fragment)
    fragmentTransaction.addToBackStack(null)
    fragmentTransaction.commitAllowingStateLoss()
}