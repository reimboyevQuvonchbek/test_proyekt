package uz.quvonchbek.myreadcontact

import android.provider.ContactsContract
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ReadContact {
    public fun getContactList(activity: AppCompatActivity): ArrayList<ContactModel> {
        val contactList=ArrayList<ContactModel>()
        if(checkPermission(activity,READ_CONTACTS)){
            val cursor= activity.contentResolver
                .query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null)
            if(cursor!=null){
                while (cursor.moveToNext()){
                    val name=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                    val number=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                    val newContact=ContactModel()
                    newContact.fullName=name
                    newContact.phoneNumber=number.replace(Regex("[\\s,-]"),"")
                    contactList.add(newContact)
                }
            }
            cursor?.close()
            return contactList
        }else{
            Toast.makeText(activity, "Permission error", Toast.LENGTH_SHORT).show()
            return contactList
        }
    }
}