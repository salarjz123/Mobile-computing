package com.app.dictionaryfinalapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.dictionaryfinalapp.R;
import com.app.dictionaryfinalapp.ViewHolders.DefinitionViewHolder;
import com.app.dictionaryfinalapp.model.definitions;

import java.util.List;

public class DefinitionAdapter extends RecyclerView.Adapter<DefinitionViewHolder> {

    private Context context;
    private List<definitions> definitionsList;

    public DefinitionAdapter(Context context, List<definitions> definitionsList) {
        this.context = context;
        this.definitionsList = definitionsList;
    }

    @NonNull
    @Override
    public DefinitionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DefinitionViewHolder(LayoutInflater.from(context).inflate(R.layout.definitions_list_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DefinitionViewHolder holder, int position) {
        holder.textView_definition.setText("Meaning: " + definitionsList.get(position).getDefinition());
        StringBuilder synonyms = new StringBuilder();

        synonyms.append(definitionsList.get(position).getSynonyms());

        holder.textView_synonyms.setText(synonyms);

        holder.textView_synonyms.setSelected(true);
    }

    @Override
    public int getItemCount() {
        return definitionsList.size();
    }



}
