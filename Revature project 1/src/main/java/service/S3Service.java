/*package service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;

import java.io.File;

public class S3Service {
    private String awsId = "+LRprSjyx6NvxxBUtcwPusZw8heNRyeTi+/namxv";
    private String secretKey = "+LRprSjyx6NvxxBUtcwPusZw8heNRyeTi+/namxv";
    private String region = "US East (N. Virginia) us-east-1";
    private String bucketName = "jyc3bucket";


    public void uploadFile(File file){

        //Prepareing our credentials for the next statement
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials (awsId, secretKey);

        //Create connection with the s3 client
        AmazonS3 s3Client = Amazons3ClientBuilder
                .standard()
                .withRegion(Regions.fromName(region))
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();

        //We are referencing the "s3Client" bucket name, the image
        s3Client.putObject(bucketName, "images/" + file.getName(), file);

        app.post("/upload", context -> {

            UploadedFile uploadedFile = context.uploadedFile("file");
            File file = new File("uploads/" + uploadedFile.getFilename());

            S3Service s3Service = new S3Service();
            s3Service.uploadFile(file);

            context.result("file sent to s3");
        });
    }


}*/
