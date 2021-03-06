package com.example.itachi.com.pab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CAKE extends Fragment {
    /////////////*********************REFERING VARIABLES*********************/////////////////////////
    private RecyclerView recyclerview;
    private  ListViewAdaptor adaptor;
    ArrayList<Data> info;
    DatabaseReference mref,about;
    public CAKE() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cake, container, false);
        recyclerview = (RecyclerView) view.findViewById(R.id.listrecyclerview);

        /////////////////////////////////////////////////******FIREBASE******************///\\\\\\\\\\\\\\\\\\\\\\///////////
        info = new ArrayList<>();
        mref = FirebaseDatabase.getInstance().getReference("Cakes");
        about = FirebaseDatabase.getInstance().getReference("About");


        mref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Data a = dataSnapshot.getValue(Data.class);
                Log.v("data","added");
                info.add(a);
                ///////////////////////******************setting up the adapter***********////////////////////////////
                adaptor = new ListViewAdaptor(getActivity(),info);
                recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerview.hasFixedSize();
                recyclerview.setAdapter(adaptor);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return  view;
    }

}
