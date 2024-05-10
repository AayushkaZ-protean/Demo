package com.protean.openfinance.utill;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import com.protean.openfinance.service.wrappers.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Component
@Slf4j
public class FileUtils extends BaseService {

    @Autowired
    private HttpServletRequest request;

    @Value("${openfinance.igm.file-upload.base-directory}")
    private String baseDirectoryPath;

    @Value("${openfinance.igm.file-upload.gcp.bucket-name}")
    private String bucketName;

    @Value("${openfinance.igm.file-upload.gcp.project-id}")
    private String projectId;


    public List<String> uploadFilesAndGenerateUrisGoogleCloud(List<MultipartFile> multipartFiles, String igmIssueId) throws IOException {

        List<String> publicUris = new ArrayList<>();

        for (MultipartFile multipartFile : multipartFiles) {

            String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
            String objectName = MessageFormat.format("{0}/{1}-{2}", igmIssueId, String.valueOf(UUID.randomUUID()), fileName);

            // InputStream credsInpStream = getClass().getClassLoader().getResourceAsStream("test-ondc-1bca431bab23.json");
            //InputStream fileInputStream = multipartFile.getInputStream();

            try (InputStream credsInpStream = getClass().getClassLoader().getResourceAsStream("test-ondc-1bca431bab23.json");
                    /*InputStream fileInputStream = multipartFile.getInputStream()*/){

                GoogleCredentials credentials = GoogleCredentials.fromStream(credsInpStream);

                Storage storage = StorageOptions.newBuilder()
                        //.setCredentials(ServiceAccountCredentials.fromStream(new FileInputStream("/Users/anoojj/Downloads/test-ondc-1bca431bab23.json")))
                        .setCredentials(credentials)
                        .setProjectId(projectId)
                        .build()
                        .getService();

                byte[] bytes = multipartFile.getBytes();
                Bucket bucket = storage.get(bucketName);
                Blob blob = bucket.create(objectName, bytes);
                blob.createAcl(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER));

                //String publicUrl = "https://storage.googleapis.com/" + bucketName + "/" + objectName;

                String publicUrl = MessageFormat.format("{0}{1}/{2}", "https://storage.googleapis.com/", bucketName, objectName);

                publicUris.add(publicUrl);

                credsInpStream.close();
                // fileInputStream.close();

            }catch(Exception io) {

                io.printStackTrace();
            }
        }

        return publicUris;

    }
   /* public List<String> uploadFilesAndGenerateUris(List<MultipartFile> multipartFiles, String subDirectoryName) {

        List<String> uris = null;
        try {

            //createDirectoryIfNotExists(baseDirectoryPath, subDirectoryName);
            uris = uploadFiles(baseDirectoryPath, multipartFiles, subDirectoryName);

        } catch (IOException e) {
            throw new GenericException("Error while uploading files");
        }
        return uris;
    }*/

    /*public void createDirectoryIfNotExists(String baseDirectory, String subDirectoryName) throws IOException, IOException {
        Path directoryPath = Paths.get(baseDirectory, subDirectoryName);
        if (!Files.exists(directoryPath)) {
            Files.createDirectories(directoryPath);
            log.info("Directory created: {}", directoryPath);
        }
    }*/

   /* public List<String> uploadFiles(String baseDirectory, List<MultipartFile> multipartFiles, String subDirectoryName) throws IOException {

        List<String> uris = new ArrayList<>();

        for (MultipartFile multipartFile : multipartFiles) {
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
            Path destinationPath = Paths.get(baseDirectory, subDirectoryName, fileName);
            Files.copy(multipartFile.getInputStream(), destinationPath);
            log.info("File uploaded: {}", destinationPath);

            // Generate URI link for the uploaded file
            //String uri = destinationPath.toUri().toString();

            //String uri = constructHttpUri(destinationPath);
            String uri = "https://www.google.com/logos/2023/vday23/rc2/cta.gif";

            log.info("URI for the file: {}", uri);
            uris.add(uri);
        }
        return uris;
    }*/

   /* private String constructHttpUri(Path filePath) throws UnknownHostException {

        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        String contextPath = request.getContextPath();

        String serverBaseUrl = MessageFormat.format("{0}://{1}:{2,number,#}{3}", scheme, serverName, serverPort, contextPath);

        String relativePath = filePath.toString().replace('\\', '/'); // Convert path separator for URL

         String imageHost = getImageHost(relativePath);
        return serverBaseUrl + "/" + relativePath;
    }*/

    /*public String getImageHost(String filePath) throws UnknownHostException {
        Spark.port(9999);

        Spark.get(filePath, (request, response) ->{
            try{

                File imageFile = new File(filePath); // Replace with the path to your image
                FileInputStream inputStream = new FileInputStream(imageFile);

                // Set the content type
                response.type("image/jpeg"); // Change to the appropriate content type for your image format

                // Copy the image to the response's output stream
                OutputStream outputStream = response.raw().getOutputStream();
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                inputStream.close();
                outputStream.close();

            }catch (Exception e){

            }
            return response;
        });
        String ipAddress = InetAddress.getLocalHost().getHostAddress();
        System.out.println("Public URL: http://" + ipAddress + ":9999"+filePath);
        return ipAddress;
    }*/
}
