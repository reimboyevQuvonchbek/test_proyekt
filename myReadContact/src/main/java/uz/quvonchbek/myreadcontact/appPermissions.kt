package uz.quvonchbek.myreadcontact

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


const val READ_CONTACTS= Manifest.permission.READ_CONTACTS
const val RECORD_AUDIO=Manifest.permission.RECORD_AUDIO
const val PERMISSION_REQUEST=10

fun checkPermission(activity: AppCompatActivity,permission:String):Boolean{
    return if(Build.VERSION.SDK_INT>=23
        && ContextCompat.checkSelfPermission(activity, permission)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(activity, arrayOf(permission), PERMISSION_REQUEST)
            false
    }else true
}
