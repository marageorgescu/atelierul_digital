package com.example.journaltheworld;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class StartJournalingActivity extends AppCompatActivity {

    private SQLiteDatabaseHandler db;

    ImageView imageView;
    Button cameraButton;
    Button galleryButton;

    public static final int CAMERA_CODE = 101;
    public static final int CAMERA_REQUEST_CODE = 102;
    public static final int GALLERY_REQUEST_CODE = 105;

    String currentPhotoPath;

    byte[] inputData;

    File f;

    StorageReference storageReference;

    String imageUri;

    EditText locationEditText;

    final Calendar myCalendar = Calendar.getInstance();
    EditText dateEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startjournaling_activity);

        imageView = findViewById(R.id.startJournalingActivityImageView);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.imageholder2, null));
        cameraButton = findViewById(R.id.startJournalingActivityCameraButton);
        galleryButton = findViewById(R.id.startJournalingActivityGalleryButton);

        storageReference = FirebaseStorage.getInstance().getReference();

        locationEditText = findViewById(R.id.startJournalingActivityLocation);
        locationEditText.addTextChangedListener(new addListenerOnTextChange(this, locationEditText));

        dateEditText = findViewById(R.id.startJournalingActivityDate);
        dateEditText.setInputType(InputType.TYPE_NULL);
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        dateEditText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(StartJournalingActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameraPermission();
            }
        });

        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(gallery, GALLERY_REQUEST_CODE);
            }
        });

    }

    private void cameraPermission() {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA}, CAMERA_CODE);
        }
        else
        {
            dispatchTakePictureIntent();
        }

    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        dateEditText.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == CAMERA_CODE)
        {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                dispatchTakePictureIntent();
            }
            else
            {
                Toast.makeText(StartJournalingActivity.this, "Camera Permission is Required", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public static byte[] getBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];

        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, len);
        }
        return byteBuffer.toByteArray();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK)
            {
                f = new File(currentPhotoPath);
                Uri contentUri = Uri.fromFile(f);
                imageView.setImageURI(contentUri);

                uploadImageToFirebase(f.getName(), contentUri);

            }
        }

        if (requestCode == GALLERY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK)
            {
                Uri contentUri = data.getData();
                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String imageFileName = "JPEG_" + timeStamp + "." + getFileExt(contentUri);
                imageView.setImageURI(contentUri);

                uploadImageToFirebase(imageFileName, contentUri);

                /*InputStream iStream = null;
                try {
                    iStream = getContentResolver().openInputStream(contentUri);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    inputData = getBytes(iStream);
                } catch (IOException e) {
                    e.printStackTrace();
                }*/

            }
        }

    }

    private void uploadImageToFirebase(String name, Uri contentUri) {

        final StorageReference image = storageReference.child("pictures/" + name);
        image.putFile(contentUri).addOnSuccessListener((OnSuccessListener) (taskSnapshot) -> {
            image.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    Log.d("tag", "onSuccess: Uploaded image URI is: " + uri.toString());

                    imageUri = uri.toString();

                }
            });
            Toast.makeText(StartJournalingActivity.this, "Image is Uploaded.", Toast.LENGTH_SHORT).show();
        }).addOnFailureListener((e) -> {
            Toast.makeText(StartJournalingActivity.this, "Upload Failed.", Toast.LENGTH_SHORT).show();
        });

    }

    private String getFileExt(Uri contentUri) {
        ContentResolver c = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(c.getType(contentUri));
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File

            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, CAMERA_REQUEST_CODE);
            }
        }
    }



    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        db = new SQLiteDatabaseHandler(this);
        EditText titleEditText = findViewById(R.id.startJournalingActivityTitleTextView);
        EditText storyEditText = findViewById(R.id.startJournalingActivityStoryView);
        JournalStory journalStory = new JournalStory(titleEditText.getText().toString(), imageUri, dateEditText.getText().toString(), " " + locationEditText.getText().toString(), storyEditText.getText().toString());
        db.addJournalStory(journalStory);

        /*EditText titleEditText = findViewById(R.id.startJournalingActivityTitleTextView);
        EditText storyEditText = findViewById(R.id.startJournalingActivityStoryView);
        Intent intent = new Intent();
        intent.putExtra("titleFromStartJournalingActivity", titleEditText.getText().toString());
        intent.putExtra("imageFromStartJournalingActivity", inputData);
        intent.putExtra("storyFromStartJournalingActivity", storyEditText.getText().toString());
        setResult(Activity.RESULT_OK, intent);*/

    }


}
