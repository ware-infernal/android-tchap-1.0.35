package fr.gouv.tchap.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.NumberPicker;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k = 3, mv = {1, 1, 13})
/* compiled from: RoomRetentionPeriodPickerDialogFragment.kt */
final class RoomRetentionPeriodPickerDialogFragment$create$1 implements OnClickListener {
    final /* synthetic */ NumberPicker $numberPicker;
    final /* synthetic */ Function1 $valueChangeListener;

    RoomRetentionPeriodPickerDialogFragment$create$1(Function1 function1, NumberPicker numberPicker) {
        this.$valueChangeListener = function1;
        this.$numberPicker = numberPicker;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.$valueChangeListener.invoke(Integer.valueOf(this.$numberPicker.getValue()));
    }
}