package com.app.dictionaryfinalapp.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.dictionaryfinalapp.R;

public class DefinitionViewHolder extends RecyclerView.ViewHolder {
    public TextView textView_definition, textView_synonyms;
    public DefinitionViewHolder(@NonNull View itemView) {
        super(itemView);
        textView_definition = itemView.findViewById(R.id.textView_definition);
        textView_synonyms = itemView.findViewById(R.id.textView_synonyms);
    }
}
