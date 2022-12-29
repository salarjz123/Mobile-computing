package com.app.dictionaryfinalapp.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.app.dictionaryfinalapp.Adapters.MeaningAdapter;
import com.app.dictionaryfinalapp.Adapters.PhoneticsAdapter;
import com.app.dictionaryfinalapp.OnFetchDataListener;
import com.app.dictionaryfinalapp.R;
import com.app.dictionaryfinalapp.RequestManager;
import com.app.dictionaryfinalapp.model.ApiResponse;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Dictionary#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Dictionary extends Fragment {

    ProgressDialog progressDialog;
    SearchView search_view;
    TextView textView_word;
    RecyclerView recycler_phonetics, recycler_meanings;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    SearchView searchView;

    public Dictionary() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Dictionary.
     */
    // TODO: Rename and change types and number of parameters
    public static Dictionary newInstance(String param1, String param2) {
        Dictionary fragment = new Dictionary();
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
        manager.getWordmeaning(listener, "hello");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_dictionary, container, false);
        searchView = rootView.findViewById(R.id.search_view);
        textView_word = rootView.findViewById(R.id.textView_word);
        recycler_phonetics = rootView.findViewById(R.id.recycler_phonetics);
        recycler_meanings = rootView.findViewById(R.id.recycler_meanings);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onViewCreated(view, savedInstanceState);



        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
// do something on text submit
                progressDialog.setTitle("Loading response " + query);
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
//        recycler_phonetics.setHasFixedSize(true);
//        recycler_phonetics.setLayoutManager(new GridLayoutManager(getActivity(), 1));
//        PhoneticsAdapter phoneticsAdapter = new PhoneticsAdapter(getActivity(), apIresponse.getPhonetics());
//        recycler_phonetics.setAdapter(phoneticsAdapter);

        recycler_meanings.setHasFixedSize(true);
        recycler_meanings.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        MeaningAdapter meaningAdapter = new MeaningAdapter(getActivity(), apIresponse.getMeanings());
        recycler_meanings.setAdapter(meaningAdapter);

    }

}