package com.example.millionproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class UsernameDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        // Pass null as the parent view because its going in the dialog layout
        View view = inflater.inflate(R.layout.dialog_username, null);
        final EditText username = view.findViewById(R.id.username);

        builder.setView(view)
                .setPositiveButton(R.string.username_dialog_confirm_btn , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        UsernameDialogListener listener = (UsernameDialogListener) getActivity();
                        listener.onUsernameInput(username.getText().toString());
                    }
                })
                .setNegativeButton(R.string.username_dialog_cancel_btn, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        UsernameDialogFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }

    // username listener interface
    public interface UsernameDialogListener{
        void onUsernameInput(String username);
    }
}
