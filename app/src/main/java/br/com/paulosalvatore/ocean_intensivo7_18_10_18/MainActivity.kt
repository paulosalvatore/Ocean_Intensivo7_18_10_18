package br.com.paulosalvatore.ocean_intensivo7_18_10_18

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.telephony.PhoneNumberUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URLEncoder


class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		textView.setOnClickListener {
			/*val intent = Intent("android.intent.action.MAIN")
			intent.component = ComponentName("com.whatsapp", "com.whatsapp.Conversation")
			val telefone = PhoneNumberUtils.stripSeparators("55 11 97185-8979") + "@s.whatsapp.net"
			intent.putExtra("teste_api_whatsapp", telefone)
			startActivity(intent)

//			Toast.makeText(this, "Clicado", Toast.LENGTH_LONG).show()
			Toast.makeText(this, telefone, Toast.LENGTH_LONG).show()*/

			val telefone = PhoneNumberUtils.stripSeparators("55 11 97185-8979") + "@s.whatsapp.net"
			/*try {
				val sendIntent = Intent("android.intent.action.MAIN")
				sendIntent.component = ComponentName("com.whatsapp", "com.whatsapp.Conversation")
				sendIntent.action = Intent.ACTION_SEND
				sendIntent.type = "text/plain"
				sendIntent.putExtra(Intent.EXTRA_TEXT, "teste")
				sendIntent.putExtra("jid", "$telefone@s.whatsapp.net")
				sendIntent.setPackage("com.whatsapp")
				this.startActivity(sendIntent)
			} catch (e: Exception) {
				Toast.makeText(this, "Error/n" + e.toString(), Toast.LENGTH_SHORT).show()
			}*/

			try {
				val packageManager = this.getPackageManager()
				val i = Intent(Intent.ACTION_VIEW)
				val url = "https://api.whatsapp.com/send?phone=" + telefone + "&text=" + URLEncoder.encode("Mensagem", "UTF-8")
				i.setPackage("com.whatsapp")
				i.data = Uri.parse(url)
				if (i.resolveActivity(packageManager) != null) {
					this.startActivity(i)
				}
			} catch (e: Exception) {
				e.printStackTrace()
			}

			/*val c = this.getContentResolver().query(ContactsContract.Data.CONTENT_URI,
					arrayOf(ContactsContract.Contacts.Data._ID), ContactsContract.Data.DATA1 + "=?",
					arrayOf<String>("asd"), null)
			c.moveToFirst()
			val i = Intent(Intent.ACTION_VIEW, Uri.parse("content://com.android.contacts/data/" + c.getString(0)))

			startActivity(i)
			c.close()*/

			/*val waIntent = Intent(Intent.ACTION_SEND)
			waIntent.type = "text/plain"
			val text = "YOUR TEXT HERE"
			waIntent.setPackage("com.whatsapp")
			waIntent.putExtra(Intent.EXTRA_TEXT, text)//
			startActivity(Intent.createChooser(waIntent, "Share with"))*/

			/*val sendIntent = Intent("android.intent.action.SEND")
			val f = File("path to the file")
			val uri = Uri.fromFile(f)
			sendIntent.component = ComponentName("com.whatsapp", "com.whatsapp.ContactPicker")
			sendIntent.type = "image"
			sendIntent.putExtra(Intent.EXTRA_STREAM, uri)
			sendIntent.putExtra("jid", PhoneNumberUtils.stripSeparators("919xxxxxxxxx") + "@s.whatsapp.net")
			sendIntent.putExtra(Intent.EXTRA_TEXT, "sample text you want to send along with the image")
			startActivity(sendIntent)*/

			/*try {
				val sendIntent = Intent("android.intent.action.MAIN")
				sendIntent.action = Intent.ACTION_SEND
				sendIntent.type = "text/plain"
				sendIntent.putExtra(Intent.EXTRA_TEXT, "")
				sendIntent.putExtra("jid", telefone + "@s.whatsapp.net") //phone number without "+" prefix
				sendIntent.setPackage("com.whatsapp")
				startActivity(sendIntent)
			} catch (e: Exception) {
				Toast.makeText(this, "Error/n" + e.toString(), Toast.LENGTH_SHORT).show()
			}*/

		}
	}
}
