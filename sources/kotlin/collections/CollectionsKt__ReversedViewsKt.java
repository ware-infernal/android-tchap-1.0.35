package kotlin.collections;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¢\u0006\u0002\b\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\b\u001a\u001d\u0010\t\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\n¨\u0006\u000b"}, d2 = {"asReversed", "", "T", "", "asReversedMutable", "reverseElementIndex", "", "index", "reverseElementIndex$CollectionsKt__ReversedViewsKt", "reversePositionIndex", "reversePositionIndex$CollectionsKt__ReversedViewsKt", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, xi = 1, xs = "kotlin/collections/CollectionsKt")
/* compiled from: ReversedViews.kt */
class CollectionsKt__ReversedViewsKt extends CollectionsKt__MutableCollectionsKt {
    /* access modifiers changed from: private */
    public static final int reverseElementIndex$CollectionsKt__ReversedViewsKt(List<?> list, int i) {
        int lastIndex = CollectionsKt.getLastIndex(list);
        if (i >= 0 && lastIndex >= i) {
            return CollectionsKt.getLastIndex(list) - i;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Element index ");
        sb.append(i);
        sb.append(" must be in range [");
        sb.append(new IntRange(0, CollectionsKt.getLastIndex(list)));
        sb.append("].");
        throw new IndexOutOfBoundsException(sb.toString());
    }

    /* access modifiers changed from: private */
    public static final int reversePositionIndex$CollectionsKt__ReversedViewsKt(List<?> list, int i) {
        int size = list.size();
        if (i >= 0 && size >= i) {
            return list.size() - i;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Position index ");
        sb.append(i);
        sb.append(" must be in range [");
        sb.append(new IntRange(0, list.size()));
        sb.append("].");
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public static final <T> List<T> asReversed(List<? extends T> list) {
        Intrinsics.checkParameterIsNotNull(list, "$this$asReversed");
        return new ReversedListReadOnly<>(list);
    }

    public static final <T> List<T> asReversedMutable(List<T> list) {
        Intrinsics.checkParameterIsNotNull(list, "$this$asReversed");
        return new ReversedList<>(list);
    }
}
