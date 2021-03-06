package rafsan.abdullah.convertee;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class AboutDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
		LayoutInflater in = getActivity().getLayoutInflater();
		View v = in.inflate(R.layout.dialog_about,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(v)
			.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					dialog.dismiss();
				}
			});
        return builder.create();
    }
}
