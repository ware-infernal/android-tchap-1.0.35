package im.vector.view;

import android.view.View;
import android.view.View.OnClickListener;
import im.vector.view.NotificationAreaView.Delegate;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 13})
/* compiled from: NotificationAreaView.kt */
final class NotificationAreaView$renderUnreadPreview$1 implements OnClickListener {
    final /* synthetic */ NotificationAreaView this$0;

    NotificationAreaView$renderUnreadPreview$1(NotificationAreaView notificationAreaView) {
        this.this$0 = notificationAreaView;
    }

    public final void onClick(View view) {
        Delegate delegate = this.this$0.getDelegate();
        if (delegate != null) {
            delegate.closeScreen();
        }
    }
}
