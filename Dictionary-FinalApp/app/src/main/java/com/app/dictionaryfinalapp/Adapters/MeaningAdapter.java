package com.app.dictionaryfinalapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.dictionaryfinalapp.R;
import com.app.dictionaryfinalapp.ViewHolders.MeaningsViewHolder;
import com.app.dictionaryfinalapp.model.meanings;

import java.util.List;

public class MeaningAdapter extends RecyclerView.Adapter<MeaningsViewHolder> {
    private final Context context;
    protected List<meanings> meaningsList;
    private final String selectionMode;

    public MeaningAdapter(Context context, List<meanings> meaningsList, String selectionMode) {
        this.context = context;
        this.meaningsList = meaningsList;
        this.selectionMode = selectionMode;
    }

    @NonNull
    @Override
    public MeaningsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MeaningsViewHolder(LayoutInflater.from(context).inflate(R.layout.meanings_list_items, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull MeaningsViewHolder holder, int position) {
        holder.textView_partsOfSpeech.setText("Word type: " + meaningsList.get(position).getPartOfSpeech());
        if (selectionMode == "Synonyms" && !meaningsList.get(position).getSynonyms().isEmpty()){
            holder.textView_synonyms.setVisibility(View.VISIBLE);
            holder.textView_synonyms.setText("Synonyms: " + meaningsList.get(position).getSynonyms());
        }
        else
            holder.textView_synonyms.setVisibility(View.GONE);
        holder.recycler_definitions.setHasFixedSize(true);
        holder.recycler_definitions.setLayoutManager(new GridLayoutManager(context, 1));
        DefinitionAdapter definitionAdapter = new DefinitionAdapter(context, meaningsList.get(position).getDefinitions());
        holder.recycler_definitions.setAdapter(definitionAdapter);
    }

    @Override
    public int getItemCount() {
        return meaningsList.size();
    }
}
