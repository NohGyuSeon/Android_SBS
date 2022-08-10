package com.example.application0724;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.application0724.VO.Book;

import java.util.ArrayList;


// View 전환을 위한 RecyclerView.Adapter 를 구현
class BookPageAdapter extends RecyclerView.Adapter<BookPageAdapter.ItemViewHolder>{
    ArrayList<Book> items;

    public BookPageAdapter() {
        this(null);
    }

    public BookPageAdapter(ArrayList<Book> items) {
        if(items == null) items = new ArrayList<>();
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Book book = items.get(position);
        holder.titleText.setText(book.getTitle());
        holder.genreText.setText(book.getGenre());
        Log.i("thumbnail resource id", book.getThumbnailRes()+"");
        holder.thumbnailImg.setBackgroundResource(book.getThumbnailRes());
        holder.iconImg.setBackgroundResource(book.getIconRes());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView titleText, genreText;
        ImageView thumbnailImg, iconImg;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.item_title);
            genreText = itemView.findViewById(R.id.item_genre);
            thumbnailImg = itemView.findViewById(R.id.item_thumbnail);
            iconImg = itemView.findViewById(R.id.item_icon);
        }
    }
}

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager;
    BookPageAdapter adapter;
    ArrayList<Book> books = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        books.add(new Book("Book1" , "Genre1", R.drawable.photo1, R.drawable.dummy_image_100x100));
        books.add(new Book("Book2" , "Genre2", R.drawable.photo2, R.drawable.dummy_image_100x100));
        books.add(new Book("Book3" , "Genre3", R.drawable.photo3, R.drawable.dummy_image_100x100));
        books.add(new Book("Book4" , "Genre4", R.drawable.photo4, R.drawable.dummy_image_100x100));
        books.add(new Book("Book5" , "Genre5", R.drawable.photo5, R.drawable.dummy_image_100x100));

        adapter = new BookPageAdapter(books);
        viewPager = findViewById(R.id.main_viewpager);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);

    }
}