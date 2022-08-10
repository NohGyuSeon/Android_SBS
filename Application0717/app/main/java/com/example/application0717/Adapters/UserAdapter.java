package com.example.application0717.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application0717.R;
import com.example.application0717.VO.User;

import java.util.ArrayList;

// RecyclerView 에 추가할 Adapter 는 RecyclerView 의 Adapter 를 상속
//  - 타입을 구체화해야하며, RecyclerView.ViewHolder 클래스 또는
//    해당 클래스를 상속받은 클래스를 지정
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ItemViewHolder> {
    // User 객체들을 저장하고 있는 저장소
    ArrayList<User> items;

    public UserAdapter(ArrayList<User> items) {
        if(items == null) items = new ArrayList<>();
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // item_user.xml 을 인플레이션하여 레이아웃을 객체화하고
        // ViewHolder 클래스의 객체를 생성하는 메서드

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);

//        ItemViewHolder holder = new ItemViewHolder(itemView);
//        return holder;

        return new ItemViewHolder(itemView);
    }

    // Adapter 내의 저장소에 항목을 추가하기 위한 메서드
    public void addItem(User user) {
        // 저장소에 항목을 추가해도 RecyclerView 에 바로 출력되지 않는다.
        items.add(user);

        // 이를 RecyclerView 에 출력하기 위해 수정된 저장소의 정보를
        // 갱신하여 RecyclerView 에 다시 반영해야한다.
        notifyDataSetChanged();

    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        // ViewHolder 객체에 데이터를 설정하기 위한 메서드

        User item = items.get(position);

        holder.headlineText.setText(item.getId() + "(" + item.getName() + ")"); // Id(Name)
        holder.mailText.setText(item.getMail());
    }

    @Override
    public int getItemCount() {
        // RecyclerView 에 출력할 항목의 수
        return items.size();
    }

    // item_user.xml 에 정의된 뷰들을 미리 탐색하고
    // 저장을 하여 사용하기 위한 Holder 클래스를 정의
    //  - RecyclerView 의 ViewHolder 클래스를 상속
    class ItemViewHolder extends RecyclerView.ViewHolder{
        // item_user.xml 에 정의된 뷰들을
        // 참조할 참조 변수를 선언
        TextView headlineText, mailText;
        
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            // View 들을 참조하기 위해 탐색
            headlineText = itemView.findViewById(R.id.item_userHead);
            mailText = itemView.findViewById(R.id.item_userMail);
        }
    }
}
