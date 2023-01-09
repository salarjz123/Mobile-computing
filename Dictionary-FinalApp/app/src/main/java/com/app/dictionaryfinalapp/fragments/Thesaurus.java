package com.app.dictionaryfinalapp.fragments;

import android.os.Bundle;
import android.app.ProgressDialog;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.dictionaryfinalapp.Adapters.MeaningAdapter;
import com.app.dictionaryfinalapp.OnFetchDataListener;
import com.app.dictionaryfinalapp.R;
import com.app.dictionaryfinalapp.RequestManager;
import com.app.dictionaryfinalapp.model.ApiResponse;

public class Thesaurus extends Fragment {
    ProgressDialog progressDialog;
    TextView textView_word;
    RecyclerView recycler_meanings;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    SearchView searchView;

    public Thesaurus() {
    }
    public static Thesaurus newInstance(String param1, String param2) {
        Thesaurus fragment = new Thesaurus();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Loading");
        progressDialog.show();
        RequestManager manager = new RequestManager(getActivity());
        manager.getWordmeaning(listener, "powerful");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_thesaurus, container, false);
        searchView = rootView.findViewById(R.id.search_view);
        textView_word = rootView.findViewById(R.id.textView_word);
        recycler_meanings = rootView.findViewById(R.id.recycler_meanings);
        return rootView;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressDialog.setTitle("Loading response for " + query);
                progressDialog.show();
                RequestManager manager = new RequestManager(getActivity());
                manager.getWordmeaning(listener, query);
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
    private final OnFetchDataListener listener = new OnFetchDataListener() {
        @Override
        public void onFetchData(ApiResponse apIresponse, String message) {
            progressDialog.dismiss();
            if (apIresponse==null){
                Toast.makeText(getActivity(), "Nothing found", Toast.LENGTH_SHORT).show();
                return;
            }
            showData(apIresponse);
        }

        @Override
        public void onError(String message) {
            progressDialog.dismiss();
            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        }
    };
    private void showData(ApiResponse apIresponse) {
        textView_word.setText("Word: " + apIresponse.getWord());

        recycler_meanings.setHasFixedSize(true);
        recycler_meanings.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        MeaningAdapter meaningAdapter = new MeaningAdapter(getActivity(), apIresponse.getMeanings(),"Synonyms");
        recycler_meanings.setAdapter(meaningAdapter);

    }
}
