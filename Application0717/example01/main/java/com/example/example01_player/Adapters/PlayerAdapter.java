package com.example.example01_player.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.example01_player.R;
import com.example.example01_player.VO.Player;

import java.util.ArrayList;
import java.util.Collections;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ItemViewHolder>{
    // 플레이어의 정보를 저장하는 저장소
    ArrayList<Player> items;

    public PlayerAdapter(ArrayList<Player> items) {
        if(items == null) items = new ArrayList<>();
        this.items = items;
    }

    public void addScore(Player player) {
        if(player == null) return;
        items.add(player);

        // 새로운 플레이어의 점수가 추가됐기 때문에
        // 정렬을 다시 해야한다.
        Collections.sort(items);

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_player, parent, false);

        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Player player = items.get(position);
        holder.playerNameText.setText(player.getName());
        holder.scoreText.setText(player.getScore() + "점");
    }

    @Override
    public int getItemCount() {
        // 모든 플레이어들을 출력
        // return items.size();

        // 상위 10 명을 출력
        //  단, 저장된 플레이어의 수가 10명이 안되면 오류가 발생
        // return 10;


        // 저장된 플레이어의 수가 10명 미만이면 플레이어의 수만큼 출력하고
        // 10명 이상이면 상위 10명만 출력
        return (items.size() < 10) ? items.size() : 10;
    }


    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView playerNameText, scoreText;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            playerNameText = itemView.findViewById(R.id.item_player_name);
            scoreText = itemView.findViewById(R.id.item_score);
        }
    }
}
