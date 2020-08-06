package edu.educationapi.educationapi.bootstrap;

import edu.educationapi.educationapi.domain.*;
import edu.educationapi.educationapi.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@RequiredArgsConstructor
@Component
public class CourseLoader implements CommandLineRunner {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final SectionRepository sectionRepository;
    private final CourseCategoryRepository courseCategoryRepository;
    private final VideoRepository videoRepository;

    InputStream in1 = CourseLoader.class.getResourceAsStream("/videos/video-sample.mp4");
    InputStream in2 = CourseLoader.class.getResourceAsStream("/pictures/spring-boot.png");
    InputStream in3 = CourseLoader.class.getResourceAsStream("/pictures/jira.png");
    InputStream in4 = CourseLoader.class.getResourceAsStream("/pictures/sales.png");

    @Override
    public void run(String... args) throws Exception {
        if(courseRepository.count() == 0){
            loadCourses();
        }
    }

    private void loadCourses() throws IOException {

        CourseCategory cat1 = CourseCategory.builder().courseCategoryName("Yazılım").build();
        CourseCategory cat2 = CourseCategory.builder().courseCategoryName("Pazarlama").build();

        courseCategoryRepository.save(cat1);
        courseCategoryRepository.save(cat2);


        Course c1 = Course.builder()
                .courseName("Java Spring Boot Eğitimi")
                .courseDescription("Java kullanarak Spring Boot öğrenin")
                .coursePicture(in2.readAllBytes())
                .courseCategory(cat1)
                .build();

        Course c2 = Course.builder()
                .courseName("Jira Eğitimi")
                .courseDescription("Jira ile çevik proje yönetimini öğrenin")
                .coursePicture(in3.readAllBytes())
                .courseCategory(cat1)
                .build();

        Course c3 = Course.builder()
                .courseName("Satış ve Pazarlama Eğitimi")
                .courseDescription("Satış ve Pazarlamanın Temellerini Öğrenin")
                .coursePicture(in4.readAllBytes())
                .courseCategory(cat2)
                .build();

       // u1.setCourses(new ArrayList<>());
      //  u1.getCourses().add(c1);
      //  u1.getCourses().add(c2);
      //  u2.setCourses(new ArrayList<>());
       // u2.getCourses().add(c1);

       // c1.setUsers(new ArrayList<>());
       // c1.getUsers().add(u1);
       // c1.getUsers().add(u2);
       // c2.setUsers(new ArrayList<>());
       // c2.getUsers().add(u1);

        courseRepository.save(c1);
        courseRepository.save(c2);
        courseRepository.save(c3);

        User u1 = User.builder()
                .userName("user1")
                .courses(new ArrayList<>())
                .build();
        User u2 = User.builder()
                .userName("user2")
                .courses(new ArrayList<>())
                .build();

        u1.getCourses().add(c1);
        u1.getCourses().add(c2);
        u2.getCourses().add(c1);

        userRepository.save(u1);
        userRepository.save(u2);


        Section s1 = Section.builder().sectionName("Bölüm 1")
                .sectionDescription("Giriş bölümü")
                .course(c1)
                .build();

        sectionRepository.save(s1);

        Video v1 = Video.builder().videoName("Demo video")
                .videoType("mp4")
                .videoData(in1.readAllBytes())
                .section(s1)
                .build();

        videoRepository.save(v1);


        System.out.println("Courses Loaded!");
    }

}
