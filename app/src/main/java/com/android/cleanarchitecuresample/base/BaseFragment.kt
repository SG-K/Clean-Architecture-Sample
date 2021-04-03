package com.android.cleanarchitecuresample.base

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.android.cleanarchitecuresample.R
import com.android.cleanarchitecuresample.base.usecasetypes.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren

abstract class BaseFragment <VM : BaseViewModel> : Fragment() {

    lateinit var viewModel: VM
    val job = Job()
    val coroutineScope = CoroutineScope(Dispatchers.Main + job)

    override fun onDetach() {
        super.onDetach()
        coroutineScope.coroutineContext.cancelChildren()
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.viewModel = getInjectViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    abstract fun getInjectViewModel(): VM

    fun isViewLive() = isAdded && view != null

    protected open fun initViews() {

    }

    protected fun openUrl(url: String) {
        try {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        } catch (e: ActivityNotFoundException) {
        }
    }


    fun refer() {
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(Intent.EXTRA_TITLE, R.string.app_name)
        sendIntent.putExtra(Intent.EXTRA_TEXT,
                "Stylish Fonts express your LOVE with Stylish Fonts @ Whatsapp Facebook any chat app. I have been using it in a while, give it a try  : https://play.google.com/store/apps/details?id=${activity?.packageName}&h=en")
        sendIntent.type = "text/plain"
        startActivity(sendIntent)
    }

    fun rateUs() {
        activity?.let {
            Toast.makeText(it, "Thanks message", Toast.LENGTH_SHORT).show()
            val intent = Intent(Intent.ACTION_VIEW)
            // Try Google play
            intent.data = Uri
                    .parse("https://play.google.com/store/apps/details?id=${it.packageName}&h=en")
            startActivity(intent)
        }

    }

    fun SendEmail() {
        val send = Intent(Intent.ACTION_SENDTO)
        var pInfo: PackageInfo? = null
        try {
            activity?.packageName?.let {
                pInfo =activity?. packageManager?.getPackageInfo(it, 0)
            }
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        val Appversion = pInfo?.versionName
        val androidOS = Build.VERSION.RELEASE
        val uriText = ("mailto:"
                + Uri.encode("email@id")
                + "App name : " + resources.getString(R.string.app_name) + "\n"
                + "App version : " + Appversion + "\n"
                + "Android version : " + androidOS)
        val uri = Uri.parse(uriText)
        send.data = uri
        startActivity(Intent.createChooser(send, "Send mail..."))
    }

    fun moreApps() {
        val more = Intent(Intent.ACTION_VIEW)
        more.data = Uri.parse("market://search?q=pub:" + "DEV_NAME")
        startActivity(more)
    }

}