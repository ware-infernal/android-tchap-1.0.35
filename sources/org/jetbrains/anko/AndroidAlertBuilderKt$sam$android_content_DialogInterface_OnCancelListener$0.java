package org.jetbrains.anko;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 13})
/* compiled from: AndroidAlertBuilder.kt */
final class AndroidAlertBuilderKt$sam$android_content_DialogInterface_OnCancelListener$0 implements OnCancelListener {
    private final /* synthetic */ Function1 function;

    AndroidAlertBuilderKt$sam$android_content_DialogInterface_OnCancelListener$0(Function1 function1) {
        this.function = function1;
    }

    public final /* synthetic */ void onCancel(DialogInterface dialogInterface) {
        Intrinsics.checkExpressionValueIsNotNull(this.function.invoke(dialogInterface), "invoke(...)");
    }
}
