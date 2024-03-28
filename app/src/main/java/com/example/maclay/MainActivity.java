package com.example.maclay;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Récupération du grand bloc ConstraintLayout
        ConstraintLayout grandBloc = findViewById(R.id.presentation);
        // Dupliquer le grand bloc selon vos besoins
        duplicaterBloc(grandBloc);

    }
    private void duplicaterBloc(ConstraintLayout grandBloc) {
        // Création d'une nouvelle instance de ConstraintLayout
        ConstraintLayout nouveauBloc = new ConstraintLayout(this);

        // Définir les paramètres de mise en page pour le nouveau bloc
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        // Appliquer les paramètres de mise en page au nouveau bloc
        nouveauBloc.setLayoutParams(layoutParams);

        // Ajouter le nouveau bloc à la vue parent (dans ce cas, le grand bloc)
        grandBloc.addView(nouveauBloc);

        // Vous pouvez maintenant personnaliser le contenu du nouveau bloc selon vos besoins
        // Par exemple, vous pouvez ajouter des vues enfants au nouveau bloc, définir des contraintes, etc.
    }
}