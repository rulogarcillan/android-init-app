package com.tuppersoft.squeleton.core.platform

import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

abstract class GlobalActivity : AppCompatActivity() {

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
            else -> return true
        }
        return true
    }
}

