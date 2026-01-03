// HostelOwnerActivity.java
package com.example.hostello;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;

public class OwnerDocumentSubmissionActivity extends AppCompatActivity {

    private ImageView ownerProfileImg;
    private TextView ownerNameTxt, hostelNameTxt, hostelAddressTxt, contactTxt, emailTxt;
    private TabLayout tabLayout;
    private RecyclerView imagesRecyclerView;
    private ImageAdapter imageAdapter;

    private List<Integer> roomImages;
    private List<Integer> documentImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_document_submission);

        initializeViews();
        setupData();
        setupRecyclerView();
        setupTabLayout();
    }

    private void initializeViews() {
        ownerProfileImg = findViewById(R.id.ownerProfileImg);
        ownerNameTxt = findViewById(R.id.ownerNameTxt);
        hostelNameTxt = findViewById(R.id.hostelNameTxt);
        hostelAddressTxt = findViewById(R.id.hostelAddressTxt);
        contactTxt = findViewById(R.id.contactTxt);
        emailTxt = findViewById(R.id.emailTxt);
        tabLayout = findViewById(R.id.tabLayout);
        imagesRecyclerView = findViewById(R.id.imagesRecyclerView);
    }

    private void setupData() {
        // Set owner information
        ownerNameTxt.setText("Ahmed Hassan");
        hostelNameTxt.setText("Sunshine Boys Hostel");
        hostelAddressTxt.setText("123 Canal Road, Lahore");
        contactTxt.setText("+92 300 1234567");
        emailTxt.setText("ahmed.hassan@example.com");

        // Initialize room images (replace with your actual drawable resources)
        roomImages = new ArrayList<>();
        roomImages.add(R.drawable.room1);
        roomImages.add(R.drawable.room2);
        roomImages.add(R.drawable.room3);
        roomImages.add(R.drawable.room4);
        roomImages.add(R.drawable.room5);
        roomImages.add(R.drawable.room6);

        // Initialize document images
        documentImages = new ArrayList<>();
        documentImages.add(R.drawable.doc_license);
        documentImages.add(R.drawable.doc_cnic);
        documentImages.add(R.drawable.doc_registration);
        documentImages.add(R.drawable.doc_noc);
    }

    private void setupRecyclerView() {
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        imagesRecyclerView.setLayoutManager(layoutManager);

        imageAdapter = new ImageAdapter(this, roomImages);
        imagesRecyclerView.setAdapter(imageAdapter);
    }

    private void setupTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setText("Room Images"));
        tabLayout.addTab(tabLayout.newTab().setText("Documents"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    imageAdapter.updateImages(roomImages);
                } else {
                    imageAdapter.updateImages(documentImages);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }
}


// ========================================================================
// ImageAdapter.java (CREATE THIS AS A SEPARATE FILE)
// ========================================================================
