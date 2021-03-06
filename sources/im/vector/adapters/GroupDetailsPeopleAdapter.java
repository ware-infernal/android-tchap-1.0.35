package im.vector.adapters;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import fr.gouv.tchap.a.R;
import im.vector.util.GroupUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.matrix.androidsdk.rest.model.group.GroupUser;

public class GroupDetailsPeopleAdapter extends AbsAdapter {
    private static final int TYPE_INVITED_USERS = 13;
    private static final int TYPE_JOINED_USERS = 12;
    private static final Comparator<GroupUser> mComparator = new Comparator<GroupUser>() {
        public int compare(GroupUser groupUser, GroupUser groupUser2) {
            return groupUser.getDisplayname().compareTo(groupUser2.getDisplayname());
        }
    };
    private final GroupAdapterSection<GroupUser> mInvitedUsersSection;
    private final GroupAdapterSection<GroupUser> mJoinedUsersSection;
    /* access modifiers changed from: private */
    public final OnSelectUserListener mListener;

    public interface OnSelectUserListener {
        void onSelectItem(GroupUser groupUser, int i);
    }

    public GroupDetailsPeopleAdapter(Context context, OnSelectUserListener onSelectUserListener) {
        super(context);
        this.mListener = onSelectUserListener;
        GroupAdapterSection groupAdapterSection = new GroupAdapterSection(context, context.getString(R.string.joined), -1, R.layout.adapter_item_group_user_room_view, -2, 12, new ArrayList(), mComparator);
        this.mJoinedUsersSection = groupAdapterSection;
        this.mJoinedUsersSection.setEmptyViewPlaceholder(context.getString(R.string.no_users_placeholder), context.getString(R.string.no_result_placeholder));
        GroupAdapterSection groupAdapterSection2 = new GroupAdapterSection(context, context.getString(R.string.invited), -1, R.layout.adapter_item_group_user_room_view, -2, 13, new ArrayList(), mComparator);
        this.mInvitedUsersSection = groupAdapterSection2;
        this.mInvitedUsersSection.setEmptyViewPlaceholder(context.getString(R.string.no_users_placeholder), context.getString(R.string.no_result_placeholder));
        this.mInvitedUsersSection.setIsHiddenWhenEmpty(true);
        addSection(this.mJoinedUsersSection);
        addSection(this.mInvitedUsersSection);
    }

    /* access modifiers changed from: protected */
    public ViewHolder createSubViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i == 12 || i == 13) {
            return new GroupUserViewHolder(from.inflate(R.layout.adapter_item_group_user_room_view, viewGroup, false));
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void populateViewHolder(int i, ViewHolder viewHolder, int i2) {
        if (i == 12 || i == 13) {
            GroupUserViewHolder groupUserViewHolder = (GroupUserViewHolder) viewHolder;
            final GroupUser groupUser = (GroupUser) getItemForPosition(i2);
            groupUserViewHolder.populateViews(this.mContext, this.mSession, groupUser);
            groupUserViewHolder.itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    GroupDetailsPeopleAdapter.this.mListener.onSelectItem(groupUser, -1);
                }
            });
        }
    }

    /* access modifiers changed from: 0000 */
    public int filterGroupUsersSection(AdapterSection<GroupUser> adapterSection, String str) {
        if (adapterSection == null) {
            return 0;
        }
        if (!TextUtils.isEmpty(str)) {
            adapterSection.setFilteredItems(GroupUtils.getFilteredGroupUsers(adapterSection.getItems(), str), str);
        } else {
            adapterSection.resetFilter();
        }
        return adapterSection.getFilteredItems().size();
    }

    /* access modifiers changed from: protected */
    public int applyFilter(String str) {
        return filterGroupUsersSection(this.mJoinedUsersSection, str) + 0 + filterGroupUsersSection(this.mInvitedUsersSection, str);
    }

    public void setJoinedGroupUsers(List<GroupUser> list) {
        this.mJoinedUsersSection.setItems(list, this.mCurrentFilterPattern);
        if (!TextUtils.isEmpty(this.mCurrentFilterPattern)) {
            filterGroupUsersSection(this.mJoinedUsersSection, String.valueOf(this.mCurrentFilterPattern));
        }
        updateSections();
    }

    public void setInvitedGroupUsers(List<GroupUser> list) {
        this.mInvitedUsersSection.setItems(list, this.mCurrentFilterPattern);
        if (!TextUtils.isEmpty(this.mCurrentFilterPattern)) {
            filterGroupUsersSection(this.mInvitedUsersSection, String.valueOf(this.mCurrentFilterPattern));
        }
        updateSections();
    }
}
