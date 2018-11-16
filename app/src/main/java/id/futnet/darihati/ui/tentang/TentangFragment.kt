package id.futnet.darihati.ui.tentang

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.futnet.darihati.R
import kotlinx.android.synthetic.main.fragment_profil.*
import org.jetbrains.anko.support.v4.ctx
class TentangFragment :Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tentang,container,false)
    }
}