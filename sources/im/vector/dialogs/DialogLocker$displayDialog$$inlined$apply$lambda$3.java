package im.vector.dialogs;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss", "im/vector/dialogs/DialogLocker$displayDialog$1$3"}, k = 3, mv = {1, 1, 13})
/* compiled from: DialogLocker.kt */
final class DialogLocker$displayDialog$$inlined$apply$lambda$3 implements OnDismissListener {
    final /* synthetic */ DialogLocker this$0;

    DialogLocker$displayDialog$$inlined$apply$lambda$3(DialogLocker dialogLocker) {
        this.this$0 = dialogLocker;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.this$0.unlock();
    }
}
