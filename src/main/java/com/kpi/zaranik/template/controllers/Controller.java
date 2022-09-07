package com.kpi.zaranik.template.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import okhttp3.Headers;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.lang.annotation.Repeatable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
class PersonDTO {
    private String name;
    private Integer age;
    private MultipartFile file;
}


@RestController
public class Controller {

    @PostMapping(path = "/save-person", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person getMethod(PersonDTO personDTO){
        MultipartFile multipartFile = personDTO.getFile();
        try(FileOutputStream fos = new FileOutputStream("src/main/resources/" + personDTO.getName() + "-document.pdf")) {
            fos.write(multipartFile.getBytes());
        } catch (FileNotFoundException e) {
            System.out.println("file src/main/resources/" + multipartFile.getOriginalFilename() + " is now found");
            return Person.builder("eroor", "erorr").build();
        } catch (IOException e) {
            System.out.println("i/o exception");
            return Person.builder("eroor", "erorr").build();
        }
        return Person.builder(personDTO.getName(), "").build();
    }

    @PostMapping(path = "/save-person-servlet")
    public String savePersonServlet(MultipartHttpServletRequest multipartHttpServletRequest){
        Iterator<String> iterator = multipartHttpServletRequest.getParameterNames().asIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(multipartHttpServletRequest.getFileMap().keySet().stream().toList());
        return "ok";
    }


    @PostMapping(path = "/save-file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String saveFile(@RequestParam MultipartFile file) throws IOException {
        FileOutputStream fos = new FileOutputStream("src/main/resources/" + file.getOriginalFilename());
        System.out.println(file.getName());
        fos.write(file.getBytes());
        fos.close();
        return "ok";
    }

    @GetMapping(value = "/get-file", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<?> downloadFile() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("someCode.sql")) {
            return ResponseEntity.status(200)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"file_sql.sql\"")
                    .body(inputStream.readAllBytes());
        } catch (IOException e) {
            return  ResponseEntity.internalServerError().body("io exception caused");
        }

    }


    @PostMapping("/give-me-some-name")
    public ResponseEntity<String> getSomeRandomName(HttpServletRequest request){
        System.out.println( request.getHeader("Content-Type") );
        List<String> names = List.of("Bogdan", "Liza", "Elena", "Nikita", "Vladimir", "Evgenia");
        return ResponseEntity.ok(
                names.get( Math.abs( new Random().nextInt() ) % names.size() )
        );
    }


}
