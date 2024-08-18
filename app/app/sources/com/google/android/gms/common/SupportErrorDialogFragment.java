package com.google.android.gms.common;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public class SupportErrorDialogFragment extends DialogFragment {
    private Dialog zaa;
    private DialogInterface.OnCancelListener zab;
    private Dialog zac;

    public static SupportErrorDialogFragment newInstance(Dialog dialog) {
        return newInstance(dialog, (DialogInterface.OnCancelListener) null);
    }

    public void onCancel(DialogInterface dialog) {
        DialogInterface.OnCancelListener onCancelListener = this.zab;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialog);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.zaa;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.zac == null) {
            this.zac = new AlertDialog.Builder((Context) Preconditions.checkNotNull(getContext())).create();
        }
        return this.zac;
    }

    public void show(FragmentManager manager, String tag) {
        super.show(manager, tag);
    }

    public static SupportErrorDialogFragment newInstance(Dialog dialog, DialogInterface.OnCancelListener cancelListener) {
        SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
        Dialog dialog2 = (Dialog) Preconditions.checkNotNull(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener((DialogInterface.OnCancelListener) null);
        dialog2.setOnDismissListener((DialogInterface.OnDismissListener) null);
        supportErrorDialogFragment.zaa = dialog2;
        if (cancelListener != null) {
            supportErrorDialogFragment.zab = cancelListener;
        }
        return supportErrorDialogFragment;
    }
}
