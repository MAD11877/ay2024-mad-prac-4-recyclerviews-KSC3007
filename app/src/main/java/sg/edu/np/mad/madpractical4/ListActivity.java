package sg.edu.np.mad.madpractical4;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView ivBackground = findViewById(R.id.ivBackground);
        final Random random = new Random();

        ivBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the object of AlertDialog Builder class
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);

                // Set the message show for the Alert time
                builder.setMessage("MADness");

                // Set Alert Title
                builder.setTitle("Profile");

                // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                builder.setCancelable(false);

                builder.setPositiveButton("Close", (DialogInterface.OnClickListener) (dialog, which) -> {
                    dialog.cancel();
                });

                builder.setNegativeButton("View", (DialogInterface.OnClickListener) (dialog, which) -> {
                    Intent intent = new Intent(ListActivity.this, MainActivity.class);
                    String randomNumber = String.valueOf(random.nextInt(999999));
                    intent.putExtra("MAD", randomNumber);
                    startActivity(intent);
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
}