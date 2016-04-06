package com.bignerdranch.android.done;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;                     // from support library
import android.support.v7.widget.LinearLayoutManager;       // from support library
import android.support.v7.widget.RecyclerView;              // from support library
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by michalisgratsias on 03/04/16.
 */
public class UserListFragment extends Fragment {

    private RecyclerView mListRecyclerView;        // RecyclerView creates only enough views to fill the screen and scrolls them
    private ListAdapter mAdapter;                  // Adapter controls the data to be displayed by RecyclerView

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_list, container, false);
        mListRecyclerView = (RecyclerView)view.findViewById(R.id.lists_recycler_view);
        mListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));    // handles the
        updateUI();     // sets up the UI                     // positioning of items and defines the scrolling behaviour
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        User user = User.get(getActivity());
        ArrayList<List> lists = user.getUserLists();
        if (mAdapter == null) {
            mAdapter = new ListAdapter(lists);
            mListRecyclerView.setAdapter(mAdapter);}
        else {mAdapter.notifyDataSetChanged();}
    }

    private class ListHolder extends RecyclerView.ViewHolder implements View.OnClickListener { // viewholder class
                                                        // holds reference to the entire view passed to super(view)
        private TextView mTitleTextView;
        private List mList;

        public ListHolder(View itemView) {     // constructor - stashes the views
            super(itemView);
            itemView.setOnClickListener(this);
            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_list_title_text_view);
        }

        public void bindList(List list) {
            mList = list;
            mTitleTextView.setText(mList.getListName());
        }

        @Override
        public void onClick(View v) {
            Intent intent = ListActivity.newIntent(getActivity(), mList.getListId());
            startActivity(intent);
        }
    }

    private class ListAdapter extends RecyclerView.Adapter<ListHolder> {  // adapter class
                                                    // creates needed viewholders, binds them to the data
        private ArrayList<List> mLists;

        public ListAdapter(ArrayList<List> lists) {        // constructor
            mLists = lists;
        }

        @Override
        public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {              // needs new view
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.lists_item, parent, false);         // creates view
            return new ListHolder(view);                                                   // wraps it in a viewholder
        }

        @Override
        public void onBindViewHolder(ListHolder holder, int position) { // binds viewholder's view to a model object
            List list = mLists.get(position);
            holder.bindList(list);
        }

        @Override
        public int getItemCount() {
            return mLists.size();
        }
    }


}