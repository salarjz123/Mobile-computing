package com.app.dictionaryfinalapp.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.dictionaryfinalapp.R;

public class MeaningsViewHolder extends RecyclerView.ViewHolder {
    public TextView textView_partsOfSpeech;
    public TextView textView_synonyms;
    public RecyclerView recycler_definitions;
    public MeaningsViewHolder(@NonNull View itemView) {
        super(itemView);
        textView_partsOfSpeech = itemView.findViewById(R.id.textView_partsOfSpeech);
        textView_synonyms = itemView.findViewById(R.id.textView_synonyms);
        recycler_definitions = itemView.findViewById(R.id.recycler_definitions);

    }
}
