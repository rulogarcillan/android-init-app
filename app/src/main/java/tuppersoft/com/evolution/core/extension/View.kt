package tuppersoft.com.evolution.core.extension

import android.view.View

/**
 * Created by Raúl Rodríguez Concepción on 2019-06-16.
 *
 * raulrcs@gmail.com
 */

fun View.isVisible() = this.visibility == View.VISIBLE

fun View.visible() {
    this.post { this.visibility = View.VISIBLE }
}

fun View.gone() {
    this.post { this.visibility = View.GONE }
}