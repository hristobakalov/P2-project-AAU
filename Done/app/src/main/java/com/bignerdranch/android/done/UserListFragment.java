package com.bignerdranch.android.done;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;                     // from support library
import android.support.v7.widget.LinearLayoutManager;       // from support library
import android.support.v7.widget.RecyclerView;              // from support library
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by michalisgratsias on 03/04/16.
 */
public class UserListFragment extends Fragment {

    private static final String TAG = "DoneActivity";
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
        updateUI();                                     // after a change of Activities, updates UI
    }

<<<<<<< HEAD
=======
    @Override
    public void onCreateOptionsMenu (Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_user_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_new_list:
                mNewList = new List();
                User.get(getActivity()).addUserList(mNewList);
                FragmentManager manager = getFragmentManager();
                ListTitlePickerFragment dialog = new ListTitlePickerFragment(); //shows dialog for new list
                dialog.setTargetFragment(UserListFragment.this, 10);
                dialog.show(manager, DIALOG_LIST_TITLE);
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        if (requestCode == 10) {
            String title = (String) data.getSerializableExtra(ListTitlePickerFragment.EXTRA_TITLE);
            mNewList.setListName(title);
            updateUI();
        }
    }

>>>>>>> MichaelAAU-patch-1
    private void updateUI() {
        User user = User.get(getActivity());            // creates User and its Data if not already there (Singleton)
        ArrayList<List> lists = user.getUserLists();    // gets all Lists of the User
        if (mAdapter == null) {
            mAdapter = new ListAdapter(lists);          // gives lists to adapter
            mListRecyclerView.setAdapter(mAdapter);}    // connects to recycler view
        else {mAdapter.notifyDataSetChanged();}         // if existing, updates data changes
    }

    private class ListHolder extends RecyclerView.ViewHolder implements View.OnClickListener { // viewholder class
        // holds reference to the entire view passed to super(view)
        private TextView mTitleTextView;
        private TextView mCounterTextView;
        private List mList;

        public ListHolder(View itemView) {     // constructor - stashes the views
            super(itemView);
            itemView.setOnClickListener(this);
            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_list_title_text_view);
            mCounterTextView = (TextView) itemView.findViewById(R.id.list_item_list_counter_text_view);
        }

        public void bindList(List list) {                   // list data entered in fragment viewholder
            mList = list;
            mTitleTextView.setText(mList.getListName());
            mCounterTextView.setText("Tasks: " + mList.getListTasks().size());
        }

        @Override
        public void onClick(View v) {
            Intent intent = ListActivity.newIntent(getActivity(), mList.getListId()); //passes listId
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
