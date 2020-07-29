package edu.educationapi.educationapi.services;

import edu.educationapi.educationapi.domain.Course;
import edu.educationapi.educationapi.domain.CourseCategory;
import edu.educationapi.educationapi.mappers.CourseMapper;
import edu.educationapi.educationapi.model.CourseDto;
import edu.educationapi.educationapi.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;



    @Override
    public CourseDto getById(Long courseId) {
        return CourseDto.builder()
                .courseId(courseId)
                .courseName("Java Spring Boot Eğitimi")
                .description("Java kullanarak Spring Boot öğrenin")
                .courseCategory(CourseCategory.YAZILIM)
                .build();
    }

    @Override
    public CourseDto savedNewCourse(CourseDto courseDto) {
        return null;
    }

    @Override
    public CourseDto updateCourse(Long courseId, CourseDto courseDto) {
        return null;
    }
}
