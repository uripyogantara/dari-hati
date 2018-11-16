package id.futnet.darihati

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.futnet.darihati.ui.login.LoginActivity
import kotlinx.android.synthetic.main.fragment_profil.*
import org.jetbrains.anko.support.v4.ctx
import id.futnet.darihati.utils.PreferencesHelper
import org.jetbrains.anko.support.v4.startActivity

class ProfilFragment :Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profil,container,false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val preferencesHelper= PreferencesHelper(ctx)

        tv_user_name.text=preferencesHelper.name
        tv_user_address.text=preferencesHelper.address
        tv_user_phone.text=preferencesHelper.phone
        tv_user_email.text=preferencesHelper.email
        tv_logout.setOnClickListener({
            preferencesHelper.login=false
            activity?.finish()
            startActivity<LoginActivity>()
        })
    }
}