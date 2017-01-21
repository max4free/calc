package com.example.max.lessoncontextmenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textSize, textColor;

    final int MENU_COLOR_RED = 1;
    final int MENU_COLOR_BLUE = 2;
    final int MENU_COLOR_GREEN = 3;
    final int MENU_SIZE_22 = 22;
    final int MENU_SIZE_26 = 26;
    final int MENU_SIZE_30 = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textColor = (TextView) findViewById(R.id.textView2);
        textSize = (TextView) findViewById(R.id.textView3);

        registerForContextMenu(textColor);
        registerForContextMenu(textSize);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        /*switch (v.getId())
        {
            case R.id.textView2:
                menu.add(0, MENU_COLOR_BLUE, 0, "Голубой");
                menu.add(0, MENU_COLOR_GREEN, 0, "Зеленоватый");
                menu.add(0, MENU_COLOR_RED, 0, "Червоный");
                break;
            case R.id.textView3:
                menu.add(0, MENU_SIZE_22, 0, "22");
                menu.add(0, MENU_SIZE_26, 0, "26");
                menu.add(0, MENU_SIZE_30, 0, "30");
                break;
        }*/
        switch (v.getId())
        {
            case R.id.textView2:
                getMenuInflater().inflate(R.menu.context_menu_color, menu);
                break;
            case R.id.textView3:
                getMenuInflater().inflate(R.menu.context_menu_size, menu);
                break;
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int id = item.getItemId();
//        switch (item.getItemId()) // обработка программного меню
//        {
//            case MENU_COLOR_BLUE:
//                textColor.setTextColor(Color.BLUE);
//                break;
//            case MENU_COLOR_GREEN:
//                textColor.setTextColor(Color.GREEN);
//                break;
//            case MENU_COLOR_RED:
//                textColor.setTextColor(Color.RED);
//                break;
//            case MENU_SIZE_22:
//                textSize.setTextSize(22);
//                break;
//            case MENU_SIZE_26:
//                textSize.setTextSize(26);
//                break;
//            case MENU_SIZE_30:
//                textSize.setTextSize(30);
//                break;
//
//        }

        //обработка меню из xml
        if (id == R.id.color_blue)
            textColor.setTextColor(Color.BLUE);
        else if (id == R.id.color_green)
            textColor.setTextColor(Color.GREEN);
        else if (id == R.id.color_red)
            textColor.setTextColor(Color.RED);
        else if (id == R.id.size_30)
            textSize.setTextSize(30);
        else if (id == R.id.size_36)
            textSize.setTextSize(36);
        else if (id == R.id.size_45)
            textSize.setTextSize(45);
        return super.onContextItemSelected(item);
    }
}
