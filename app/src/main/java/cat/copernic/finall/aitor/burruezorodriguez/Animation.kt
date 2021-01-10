package cat.copernic.finall.aitor.burruezorodriguez

import android.app.Activity

class Animation {

    fun slideRight(mainActivity: Activity) {
        (mainActivity as Activity).overridePendingTransition(
            R.anim.slide_in_rigth,
            R.anim.slide_out_left
        )
    }

    fun slideLeft(mainActivity: Activity) {
        (mainActivity as Activity).overridePendingTransition(
            R.anim.slide_in_left,
            R.anim.slide_out_rigth
        )
    }

}