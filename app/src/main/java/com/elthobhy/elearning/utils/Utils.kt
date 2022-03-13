import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.elthobhy.elearning.databinding.LayoutDialogErrorBinding
import com.elthobhy.elearning.databinding.LayoutDialogLoadingBinding
import com.elthobhy.elearning.databinding.LayoutDialogSuccessBinding

fun View.visible(){
    visibility = View.VISIBLE
}

fun View.gone(){
    visibility = View.GONE
}

fun View.invisible(){
    visibility = View.INVISIBLE
}

fun View.disable(){
    isEnabled = false
}

fun View.enabled(){
    isEnabled = true
}

fun showDialogLoading(context: Context): AlertDialog {
    val dialogView = LayoutDialogLoadingBinding.inflate(LayoutInflater.from(context))
    return AlertDialog
        .Builder(context)
        .setView(dialogView.root)
        .setCancelable(false)
        .create()
}

fun showDialogSuccess(context: Context, message: String): AlertDialog{
    val dialogView = LayoutDialogSuccessBinding.inflate(LayoutInflater.from(context))
    dialogView.tvMessage.text = message
    return AlertDialog
        .Builder(context)
        .setView(dialogView.root)
        .setCancelable(true)
        .create()
}

fun showDialogError(context: Context, message: String) {
    val dialogView = LayoutDialogErrorBinding.inflate(LayoutInflater.from(context))
    dialogView.tvMessage.text = message
    AlertDialog
        .Builder(context)
        .setView(dialogView.root)
        .setCancelable(true)
        .create()
        .show()
}
fun hideSoftKeyboard(context: Context, view: View) {
    val imm = context.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}